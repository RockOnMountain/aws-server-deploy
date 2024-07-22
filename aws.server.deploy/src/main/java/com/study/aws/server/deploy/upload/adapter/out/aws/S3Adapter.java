package com.study.aws.server.deploy.upload.adapter.out.aws;

import java.io.IOException;
import java.util.UUID;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.study.aws.server.deploy.upload.application.port.out.UploadImageOutPort;
import com.study.aws.server.deploy.upload.domain.S3Image;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
class S3Adapter implements UploadImageOutPort {

    private static final String DIR_NAME = "images/";
    private final AmazonS3 amazonS3;
    private final String bucket;


    public S3Adapter(AmazonS3 amazonS3, @Value("${cloud.aws.s3.bucket}") String bucket) {
        this.amazonS3 = amazonS3;
        this.bucket = bucket;
    }


    @Override
    public S3Image upload(MultipartFile multipartFile) {

        try {
            String fileName = this.convertFileName(multipartFile.getOriginalFilename());

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(multipartFile.getSize());
            metadata.setContentType(multipartFile.getContentType());

            amazonS3.putObject(bucket, fileName, multipartFile.getInputStream(), metadata);

            return S3Image.builder().url(amazonS3.getUrl(bucket, fileName).toString()).build();
        } catch(IOException e) {
            return null;
        }
    }


    private String convertFileName(String fileName) {
        return DIR_NAME + fileName + "_" + UUID.randomUUID();
    }
}
