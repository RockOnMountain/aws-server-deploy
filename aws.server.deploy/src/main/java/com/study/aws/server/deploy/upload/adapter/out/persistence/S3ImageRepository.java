package com.study.aws.server.deploy.upload.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface S3ImageRepository extends JpaRepository<S3ImageEntity, Long> {}
