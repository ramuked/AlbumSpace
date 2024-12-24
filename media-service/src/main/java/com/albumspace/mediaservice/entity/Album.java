package com.albumspace.mediaservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "album")
@Getter
@Setter
public class Album {

    @Id
    @Column(name = "album_id",columnDefinition = "CHAR(36)",updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String albumId;

    @Column(name = "user_id", length = 36, nullable = false)
    private String userId;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "is_public", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean isPublic = false;

    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "modified_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime modifiedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(albumId, album.albumId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(albumId);
    }
}
