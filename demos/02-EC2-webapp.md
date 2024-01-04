# Demo 2 : Setup `Website` inside EC2 instance

1. Login into AWS Console and find your EC2 instance. 
   
    > Filter using tag `user=mahendra`

1. Copy the `Public IP` of EC2 instance. Also find the location of PEM file downloaded in `demo-1`

    > Default location of PEM would be `~\Downloads\key101.pem`

    > the filename depends on name of key

1.  Launch `Windows Powershell` from Start menu and use following commands

    ```pwsh
    cd Downloads
    dir *.pem
    ```

1.  Use following command, to ENTER inside Linux Server USING SSH protocol

    ```pwsh
    # ssh  -i PEM_FILE ubuntu@PUBLIC_IP_EC2
    ssh -i key101.pem ubuntu@3.93.172.183
    TRUST THIS SERVER ? > yes
    ## The prompt has been changed from Powershell to BASH shell (Linux Shell)
    ## Install NGINX
    sudo apt update -y
    sudo apt install nginx -y
    ```
 
1.  Verify the location of default `index.html` file in linux server.

    ```bash
    cd /var/www/html
    cat index.html
    # If the file exists, its contents should be displayed
    ```

1.  Try accessing this website from Browser `http://PUBLIC_IP_EC2`

1.  Go back to SSH prompt and use following commands to EXIT from linux server.

    ```pwsh
    exit
    # The prompt should be changed from Linux to Windows
    ```

1.  To copy files from Local (Windows) filesystem to linux filesystem we use following command:

    ```bash
    # SYNTAX
    scp -i PEM_FILE  SOURCE_FILE_PATH   USER@PUBLIC_IP:LINUX_DESTINATION_PATH
    ```

    ```pwsh
    scp -i key101.pem  D:\git\aws-kpit\demos\src\index.html  ubuntu@3.93.172.183:/home/ubuntu
    scp -i key101.pem  D:\git\aws-kpit\demos\src\main.css  ubuntu@3.93.172.183:/home/ubuntu
    ```

1.  Login with SSH and Move the files to correct location.

    ```pwsh
    ssh -i key101.pem ubuntu@3.93.172.183 
    ls 
    sudo mv * /var/www/html/
    exit
    ```

1.  Revisit the URL `http://PUBLIC_IP_EC2`