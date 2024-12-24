package com.albumspace.mediaservice.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Builder
@Table(name="photo_album")
@Getter
@Setter
public class PhotoAlbum {

    @Id
    @Column(name = "mapping_id",columnDefinition = "CHAR(36)",updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String mappingId;


    @Column(name = "photo_id", length = 36, nullable = false)
    private String photoId;

    @Column(name = "album_id", length = 36, nullable = false)
    private String albumId;

    @Column(name = "added_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime addedAt;

    @Column(name = "modified_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime modifiedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoAlbum photoAlbum = (PhotoAlbum) o;
        return Objects.equals(mappingId, photoAlbum.mappingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mappingId);
    }
}
