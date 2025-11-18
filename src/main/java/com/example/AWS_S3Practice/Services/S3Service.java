package com.example.AWS_S3Practice.Services;

import io.awspring.cloud.s3.S3Template;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class S3Service {

    private final S3Template s3Template;

    public S3Service(S3Template s3Template) {
        this.s3Template = s3Template;
    }

    @Value("${spring.cloud.aws.s3.bucket}")
    private String bucketName;
}
