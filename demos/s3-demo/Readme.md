# AWS S3 Demo in Java Project

# Pre-requisites

1.  Java 11 SDK
1.  Code Editor : vscode, eclipse or idea
1.  AWS CLI Installed and Credentials configured

1.  Search for `s3` at https://mvnrepository.com, it should give you multiple search results.

1.  The FIRST option is from group-id software.amazon.awssdk which should be used for Java 11 onwards 

1.  the SECODN option is from group-id com.amazonaws which is compatible with Java-8 and Java-11.

1.  Use SECOND option, click on name and then select FIRST (latest) version, Maven should generate the XML code snippet which should look like :

    ```xml
    <!-- https://mvnrepository.com/artifact/com.amazonaws/aws-java-sdk-s3 -->
    <dependency>
        <groupId>com.amazonaws</groupId>
        <artifactId>aws-java-sdk-s3</artifactId>
        <version>1.12.630</version>
    </dependency>
    ```
1. Copy this code snippet and use it inside a new maven project's pom.xml

1. Delete the Test cases from `src\main\test` and also delete the dependency for JUnit

1.  Modify App.java with code to List all buckets

    ```java
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

    ```

