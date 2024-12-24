package com.albumspace.mediaservice.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PhotoDTO {
    private String photoId;
    private String photoUrl;
    private String description;
    private int likes_count;
    private LocalDateTime uploadedAt;
    private LocalDateTime modifiedAt;
}
