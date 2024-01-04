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

    