package com.study.aws.server.deploy.upload.application.port.in;

import com.study.aws.server.deploy.upload.domain.S3Image;
import org.springframework.web.multipart.MultipartFile;

public interface UploadImageUseCase {

    S3Image upload(MultipartFile multipartFile);
}
