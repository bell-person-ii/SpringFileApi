package com.file.apifile.controller;

import com.file.apifile.service.FileDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class FileDataController {

    private final FileDataService fileDataService;

    @PostMapping("/fileSystem")
    public ResponseEntity<?> uploadImageToFileSystem(@RequestParam("image")MultipartFile file) throws IOException{

        String uploadName = fileDataService.uploadImageToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK).body(uploadName);
    }

    @GetMapping("/fileSystem/{fileName}")
    public ResponseEntity<?> downloadImageToFileSystem(@PathVariable("fileName")String fileName) throws IOException{
        byte[] downloadImage = fileDataService.downloadImageFromFileSystem(fileName);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(downloadImage);
    }
}
