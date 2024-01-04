# Demo 3 : Load Balancer Demo

> Setup a load-balancer (Elastic Load Balancer) to distribute the incoming traffic (HTTP) to three EC2 instances in target group

## Resources that can be `shared` by multiple EC2 instance

    - VPC and Subnet
    - Security Group
    - Key Pair
    - Load Balancer

## Create the FIRST ec2 instance


1. Search for `EC2` and click to open `EC2` Console
1. Click on `Launch Instance`
1. Use Display name `web-1`, use Additional tags `user=mahendra`
1. Choose AMI (Template/Image) : `Ubuntu`
1. Choose the EC2 Instance Size : `t2.micro` or `t3.micro`
1. For Key pair, use option 'Select Existing' and then choose `key101`

1. In Network Settings, use `EDIT` button to modify settings

    - Choose the network created in previous steps
    - Choose First Subnet (Should be in AZ `a`)
    - Enable `Auto assign Public IP`

1. For `Security Group` choose option to `Select Existing` and choose `mahendra-sg`

1.  Click `Create Instance` and wait for EC2 instance to be ready.

## Create the SECOND ec2 instance

1. Search for `EC2` and click to open `EC2` Console
1. Click on `Launch Instance`
1. Use Display name `web-2`, use Additional tags `user=mahendra`
1. Choose AMI (Template/Image) : `Ubuntu`
1. Choose the EC2 Instance Size : `t2.micro` or `t3.micro`
1. For Key pair, use option 'Select Existing' and then choose `key101`

1. In Network Settings, use `EDIT` button to modify settings

    - Choose the network created in previous steps
    - Choose Second Subnet (Should be in AZ `b`)
    - Enable `Auto assign Public IP`

1. For `Security Group` choose option to `Select Existing` and choose `mahendra-sg`

1.  Click `Create Instance` and wait for EC2 instance to be ready.

## Create the THIRD ec2 instance

1. Search for `EC2` and click to open `EC2` Console
1. Click on `Launch Instance`
1. Use Display name `web-3`, use Additional tags `user=mahendra`
1. Choose AMI (Template/Image) : `Ubuntu`
1. Choose the EC2 Instance Size : `t2.micro` or `t3.micro`
1. For Key pair, use option 'Select Existing' and then choose `key101`

1. In Network Settings, use `EDIT` button to modify settings

    - Choose the network created in previous steps
    - Choose Third Subnet (Should be in AZ `c`)
    - Enable `Auto assign Public IP`

1. For `Security Group` choose option to `Select Existing` and choose `mahendra-sg`

1.  Click `Create Instance` and wait for EC2 instance to be ready.

## Install the necessory packages (nginx) inside all three instances

1. Using either Command prompt or Powershell connect the instance 'web-1'

    ```
    ssh -i key101.pem ubuntu@WEB-1-PUBLIC_IP
    sudo apt update -y
    sudo apt install nginx -y
    ```

1. Using either Command prompt or Powershell connect the instance 'web-2'

    ```pwsh
    ssh -i key101.pem ubuntu@WEB-2-PUBLIC_IP
    sudo apt update -y
    sudo apt install nginx -y
    ```

1. Using either Command prompt or Powershell connect the instance 'web-3'

    ```pwsh
    ssh -i key101.pem ubuntu@WEB-3-PUBLIC_IP
    sudo apt update -y
    sudo apt install nginx -y
    ```

1.  Copy the original HTML and CSS file inside 'web-1'

    ```pwsh
    scp -i key101.pem  D:\git\aws-kpit\demos\src\index.html  ubuntu@WEB-1-PUBLIC_IP:/home/ubuntu
    scp -i key101.pem  D:\git\aws-kpit\demos\src\main.css  ubuntu@WEB-1-PUBLIC_IP:/home/ubuntu
    ssh -i key101.pem ubuntu@WEB-1-PUBLIC_IP
    ls
    sudo mv * /var/www/html
    ```

1.  Modify index.html, add web-2 somewhere in H1 or page title

1.  Copy the original HTML and CSS file inside 'web-2'

    ```pwsh
    scp -i key101.pem  D:\git\aws-kpit\demos\src\index.html  ubuntu@WEB-2-PUBLIC_IP:/home/ubuntu
    scp -i key101.pem  D:\git\aws-kpit\demos\src\main.css  ubuntu@WEB-2-PUBLIC_IP:/home/ubuntu
    ssh -i key101.pem ubuntu@WEB-2-PUBLIC_IP
    ls
    sudo mv * /var/www/html
    ```

1.  Modify index.html, add web-3 somewhere in H1 or page title

1.  Copy the original HTML and CSS file inside 'web-3'

    ```pwsh
    scp -i key101.pem  D:\git\aws-kpit\demos\src\index.html  ubuntu@WEB-3-PUBLIC_IP:/home/ubuntu
    scp -i key101.pem  D:\git\aws-kpit\demos\src\main.css  ubuntu@WEB-3-PUBLIC_IP:/home/ubuntu
    ssh -i key101.pem ubuntu@WEB-3-PUBLIC_IP
    ls
    sudo mv * /var/www/html
    ```

1.  Verify if application is running in ALL THREE instances

    Open THREE browser windows, each trying access Public IP of each EC2 instance

## Create a Target group with HTTP Health probe

1.  In `EC2 Console`, scroll down navigation bar (left sidebar) for "Load Balancering". Click "Target Groups"

1.  Click `Create Target Group`, then choose `Instances` 

    - Provide target group name `webapp-group`
    - Choose protocol `HTTP` > HTTP/1
    - Choose VPC (same as EC2 instances)
    - In Health probe, select HTTP and click `Advance Health check settings`
        * Either modify or accept the default values for
            - Healthy Threshold
            - Unhealthy Threshold
            - timeout
            - interval
            - Success Code [200]
    - Click Next button
    - Select all the EC2 instance and click `Include as pending below`
    - Click `Create Target group` button

## Create a new Application Load Balancer

1.  In `Load Balancing` select Load Balancer > Click `Create Load Balancer`
1.  Choose `Application Load Balancer` -> `Create`
1.  Provide following details for new load balancer
    - Name: app1-l
    - Scheme: internet [Public IP]
    - VPC : Same as EC2 instances
    - Subnet : Select Any TWO minimum
    - Security Group : Choose same one as EC2 instances
    - Listener : Port-> 80, Target Group -> webapp-group
1.  Now click `Create load balancer` button
1.  Wait for 2-3 minutes and check the `Status` of load balancer, once status is `Active`, use the DNS name of load balancer in new browser it should be similar to `http://app1-lb-1840556944.us-east-1.elb.amazonaws.com/`

## Clean Up

1.  All the resources should be delete in THIS order

    1. Load Balancer
    2. Target Group
    3. EC2 Instance
    4. Security Group
    5. VPC