package com.albumspace.mediaservice.service;

import com.albumspace.mediaservice.dto.PhotoDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService {
    PhotoDTO uploadPhoto(String userId, MultipartFile file, String name, String description, boolean isPublic, String[] albumIds) throws IOException;
}
