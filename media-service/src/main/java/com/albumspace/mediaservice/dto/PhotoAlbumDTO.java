package com.albumspace.mediaservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhotoAlbumDTO {

    private String mappingId;

    private String photoId;

    private String albumId;

    private LocalDateTime addedAt;

    private LocalDateTime modifiedAt;
}
