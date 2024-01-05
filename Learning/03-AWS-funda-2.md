# AWS Fundamentals

Amazon Web Services (AWS) is one of the leading cloud computing platforms, offering a wide range of services that enable businesses and individuals to access computing power, storage, and other resources on a pay-as-you-go basis. AWS is provided by Amazon, and it has become a key player in the cloud computing industry, serving millions of customers globally. Here are key aspects of AWS:

1. **Compute Services:**
   - **Amazon EC2 (Elastic Compute Cloud):** Provides resizable compute capacity in the form of virtual servers (instances).
   - **AWS Lambda:** Offers serverless computing, allowing developers to run code without provisioning or managing servers.

1. **Storage Services:**
   - **Amazon S3 (Simple Storage Service):** Object storage service for storing and retrieving data.
   - **Amazon EBS (Elastic Block Store):** Block-level storage volumes for use with EC2 instances.

1. **Database Services:**
   - **Amazon RDS (Relational Database Service):** Managed relational database service supporting various database engines like MySQL, PostgreSQL, and others.
   - **Amazon DynamoDB:** Fully managed NoSQL database service.

1. **Networking:**
   - **Amazon VPC (Virtual Private Cloud):** Allows users to provision a logically isolated section of the AWS Cloud where they can launch AWS resources.
   - **Amazon Route 53:** Domain Name System (DNS) web service for routing end-user requests to globally distributed AWS resources.

1. **Security and Identity:**
   - **AWS Identity and Access Management (IAM):** Enables control and management of access to AWS services and resources.
   - **AWS Key Management Service (KMS):** Manages encryption keys for securing data.

1. **Developer Tools:**
   - **AWS CodeDeploy:** Automates code deployments to any instance.
   - **AWS CodePipeline:** Automates the build, test, and deployment phases of release pipelines.

1. **Analytics and Machine Learning:**
   - **Amazon Redshift:** Managed data warehouse service.
   - **Amazon SageMaker:** Fully managed service that enables developers to build, train, and deploy machine learning models.

1. **Internet of Things (IoT):**
   - **AWS IoT Core:** Platform for connecting and managing IoT devices.

1. **Artificial Intelligence (AI):**
   - **Amazon Polly:** Text-to-speech service.
   - **Amazon Rekognition:** Image and video analysis service.

1. **Serverless Computing:**
    - **AWS Step Functions:** Serverless orchestration service.

1. **Management and Monitoring:**
    - **AWS CloudWatch:** Monitoring and management service for AWS resources.
    - **AWS CloudTrail:** Records AWS API calls for auditing and compliance purposes.

1.  **Elasticity and Scalability:**

    AWS provides the ability to scale resources up or down based on demand, allowing users to pay only for the resources they consume.

1.  **Global Reach:**
    
    AWS has a global network of data centers (Availability Zones and Regions) to provide low-latency and high-availability services to customers worldwide.

AWS's extensive set of services caters to a broad range of use cases, from small startups to large enterprises, making it a versatile and widely adopted cloud platform. Its flexibility, scalability, and reliability have contributed to its popularity in the cloud computing landscape.

## Managing AWS Services / Resources

In Amazon Web Services (AWS), there are several ways to manage resources, and the choice depends on factors such as your preferences, the scale of your infrastructure, automation requirements, and collaboration needs. Here are some of the common ways to manage AWS resources:

1. **AWS Management Console:**
   The AWS Management Console is a web-based interface that allows users to interact with and manage AWS resources through a graphical user interface (GUI). It provides an easy-to-use and intuitive way to perform tasks without the need for command-line skills.

1. **AWS Command Line Interface (CLI):**
   The AWS CLI is a command-line tool that allows users to interact with AWS services using commands in the terminal or command prompt. It provides a powerful and scriptable way to manage resources, automate tasks, and integrate with other tools.

1. **AWS Software Development Kits (SDKs):**
   AWS SDKs are available for various programming languages (e.g., Python, Java, JavaScript, .NET). Developers can use SDKs to build applications that interact with AWS services programmatically, allowing for automation and integration with custom applications.

1. **Third-Party Tools:**
   There are numerous third-party tools and frameworks available that provide additional features for managing AWS resources. Examples include Terraform, Ansible, and Jenkins.

The choice of management method often depends on the specific use case, the level of automation required, and the preferences and skills of the users or development team. Many organizations adopt a combination of these methods to effectively manage their AWS resources.

## Using AWS CLI

The AWS Command Line Interface (CLI) is a powerful tool that allows you to interact with AWS services using a command-line interface. Here's a basic guide on how to use the AWS CLI:

### Prerequisites:

**Install AWS CLI:**
   - Make sure you have the AWS CLI installed on your machine. You can download and install it from the [AWS CLI official website](https://aws.amazon.com/cli/).


### Configure AWS CLI

The `aws configure` command is used to set up your AWS CLI with the necessary configuration details, such as your AWS Access Key ID, Secret Access Key, default region, and output format. Here's a step-by-step guide on how to use the `aws configure` command:

1. **Open a Terminal or Command Prompt:**
   - Open the terminal or command prompt on your local machine.

2. **Run the `aws configure` Command:**
   - Type the following command and press Enter:
     ```bash
     aws configure
     ```

3. **Enter AWS Access Key ID:**
   - You will be prompted to enter your AWS Access Key ID. This is the key associated with your AWS account that grants access to your resources.
     ```
     AWS Access Key ID [None]:
     ```

4. **Enter AWS Secret Access Key:**
   - Enter your AWS Secret Access Key, which is the secret key corresponding to the Access Key ID.
     ```
     AWS Secret Access Key [None]:
     ```

5. **Enter Default Region:**
   - Specify your default AWS region. This is the AWS region that the AWS CLI will use by default unless overridden by specific commands.
     ```
     Default region name [None]:
     ```

6. **Enter Default Output Format:**
   - Choose the output format for AWS CLI commands. Common options include `json`, `text`, or `table`.
     ```
     Default output format [None]:
     ```

7. **Configuration Confirmation:**
   - The AWS CLI will display a summary of the entered configuration settings. Review the information, and if everything looks correct, press Enter to confirm.
     ```
     AWS Access Key ID: your-access-key-id
     AWS Secret Access Key: your-secret-access-key
     Default region name: your-default-region
     Default output format: your-preferred-output-format
     ```

8. **Verification:**
   - To verify that your configuration is set up correctly, you can run a simple AWS CLI command, such as:
     ```bash
     aws s3 ls
     ```
     If configured correctly, this command should list your S3 buckets.

The `aws configure` command saves the entered configuration details in a file named `credentials` located in the `~/.aws/` directory on Linux or macOS, or in the `%USERPROFILE%\.aws\` directory on Windows.


### Basic Usage:

1. **Check AWS CLI Version:**
   ```bash
   aws --version
   ```

2. **List Available AWS CLI Commands:**
   ```bash
   aws help
   ```

3. **List AWS Regions:**
   ```bash
   aws ec2 describe-regions
   ```

4. **List EC2 Instances:**
   ```bash
   aws ec2 describe-instances
   ```

5. **List S3 Buckets:**
   ```bash
   aws s3 ls
   ```

6. **Upload a File to S3:**
   ```bash
   aws s3 cp local-file.txt s3://your-bucket-name/
   ```

7. **Download a File from S3:**
   ```bash
   aws s3 cp s3://your-bucket-name/remote-file.txt local-file.txt
   ```

8. **Create an EC2 Key Pair:**
   ```bash
   aws ec2 create-key-pair --key-name your-key-pair-name --query 'KeyMaterial' --output text > your-key-pair-name.pem
   ```

9. **Create an EC2 Instance:**
   ```bash
   aws ec2 run-instances --image-id ami-xxxxxxxx --instance-type t2.micro --key-name your-key-pair-name
   ```

10. **Terminate an EC2 Instance:**
    ```bash
    aws ec2 terminate-instances --instance-ids i-xxxxxxxx
    ```

### Additional Tips:

- **Help for Specific Command:**
  ```bash
  aws ec2 describe-instances help
  ```

- **Filtering Output:**
  You can use `--query` option to filter the output. For example:
  ```bash
  aws ec2 describe-instances --query 'Reservations[*].Instances[*].[InstanceId,State.Name]'
  ```


- **Using AWS CLI with AWS Services Documentation:**
  AWS CLI commands often correspond to AWS service API actions. Refer to the [AWS CLI Command Reference](https://docs.aws.amazon.com/cli/latest/index.html) for detailed documentation on specific commands.

This is just a basic introduction, and the AWS CLI provides a wide range of functionalities for interacting with various AWS services. Explore the [official AWS CLI documentation](https://docs.aws.amazon.com/cli/latest/index.html) for comprehensive information on available commands and options.