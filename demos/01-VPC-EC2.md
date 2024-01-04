# Demo 1 : VPC and EC2 Instances

> Create EC2 instances inside a VPC 

## VPC and Subnet

1. Create a new VPC "app1" with additional tag `user=mahendra`

    - IP Address Range : `10.0.0.0/16`

2. Create THREE new Public Subnets

	- Subnet-A-AVzone-a : 10.0.1.0/24
	- Subnet-B-AVzone-b : 10.0.2.0/24
	- Subnet-C-AVzone-c : 10.0.3.0/24

## Create the FIRST ec2 instance in First Subnet

1. Search for `EC2` and click to open `EC2` Console
1. Click on `Launch Instance`
1. Use Display name `web1`, use Additional tags `user=mahendra`
1. Choose AMI (Template/Image) : `Ubuntu`
1. Choose the EC2 Instance Size : `t2.micro` or `t3.micro`
1. For Key pair, use option `Create new key pair`
    
    > Your browser should auto-download the `.pem` file.

1. In Network Settings, use `EDIT` button to modify settings

    - Choose the network created in previous steps
    - Choose First Subnet (Should be in AZ `a`)
    - Enable `Auto assign Public IP`

1. For `Security Group` choose option to `Create new security group`

    - Enter name of security group `mahendra-sg`
    - Add new rule (Use `Add security group rule` button)
        . Use protocol `HTTP` and Source `Anywhere`
        . Click `Save`

1.  Click `Create Instance` and wait for EC2 instance to be ready.
