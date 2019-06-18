package com.fudan.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


@RestController
//@RequestMapping(value = "/assets/images")
public class ImageController {

//    @GetMapping(value = "course/{fileName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getCourseImage(@PathVariable String fileName) throws IOException {
        String path = "C:/Users/Administrator/Desktop/高级web/service/assets/images/course/" + fileName;
        FileInputStream input = new FileInputStream(new File(path));
        byte[] bytes = new byte[input.available()];
        input.read(bytes, 0, input.available());
        return bytes;
    }

}