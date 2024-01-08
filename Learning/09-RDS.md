# Relational Database Services (RDS)

Amazon RDS (Relational Database Service) is a managed database service provided by Amazon Web Services (AWS). It simplifies the process of setting up, operating, and scaling a relational database in the cloud. Amazon RDS supports various database engines, including MySQL, PostgreSQL, Oracle, Microsoft SQL Server, and Amazon Aurora (a MySQL and PostgreSQL-compatible database engine developed by AWS).

Here are some key features and concepts related to Amazon RDS:

1. **Managed Service:** Amazon RDS is a fully managed service, which means AWS handles routine database tasks such as backups, software patching, and monitoring. This allows users to focus more on their applications and less on database administration.

1. **Database Engines:** RDS supports multiple database engines, allowing users to choose the engine that best fits their application's requirements. Commonly supported engines include MySQL, PostgreSQL, Oracle, Microsoft SQL Server, and Amazon Aurora.

1. **Automated Backups:** RDS automatically performs regular backups of your database, allowing you to restore to any point in time within the retention period. You can also manually initiate backups.

1. **High Availability:** Amazon RDS provides options for high availability through features like Multi-AZ (Availability Zone) deployments. In a Multi-AZ setup, a standby replica of the database is maintained in a different Availability Zone to provide fault tolerance.

1. **Scalability:** You can easily scale your database instance vertically (by increasing or decreasing the instance size) or horizontally (by adding read replicas). This helps accommodate changing workloads and performance requirements.

1. **Security:** RDS offers various security features, including network isolation using Amazon VPC (Virtual Private Cloud), encryption at rest using AWS Key Management Service (KMS), and encryption in transit using SSL/TLS.

1. **Monitoring and Metrics:** Amazon RDS provides monitoring and logging features through Amazon CloudWatch. This allows you to track database performance, set up alarms, and access detailed logs for analysis.

1. **Parameter Groups:** You can customize database engine settings using parameter groups. This allows you to tune the database engine according to your specific requirements.

1. **Compatibility:** RDS is designed to be compatible with existing database applications and tools. It supports common database APIs and allows for easy migration of databases to and from the AWS cloud.

1. **Maintenance and Patching:** AWS takes care of routine maintenance tasks, including applying patches and updates to the database engine. This helps ensure that your database is running the latest security updates and improvements.

Amazon RDS is a popular choice for organizations looking to offload the management of their relational databases to AWS, allowing them to focus on building and improving their applications.

## [DEMO] Creating and Using RDS with MySql Database Engine 

### Step 1: Sign in to AWS Console

1. Go to the [AWS Management Console](https://aws.amazon.com/console/).
2. Sign in to your AWS account.

### Step 2: Navigate to RDS Service

1. In the AWS Management Console, navigate to the "RDS" service.

### Step 3: Create a New DB Instance

1. Click on the "Create database" button.
1. Choose the "Standard create" option.
1. Select the "Engine options" as "MySQL."
1. Choose the appropriate version of MySQL for your application (I Preffer latest version).
1. In the "Templates" section, you can choose a predefined template or create a custom one.
1. In the "Settings" section:
   - Set a DB instance identifier (a name for your RDS instance).
   - Set a Master username and password (these credentials will be used to access the MySQL database).
   - Choose a DB instance size (the computing and memory capacity).
   - Optionally, configure the storage settings and enable Multi-AZ for high availability.
   
1. In the "DB instance size" section, select the appropriate instance size.
1. Configure the storage settings, including allocated storage and whether to enable automatic storage scaling.
1. In the "Connectivity" section:
   - Choose the VPC (Virtual Private Cloud) where you want to launch the RDS instance.
   - Configure the subnet group and choose the security group settings.
   - Configure public accessibility if needed.

10. In the "Database authentication" section, choose the authentication method (password authentication is common).
11. In the "Additional configuration" section, configure additional settings if necessary.
12. Click "Create database" to start the RDS instance creation.

### Step 4: Wait for the RDS Instance to be Ready

The RDS instance creation may take some time. You can monitor the progress on the RDS dashboard. Once the status is "available," your RDS instance is ready to use.

### Step 5: Connect to the MySQL Database

1. Retrieve the endpoint of your RDS instance from the RDS dashboard.
2. Use a MySQL client (e.g., MySQL Workbench, MySQL command-line client) to connect to the RDS instance using the provided endpoint, master username, and password.

    > You may use `SQLTools MySQL/MariaDB` extension of VSCode to connect

    > My Sample Database connection string

    ```ini
    MySQL-Endpoint = sampledb.cimr0kdyqj64.us-east-1.rds.amazonaws.com
    Username = admin
    Password = Password!123
    Default-Database = sys
    ```

### Step 6: Manage Your MySQL Database

Once connected, you can manage your MySQL database as you would with any other MySQL instance. Create databases, tables, and users, and execute queries based on your application requirements.

> Database creation (Schema)

```sql
create schema sampledb;
```

> Sample Table creation

```sql
use sampledb;

CREATE TABLE employees
( empid int primary key auto_increment,
firstname varchar(20),
lastname varchar(30) );

INSERT into employees (firstname, lastname)
VALUES ('Donald','Duck');

INSERT into employees (firstname, lastname)
VALUES ('Micky','Mouse');
```

### Step 7: Monitor and Manage Through AWS Console

Utilize the AWS Management Console to monitor the performance, configure backups, and make adjustments to your RDS instance as needed.

## Connect from Python Application

To consume an AWS RDS (MySQL) database from a Python application, you can use the `mysql-connector-python` library, which is a MySQL driver for Python. Here are the general steps to connect to an AWS RDS MySQL database from a Python app:

### Step 1: Install the MySQL Connector

Before you start, you need to install the `mysql-connector-python` library. You can do this using pip:

```bash
pip install mysql-connector-python
```

### Step 2: Obtain RDS Connection Details

1. Retrieve the endpoint (hostname) and port number of your RDS instance from the AWS Management Console.
2. Ensure that your security group settings allow inbound traffic on the MySQL port (default is 3306).

### Step 3: Create a Python Script

Create a Python script in your project directory to interact with the AWS RDS MySQL database. Let's call it `app.py`.

```python
import mysql.connector

# AWS RDS MySQL connection parameters
host = "your-rds-endpoint.amazonaws.com"
user = "your-username"
password = "your-password"
database = "your-database"

# Establish a connection
try:
    connection = mysql.connector.connect(
        host=host,
        user=user,
        password=password,
        database=database
    )
    if connection.is_connected():
        print("Connected to the database")
        
        # Create a cursor
        cursor = connection.cursor()

        # Execute SQL queries
        cursor.execute("SELECT * FROM your_table")
        rows = cursor.fetchall()

        # Process the result
        for row in rows:
            print(row)

except mysql.connector.Error as err:
    print(f"Error: {err}")

finally:
    # Close the cursor and connection
    if 'cursor' in locals():
        cursor.close()
    if 'connection' in locals() and connection.is_connected():
        connection.close()
        print("Connection closed")
```

Replace placeholders (`your-rds-endpoint`, `your-username`, `your-password`, `your-database`, `your_table`) with your actual AWS RDS MySQL details.

### Step 4: Run the Python Script

Execute the Python script:

```bash
python app.py
```

This script establishes a connection to your AWS RDS MySQL instance, executes a simple SELECT query, and prints the results.

Ensure that your Python environment has internet access to reach the AWS RDS endpoint.

### Notes:

- Always handle database connections properly, closing them in a `finally` block to ensure resources are released.
- Avoid hardcoding sensitive information in your code. You might want to use environment variables or a configuration file for credentials.
- Make sure your AWS security group allows inbound traffic on the MySQL port from the machine running your Python application.
- Depending on your use case, you might want to use an ORM (Object-Relational Mapping) library like SQLAlchemy to interact with the database more abstractly.

Adjust the script based on your specific requirements and the structure of your AWS RDS MySQL database.


## Connect from Java Application

To consume an AWS RDS (MySQL) database from a Maven-based Java application, you'll need to use the MySQL Connector/J library for Java to connect to the database. Here are the general steps to achieve this:

### Step 1: Set Up AWS RDS MySQL Database

Ensure that you have an AWS RDS MySQL database instance set up. Note down the endpoint (hostname), port number, database name, and credentials (username and password).

### Step 2: Create a Maven Project

Create a new Maven project if you don't have one already. You can use VSCode `Maven Extension` to create a new project using `Maven-Quick-start` template


### Step 3: Add MySQL Connector/J Dependency

Edit the `pom.xml` file of your Maven project to include the MySQL Connector/J dependency:

```xml
<dependencies>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>8.2.0</version> 
    </dependency>
</dependencies>
```

### Step 4: Create a Java Class for Database Interaction

Create a Java class in the `src/main/java/com/example` directory to interact with the AWS RDS MySQL database. Let's call it `DatabaseApp.java`.

```java
package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseApp {

    public static void main(String[] args) {
        // AWS RDS MySQL connection parameters
        String jdbcUrl = "jdbc:mysql://your-rds-endpoint:3306/your-database";
        String user = "your-username";
        String password = "your-password";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            try (Connection connection = DriverManager.getConnection(jdbcUrl, user, password)) {
                System.out.println("Connected to the database");

                // Sample query
                String sql = "SELECT * FROM your_table";
                try (PreparedStatement statement = connection.prepareStatement(sql);
                     ResultSet resultSet = statement.executeQuery()) {

                    // Process the result
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("column_name"));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
```

Replace placeholders (`your-rds-endpoint`, `your-username`, `your-password`, `your-database`, `your_table`, `column_name`) with your actual AWS RDS MySQL details.

### Step 5: Run the Java Application

Run your Java application from VSCode

Ensure that your Java environment has internet access to reach the AWS RDS endpoint.

### Notes:

- Always handle database connections properly, closing them in a `try-with-resources` block to ensure resources are released.
- Avoid hardcoding sensitive information in your code. You might want to use external configuration files or environment variables for credentials.
- Depending on your use case, you might want to use a connection pool like HikariCP for efficient database connection management.
- Adjust the code based on your specific requirements and the structure of your AWS RDS MySQL database.

This example uses plain JDBC for simplicity, but you may also consider using an ORM library like Hibernate if your application requirements become more complex.