package com.study.aws.server.deploy.upload.adapter.in;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
class UploadImageResponse {

    long id;
    String url;
}
