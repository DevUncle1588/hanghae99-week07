package com.example.s3aws;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

//@RestController
@Controller
@RequiredArgsConstructor
public class ImageController {
    private final S3Uploader s3Uploader;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/images")
    @ResponseBody
    public String upload(@RequestParam("music") MultipartFile musicFile, @RequestParam("image") MultipartFile imageFile) throws IOException {
        return s3Uploader.upload(musicFile, "static");
//        s3Uploader.upload(imageFile, "picture");


    }
}


//@RestController
//@RequiredArgsConstructor
//public class ImageController {
//    private final S3Uploader s3Uploader;
//
//    @PostMapping("/images")
//    public String upload(@RequestParam("images") MultipartFile multipartFile) throws IOException {
//        return s3Uploader.upload(multipartFile, "static");
//    }
//}