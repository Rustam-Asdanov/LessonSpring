package com.king.exampleImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
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
import org.springframework.core.io.Resource;
import org.springframework.http.*;

@Controller
@RequestMapping("/file")
public class DownloadFileController {
    String folderPath = "/photos/";


    @GetMapping()
    public String showFiles(Model model) {
        Path path = Paths.get(folderPath);
        File folder = path.toFile();
        File[] listOfFiles = folder.listFiles();
        model.addAttribute("files", listOfFiles);
        return "exampleImage/main";
    }


    @RequestMapping("/load/{fileName}")
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
            FileInputStream fis = new FileInputStream(folderPath+fileName);
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

    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile){
        String returnValue = "";

        save(imageFile);


        return "redirect:/file";

    }



    private void save(MultipartFile imageFile) {
        String folder = "/photos/";
        try {
            byte[] bytes = imageFile.getBytes();
            Path path = Paths.get(folder + imageFile.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //for showing picture in site
    @Autowired
    private ServletContext servletContext;

    @GetMapping(value = "/show/{fileName}", produces = MediaType.IMAGE_JPEG_VALUE )
    @ResponseBody
    public ResponseEntity<Resource> getImage(@PathVariable("fileName") String fileName){
        HttpHeaders headers = new HttpHeaders();
        Path path = Paths.get(folderPath);
        Resource resource =
                new ServletContextResource(servletContext, "/WEB-INF/images/"+fileName);
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }
}
