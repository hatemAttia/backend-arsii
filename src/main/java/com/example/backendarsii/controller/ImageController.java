package com.example.backendarsii.controller;

import com.example.backendarsii.entity.Image;
import com.example.backendarsii.service.ImageService;
import com.example.backendarsii.utils.Constants;
import com.example.backendarsii.utils.ImageUtility;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(Constants.APP_ROOT+"/image")
@RequiredArgsConstructor
@Api(tags = "Image Management")
@CrossOrigin("*")
public class ImageController {

    private final ImageService imageService;

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        imageService.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Image uploaded successfully :"+file.getOriginalFilename());
    }
    @GetMapping(value = "/info/{name}")
    public ResponseEntity<Image> getImageDetails(@PathVariable("name") String name){
        return ResponseEntity.ok(imageService.getImageDetails(name));
    }
    @GetMapping(value = "{name}")
    public ResponseEntity<byte[]> getImage(@PathVariable("name") String name){
        Image image = imageService.getImageDetails(name);
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(image.getType()))
                .body(ImageUtility.decompressImage(image.getImage()));
    }
}
