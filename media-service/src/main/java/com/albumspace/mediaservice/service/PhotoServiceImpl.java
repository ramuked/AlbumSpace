package com.albumspace.mediaservice.service;

import com.albumspace.mediaservice.dto.PhotoDTO;
import com.albumspace.mediaservice.entity.Photo;
import com.albumspace.mediaservice.entity.PhotoAlbum;
import com.albumspace.mediaservice.repository.PhotoRepository;
import com.albumspace.mediaservice.repository.PhotoAlbumRepository;
import com.albumspace.mediaservice.mapper.PhotoMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;
    private final PhotoAlbumRepository photoAlbumRepository;

    @Value("${media-service.photo.upload-dir}")
    private String uploadDir;

    public PhotoServiceImpl(PhotoRepository photoRepository, PhotoAlbumRepository photoAlbumRepository) {
        this.photoRepository = photoRepository;
        this.photoAlbumRepository = photoAlbumRepository;
    }

    @Override
    public PhotoDTO uploadPhoto(String userId, MultipartFile file, String name, String description, boolean isPublic, String[] albumIds) throws IOException {
        // Save the file locally
        String photoId = UUID.randomUUID().toString(); // Generate a UUID for the photo_id


        Path filePath = Paths.get(uploadDir + File.separator + photoId);
        Files.createDirectories(filePath.getParent());
        Files.write(filePath, file.getBytes());

        // Create and save the Photo entity
        Photo photo = Photo.builder()
                .photoId(photoId)
                .userId(userId)
                .photoUrl(filePath.toString())
                .description(description)
                .likesCount(0)
                .uploadedAt(null) // Will be auto-set
                .modifiedAt(null) // Will be auto-set
                .build();

        Photo savedPhoto = photoRepository.save(photo);

        // Handle photo-album associations
        if (albumIds != null) {
            for (String albumId : albumIds) {
                PhotoAlbum photoAlbum = PhotoAlbum.builder()
                        .photoId(savedPhoto.getPhotoId())
                        .albumId(albumId)
                        .build();
                photoAlbumRepository.save(photoAlbum);
            }
        }

        // Map to DTO and return
        return PhotoMapper.INSTANCE.toDTO(savedPhoto);
    }
}
