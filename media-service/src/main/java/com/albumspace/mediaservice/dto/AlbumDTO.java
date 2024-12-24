package com.albumspace.mediaservice.dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AlbumDTO {
    private String albumId;
    private String userId;
    private String name;
    private String description;
    private boolean isPublic;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
