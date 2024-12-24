package com.albumspace.mediaservice.repository;

import com.albumspace.mediaservice.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, String> {
    // Additional custom queries can be added here if needed
}
