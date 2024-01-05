# AWS Elastic Compute (v2)

Amazon Elastic Compute Cloud (EC2) is a web service offered by Amazon Web Services (AWS) that provides resizable compute capacity in the cloud. EC2 enables users to run virtual servers, known as instances, to host applications, databases, and other computing workloads. EC2 instances can be easily scaled up or down based on the demand, allowing users to pay only for the compute capacity they consume.

Key features and concepts of AWS EC2 include:

1. **Instances:**
   - An EC2 instance is a virtual server in the cloud, representing a specific amount of compute capacity.
   - Instances can run various operating systems (e.g., Linux, Windows), and users can choose from a wide range of instance types optimized for different use cases, such as compute-optimized, memory-optimized, storage-optimized, etc.

1. **Amazon Machine Images (AMIs):**
   - An AMI is a pre-configured template that contains the necessary information to launch an EC2 instance. It includes the operating system, application server, and any additional software needed for the instance.
   - Users can choose from a variety of public AMIs provided by AWS or create their own custom AMIs.

1. **Instance Types:**
   - EC2 offers a diverse set of instance types, each designed for specific use cases. For example, the t2.micro instance type is suitable for low-cost, general-purpose applications, while the c5.4xlarge instance type is optimized for compute-intensive workloads.
   - Instance types differ in terms of CPU, memory, storage, and network capacity.

1. **Elastic Load Balancing (ELB):**
   - ELB distributes incoming application traffic across multiple EC2 instances to ensure high availability and fault tolerance.
   - It helps optimize the performance of applications by automatically scaling the load balancer in response to incoming traffic.

1. **Auto Scaling:**
   - Auto Scaling enables users to automatically adjust the number of EC2 instances based on demand. It helps maintain application availability and allows users to optimize costs by scaling up or down as needed.

1. **Security Groups:**
   - Security Groups act as virtual firewalls for EC2 instances, controlling inbound and outbound traffic. Users can define rules to permit or deny specific types of traffic to instances.

1. **Key Pairs:**
   - EC2 instances are accessed using key pairs for secure SSH (for Linux instances) or RDP (for Windows instances) connectivity. Users generate and manage key pairs to securely connect to their instances.

1. **Amazon EBS (Elastic Block Store):**
   - EBS provides persistent block-level storage volumes for EC2 instances. Users can attach EBS volumes to instances to store data, databases, or other types of storage.

1. **Instance Storage (Instance Store):**
   - Some EC2 instance types come with temporary, ephemeral storage called instance store. This storage is directly attached to the physical host of the instance and is lost when the instance is stopped or terminated.

1. **Spot Instances, Reserved Instances, and On-Demand Instances:**
    - Users can choose different pricing models for EC2 instances. Spot Instances allow users to bid for unused EC2 capacity at potentially lower costs. Reserved Instances provide a discount in exchange for a commitment to a one- or three-year term. On-Demand Instances are charged per hour or per second, with no upfront costs or commitments.

1. **EC2 Fleet:**
    - EC2 Fleet simplifies the process of provisioning and managing multiple EC2 instances across different instance types, availability zones, and pricing models.

1. **Amazon EC2 Dedicated Hosts:**
    - Dedicated Hosts allow users to run instances on physical servers dedicated to their use, providing more control over the placement of instances.

AWS EC2 is a versatile and widely used service, forming the backbone of many cloud-based applications. It offers flexibility, scalability, and various customization options to meet diverse computing requirements.