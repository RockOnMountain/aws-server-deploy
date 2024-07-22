package com.study.aws.server.deploy.upload.application.port.out;

import com.study.aws.server.deploy.upload.domain.S3Image;

public interface SaveS3ImageOutPort {

    S3Image save(S3Image s3Image);
}
