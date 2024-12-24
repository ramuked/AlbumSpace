package com.albumspace.mediaservice.controller;

import com.albumspace.mediaservice.dto.PhotoDTO;
import com.albumspace.mediaservice.dto.StandardResponse;
import com.albumspace.mediaservice.service.PhotoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/photos")
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }
    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "helloWorld";
    }

    @PostMapping("/upload")
    public ResponseEntity<StandardResponse<PhotoDTO>> uploadPhoto(
            @RequestHeader("userId") String userId,
            @RequestPart MultipartFile file,
            @RequestParam String name,
            @RequestParam(required = false) String description,
            @RequestParam(defaultValue = "false") boolean isPublic,
            @RequestParam(required = false) String[] albumIds) throws IOException {
        System.out.println("hello");

        PhotoDTO photoDTO = photoService.uploadPhoto(userId, file, name, description, isPublic, albumIds);

        StandardResponse<PhotoDTO> response = StandardResponse.<PhotoDTO>builder()
                .status("success")
                .message("Photo uploaded successfully")
                .data(photoDTO)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(response);
    }
}
