package com.albumspace.mediaservice.repository;

import com.albumspace.mediaservice.entity.PhotoAlbum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoAlbumRepository extends JpaRepository<PhotoAlbum, String> {
// Additional custom queries can
}
