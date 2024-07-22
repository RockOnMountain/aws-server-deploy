package com.study.aws.server.deploy.upload.application.port.out;

import com.study.aws.server.deploy.upload.domain.S3Image;
import org.springframework.web.multipart.MultipartFile;

public interface UploadImageOutPort {

    S3Image upload(MultipartFile multipartFile);
}
