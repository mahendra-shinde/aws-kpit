package com.mahendra;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AmazonS3 s3 = AmazonS3Client.builder().withCredentials(
                new ProfileCredentialsProvider()).build();

        // s3.listBuckets().forEach(b -> System.out.println(b.getName()));
        List<Bucket> buckets = s3.listBuckets();
        for (Bucket b : buckets) {
            System.out.println(b.getName());
        }

    }
}
