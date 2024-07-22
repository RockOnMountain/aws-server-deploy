package com.study.aws.server.deploy.upload.adapter.out.persistence;

import com.study.aws.server.deploy.upload.application.port.out.SaveS3ImageOutPort;
import com.study.aws.server.deploy.upload.domain.S3Image;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
class S3ImagePersistenceAdapter implements SaveS3ImageOutPort {

    private final S3ImageRepository s3ImageRepository;
    private final S3ImageMapper s3ImageMapper;


    @Override
    public S3Image save(S3Image s3Image) {
        S3ImageEntity savedS3ImageEntity = s3ImageRepository.save(s3ImageMapper.toEntity(s3Image));
        return s3ImageMapper.toDomain(savedS3ImageEntity);
    }


    @Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
    interface S3ImageMapper {

        S3ImageEntity toEntity(S3Image domain);

        S3Image toDomain(S3ImageEntity entity);
    }
}
