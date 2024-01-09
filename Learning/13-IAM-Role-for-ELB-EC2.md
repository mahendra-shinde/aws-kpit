# Creating IAM Role for EC2 instances in ELB Environment

> This one is `One time Activity` and follow these steps only if you get ERROR while creating BeanStalk environment `Choose EC2 Profile` or `Incorrect EC2 profile`

1. Search for  `IAM` and open IAM Console
1. In `IAM Console` on left side menu, click on `Roles` and then `Create Role`
    ![Bean-1](../demos/steps-screenshots/bean-1.png)

1. Choose Trusted entity type `AWS Services` and then use-case `EC2`

    ![Bean-2](../demos/steps-screenshots/bean-2.png)
    ![Bean-3](../demos/steps-screenshots/bean-3.png)


1.  Search for Permissions `AWSElasticBeanstalkWebTier` and once found, use checkbox to select and then click `Next`

    ![Bean-4](../demos/steps-screenshots/bean-4.png)

1.  Provide a new name for the role, you should use this role as `EC2 profile` later in Elastic BeanStalk Environment.

    ![Bean-5](../demos/steps-screenshots/bean-5.png)
    ![Bean-6](../demos/steps-screenshots/bean-6.png)