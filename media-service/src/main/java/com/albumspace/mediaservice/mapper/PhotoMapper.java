package com.albumspace.mediaservice.mapper;

import com.albumspace.mediaservice.dto.PhotoDTO;
import com.albumspace.mediaservice.entity.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PhotoMapper {
    PhotoMapper INSTANCE = Mappers.getMapper(PhotoMapper.class);

    PhotoDTO toDTO(Photo photo);

    Photo toEntity(PhotoDTO photoDTO);
}
