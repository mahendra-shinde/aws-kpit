# Identity and Access Management (IAM)


Amazon Identity and Access Management (IAM) is a web service provided by Amazon Web Services (AWS) that allows you to securely control access to AWS services and resources. IAM enables you to manage users, groups, roles, and permissions to ensure that only authorized entities can interact with your AWS environment. Here are key aspects of AWS IAM:

1. **Users:** IAM allows you to create and manage AWS user identities. Each user is assigned a unique set of security credentials (such as access key and secret key) to interact with AWS services. Users are typically associated with specific roles or groups. AWS IAM has no limit on number of users, you can create unlimited number of users.

2. **Groups:** Groups in IAM are collections of users. By assigning permissions to groups, you can efficiently manage access for multiple users. Users within a group inherit the permissions assigned to that group, simplifying the management of access control.

3. **Roles:** IAM roles define a set of permissions for AWS resources and are not associated with a specific user or group. Roles are assumed by users, AWS services, or even external identities using *temporary security credentials*, enabling secure access across accounts.

4. **Policies:** IAM policies are JSON documents that define the permissions granted to users, groups, or roles. These policies specify the actions allowed or denied on specific AWS resources. Policies are attached to identities to govern their access permissions. Policies are smallest unit of access access control in IAM.

5. **Access Key and Secret Key:** IAM provides access keys (access key ID and secret access key) for programmatic access to AWS services. These keys are used by developers and applications to authenticate and make API calls securely. 

6. **Multi-Factor Authentication (MFA):** IAM supports MFA to add an extra layer of security. Users can enable MFA for their accounts, requiring the use of a physical or virtual device (such as a smartphone app) in addition to their password for authentication.

7. **IAM Roles for EC2 Instances:** IAM roles can be assigned to Amazon EC2 instances, allowing applications running on those instances to securely access other AWS services without the need for access keys. This enhances security and eliminates the need to embed credentials within applications.

8. **Identity Federation:** IAM supports identity federation, enabling you to allow users from your corporate directory or other identity providers to access AWS resources securely. This is achieved using standard identity federation protocols such as SAML or OpenID Connect.

9. **Audit Trail:** IAM provides detailed logging capabilities through AWS CloudTrail, allowing you to track and audit user activity within your AWS account. This includes information on who made specific API calls and changes to IAM policies.

IAM is a fundamental component of AWS security, allowing organizations to implement the principle of least privilege, ensuring that users and entities have the minimum permissions required to perform their tasks. Properly configuring IAM is crucial for maintaining the security and integrity of AWS resources.

# IAM Roles 

IAM (Identity and Access Management) roles in AWS provide a way to delegate permissions securely to entities, whether they are AWS services, IAM users, or federated users. IAM roles are essential for achieving the principle of least privilege and maintaining a secure and well-managed AWS environment. Here are key aspects of IAM roles:

1. **Purpose of IAM Roles:**
   - IAM roles are designed to define a set of permissions for AWS resources.
   - Roles are not associated with a specific user or group; instead, they are assumed by entities that need temporary security credentials.

2. **Temporary Security Credentials:**
   - When a user, application, or AWS service assumes a role, it receives temporary security credentials.
   - These credentials consist of an access key ID, a secret access key, and a session token.
   - Temporary credentials are valid for a specified duration, typically ranging from a few minutes to several hours.

3. **Entities That Can Assume Roles:**
   - IAM users: Users within the same AWS account or other AWS accounts can assume roles.
   - AWS services: Services like EC2 instances, Lambda functions, and more can assume roles for secure access to other AWS resources.
   - Federated users: Users authenticated through an external identity provider (IdP) can assume roles using standards like SAML or OpenID Connect.

4. **Delegation of Permissions:**
   - IAM roles enable the delegation of permissions without the need for sharing long-term security credentials.
   - By defining policies attached to roles, you can control what actions the assumed entity is allowed or denied on AWS resources.

5. **Cross-Account Access:**
   - IAM roles support cross-account access, allowing entities from one AWS account to assume a role in another account.
   - This facilitates secure sharing of resources across AWS accounts while maintaining control over permissions.

6. **IAM Role Trust Relationships:**
   - The trust relationship of a role defines which entities are allowed to assume the role.
   - The trust policy is a JSON document that specifies the trusted entities and conditions under which they can assume the role.

7. **Permissions Policies:**
   - IAM roles have policies attached to them, similar to policies attached to users and groups.
   - These policies define the permissions granted to the entity assuming the role.

8. **Use Cases for IAM Roles:**
   - Granting temporary access to IAM users or federated users without sharing long-term credentials.
   - Allowing AWS services, like EC2 instances, to access other AWS services securely.
   - Cross-account access for sharing resources across multiple AWS accounts.

9. **IAM Roles for EC2 Instances:**
   - IAM roles are commonly used with EC2 instances to grant applications running on instances access to AWS services without embedding access keys within the application code.

10. **IAM Role Switching:**
    - Entities can switch between roles using the AWS Management Console, AWS CLI, or SDKs, allowing flexibility and ease of access to different sets of permissions.

IAM roles play a crucial role in the security and access management strategy of AWS, providing a secure and scalable way to delegate and manage permissions across various entities within and across AWS accounts.