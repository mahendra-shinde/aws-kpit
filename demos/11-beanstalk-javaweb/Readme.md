# Java (Servlet / Tomcat ) Web application on BeanStalk

1. Create a maven project with name emp-demo, please refer to [sample](./emp-demo/) project

1.  Check if project is listed in `Maven` view, right click on project name and choose 
    `Run Maven Command > Package ` 

    ![Java App](../steps-screenshots/tomcat1.png)


1.  Maven should have created a `WAR` under `target` folder

    ![Java App](../steps-screenshots/tomcat2.png)

1.  Rename the generated file as `ROOT.war`

    ![Java App](../steps-screenshots/tomcat5.png)

1.  Create a new BeanStalk application for Tomcat Environment.

1.  Go to "Beanstalk Console" and click "Create Application" button

    ![Beanstalk python](../steps-screenshots/bean-01.png)

1.  Enter name of application (I have used `demo2`) and click `Create` button.

    ![Java App](../steps-screenshots/tomcat2.png)

1.  Once application is created, use `Create new Environment` button.

    ![Beanstalk tomcat](../steps-screenshots/bean-03.png)

1.  Choose type `Web Server Environment` and scroll down

    ![Beanstalk python](../steps-screenshots/bean-04.png)

1.  Enter the domain name and use button `Check Availability`, scroll down if domain is available, try with different name if not available.

    ![Beanstalk python](../steps-screenshots/bean-05.png)

1.  Platform selection: Tomcat, Tomcat 8.5 with Corretto 11 and scroll down

    ![Beanstalk tomcat](../steps-screenshots/tomcat4.png)

1.  Choose Application code : `Upload your code` and enter version label `version-1` and choose `Local file`, you need to select the ROOT.war file. Scroll down

    ![Beanstalk tomcat](../steps-screenshots/tomcat6.png)

1.  Choose `Preset` => Single Instance  and click `Next`

    ![Beanstalk tomcat](../steps-screenshots/bean-08.png)

1.  On next screen, choose service role (if exists) otherwise choose "Create New" option. Also select any existing EC2 Key Pair.  And choose EC2 Profile created earlier 

    > Refer to [EC2 Profile for ELB](../../Learning/13-IAM-Role-for-ELB-EC2.md) for creating this EC profile.

    ![Beanstalk tomcat](../steps-screenshots/bean-09.png)

    Click `Next` to continue.

1.  Choose any existing VPC (with Public Subnets) and scroll down.

    ![Beanstalk tomcat](../steps-screenshots/bean-10.png)

1.  Choose all the subnets and scroll down

    ![Beanstalk tomcat](../steps-screenshots/bean-11.png)

1.  Scroll down to `Next` button and click on `Next`.

    ![Beanstalk tomcat](../steps-screenshots/bean-12.png)

1.  Ignore all the options, scroll down and click `Next`

    ![Beanstalk tomcat](../steps-screenshots/bean-13.png)

1.  Choose `Basic` health monitoring and scroll down.

    ![Beanstalk tomcat](../steps-screenshots/bean-14.png)

1.  Disable the `Managed Updates` and scroll down for `Next` button.

    ![Beanstalk tomcat](../steps-screenshots/bean-15.png)

1.  Click the `Next` button.

    ![Beanstalk tomcat](../steps-screenshots/bean-16.png)

1.  Scroll down and click `Submit` button.

    ![Beanstalk tomcat](../steps-screenshots/bean-17.png)