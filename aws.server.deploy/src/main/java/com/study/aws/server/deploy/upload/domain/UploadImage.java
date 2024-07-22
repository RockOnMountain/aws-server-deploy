package com.study.aws.server.deploy.upload.domain;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UploadImage {

    private Long id;
    private String url;
    private String imageName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
