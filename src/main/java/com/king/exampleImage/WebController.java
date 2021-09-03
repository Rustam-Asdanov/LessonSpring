package com.king.exampleImage;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.apache.commons.io.IOUtils;
import org.springframework.web.context.support.ServletContextResource;

import javax.servlet.ServletContext;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

@Controller
@RequestMapping("/image")
public class WebController {

    @Autowired
    private ServletContext servletContext;

    @GetMapping()
    public String getMain(){
        return "/exampleImage/main";
    }

    @GetMapping("/get-text")
    public @ResponseBody String getText(){
        return "Hello World";
    }

    /**
     *  just get image
      */


//    @GetMapping(value = "/get-image", produces = MediaType.IMAGE_JPEG_VALUE)
//    @ResponseBody
//    public ResponseEntity<Resource> getImage(){
//        HttpHeaders headers = new HttpHeaders();
//        Resource resource =
//                new ServletContextResource(servletContext, "/WEB-INF/images/wolf.jpg");
//        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
//    }


    /**
     *  just get image second way
     */
//    @GetMapping(value = "/get-image", produces = MediaType.IMAGE_JPEG_VALUE )
//    @ResponseBody
//    public Resource getImage(){
//        return new ServletContextResource(servletContext, "/WEB-INF/images/wolf.jpg");
//    }


//    @RequestMapping("/get-image")
//    @ResponseBody
//    public HttpEntity<byte[]> downloadImage() throws IOException {
//
////        logger.info("Requested picture >> " + id + " <<");
//
//        File file = new File("com/king/exampleImage/images/wolf.jpg");
//        byte[] image = IOUtils.toByteArray(file.toURI().toURL());
//
//        InputStream in = getClass()
//                .getResourceAsStream("com/king/exampleImage/images/wolf.jpg");
//        // 1. download img from http://internal-picture-db/id.jpg ...
//        byte[] image2 = IOUtils.toByteArray(in);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.IMAGE_JPEG);
//        headers.setContentLength(image.length);
//
//        return new HttpEntity<byte[]>(image, headers);
//    }


}
