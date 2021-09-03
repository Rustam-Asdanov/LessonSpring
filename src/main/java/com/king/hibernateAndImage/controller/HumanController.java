package com.king.hibernateAndImage.controller;

import com.king.hibernateAndImage.model.Human;
import com.king.hibernateAndImage.repository.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.UUID;
import java.util.function.Predicate;

@Controller
@RequestMapping("/fileImage")
public class HumanController {

    private String pathFolder = "/Users/Rustam/Desktop/Learning programing/Backend project/LessonSpring/src/main/webapp/WEB-INF/images/";

    @Autowired
    private HumanRepository humanRepository;

    @GetMapping()
    public String getMain(){
        return "/exampleHibernateAndImage/main";
    }

    @PostMapping("/addUser")
    public String addUser(
            @RequestParam("name") String name,
            @RequestParam("country") String country,
            @RequestParam("image") MultipartFile image
            ){

        UUID uuidImageName = UUID.randomUUID();

        Human human = new Human(name,country,uuidImageName.toString());
        saveImage(image, uuidImageName.toString());

        humanRepository.save(human);

        return "redirect:/fileImage";

    }


    private void saveImage(MultipartFile imageFile,String imageName){
        try{
            byte[] bytes = imageFile.getBytes();
            Path path = Paths.get(pathFolder + imageName+imageFile.getName());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/openBase")
    public String openBase(Model model){

        model.addAttribute("elemList",humanRepository.findAll());

        return "/exampleHibernateAndImage/base";
    }

    @RequestMapping("/downloadImage/{fileName}")
    @ResponseBody
    public void show(@PathVariable("fileName") String fileName, HttpServletResponse response) {

        if (fileName.indexOf(".doc")>-1) response.setContentType("application/msword");
        if (fileName.indexOf(".docx")>-1) response.setContentType("application/msword");
        if (fileName.indexOf(".xls")>-1) response.setContentType("application/vnd.ms-excel");
        if (fileName.indexOf(".csv")>-1) response.setContentType("application/vnd.ms-excel");
        if (fileName.indexOf(".ppt")>-1) response.setContentType("application/ppt");
        if (fileName.indexOf(".pdf")>-1) response.setContentType("application/pdf");
        if (fileName.indexOf(".jpg")>-1) response.setContentType("application/jpg");
        response.setHeader("Content-Disposition", "attachment; filename=" +fileName);
        response.setHeader("Content-Transfer-Encoding", "binary");
        try {
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            FileInputStream fis = new FileInputStream(pathFolder+fileName);
            int len;
            byte[] buf = new byte[1024];
            while((len = fis.read(buf)) > 0) {
                bos.write(buf,0,len);
            }
            bos.close();
            response.flushBuffer();
        }
        catch(IOException e) {
            e.printStackTrace();

        }
    }

    @Autowired
    private ServletContext servletContext;

    @GetMapping(value = "/showImage/{fileName}", produces = MediaType.IMAGE_JPEG_VALUE )
    @ResponseBody
    public ResponseEntity<Resource> getImage(@PathVariable("fileName") String fileName){
        HttpHeaders headers = new HttpHeaders();
        Resource resource =
                new ServletContextResource(servletContext, "/WEB-INF/images/"+fileName);
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

}
