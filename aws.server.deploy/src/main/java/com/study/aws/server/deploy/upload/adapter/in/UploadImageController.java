package com.study.aws.server.deploy.upload.adapter.in;

import com.study.aws.server.deploy.upload.application.port.in.UploadImageUseCase;
import com.study.aws.server.deploy.upload.domain.S3Image;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Controller
@RequestMapping("/v1/upload/image")
class UploadImageController {

    private final UploadImageUseCase uploadImageUseCase;


    @PostMapping
    public ResponseEntity<UploadImageResponse> uploadImage(@RequestPart("uploadImage") MultipartFile multipartFile) {

        S3Image s3Image = uploadImageUseCase.upload(multipartFile);
        return ResponseEntity.ok(UploadImageResponse.builder().id(s3Image.getId()).url(s3Image.getUrl()).build());
    }

}
