# RDS Troubleshooting

1. Database instance created in AWS Console is not same as "create databse" query !

1. Create Database query is used for creating "Schema" which is logical group
of DB Objects like tables, views etc.

1. To connect database, use "Initial Database" "sys" which is system-database and it is auto-created

1. Once connected for FIRST TIME, create schema "sampledb" using either one command:
	
    ```sql
	create database sampledb
	-- OR --
	create schema sampledb
    ```
1. Once initial database `sampledb` is ready, create a sample table:

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

    commit; -- Commit all changes [OPTIONAL]
    ```
1. Now, you can edit connection settings and use `sampledb`` instead of `sys`

1.  Once connected try following commands to check if your are able to fetch all data.

    ```sql
    use sampledb;
    select * from employees;
    ```


	