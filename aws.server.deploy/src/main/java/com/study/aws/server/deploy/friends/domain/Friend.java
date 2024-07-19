package com.study.aws.server.deploy.friends.domain;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Friend {

    private Long id;
    private String name;
    private String explanation;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
