package com.study.aws.server.deploy.upload.adapter.out.persistence;

import com.study.aws.server.deploy.common.jpa.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "s3_image")
class S3ImageEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;


    @Builder
    protected S3ImageEntity(Long id, String url) {
        this.id = id;
        this.url = url;
    }
}
