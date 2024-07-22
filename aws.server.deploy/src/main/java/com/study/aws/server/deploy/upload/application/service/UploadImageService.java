package com.study.aws.server.deploy.upload.application.service;

import com.study.aws.server.deploy.upload.application.port.in.UploadImageUseCase;
import com.study.aws.server.deploy.upload.application.port.out.SaveS3ImageOutPort;
import com.study.aws.server.deploy.upload.application.port.out.UploadImageOutPort;
import com.study.aws.server.deploy.upload.domain.S3Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
class UploadImageService implements UploadImageUseCase {

    private final UploadImageOutPort uploadImageOutPort;
    private final SaveS3ImageOutPort saveS3ImageOutPort;


    @Override
    public S3Image upload(MultipartFile multipartFile) {

        S3Image s3Image = uploadImageOutPort.upload(multipartFile);
        return saveS3ImageOutPort.save(s3Image);
    }
}
