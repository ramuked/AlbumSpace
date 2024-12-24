package com.albumspace.mediaservice.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "photo")
@Getter
@Setter
@Builder
public class Photo {

    @Id
    @Column(name = "photo_id",columnDefinition = "CHAR(36)",updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String photoId;

    @Column(name = "user_id", length = 36, nullable = false)
    private String userId;

    @Column(name = "photo_url", nullable = false, columnDefinition = "TEXT")
    private String photoUrl;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "likes_count", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int likesCount = 0;

    @Column(name = "uploaded_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime uploadedAt;

    @Column(name = "modified_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime modifiedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return Objects.equals(photoId, photo.photoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoId);
    }
}
