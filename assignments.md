# Practical Assignments 

## Assignment 1 : S3 Objects

> Task 1 : Using AWS WebConsole, create a new bucket with name "<yourname>-reports"

> Task 2 : Using Java/Python code, upload three files "jan.txt", "feb.txt" and "march.txt" to the bucket created in task-1 

	`Contents inside these files do not matter.`
	
> Task 3 : Using Web Console, set the "Storage class" for all TXT files to "OneZone-IA"

> Task 4 : Write another code to download all the TXT files from bucket into folder "C:\files"

	```java	
	// Hint [Download files using Java ]
 
	String contents = client.getObjectAsString("<yourname>-reports", "jan.txt");
	FileWriter out = new FileWriter(new File("c:\\files\\jan.txt"));
	out.write(contents);
	out.close();
	```

### Create a word document with all screenshots and code snippets


## Assignment 2 : SNS with RDS Database

> Task 1 : Using Web Console create a new SNS topic, "bill-alerts-<YOURNAME>" add one or two emails as subscribers

> Task 2 : Create a new RDS Database (MySQL) with database schema "bills" and table "utility-bills"
	Add following records 

	
	Month | Units Used | PayableAmount
	------|------------|---------------
	Jan   | 120        | 870
	Feb   | 87         | 730
	Mar   | 92         | 810 

> Task 3 : Build java/python application to send monthly bill details to all the subscribers.

- Each Email Subscriber should receive THREE mails
- Content of mail should be:


```txt	
Hi,
You bill for month <MONTH-FROM_DB> is due. Please pay Rs <AMT-FROM-DB> in 15 days.	
```

## Assignment 3 : 

MacroLight Ltd is building an application for their e-commerce platform `macrobuy.com`. They need to store all the product details in a database. Help them choose right database, making sure following requirements are met.

-	Database must be highly scalable
-   Database schema must be flexible enough, to add new attributes to records.
-	Handling Data inside database should be easy with API, no need for SQL like queries

Once you choose the database, create the table with following records:

	productId: P10102
	category:  Storage Device
	name:	   Ultra Store 32 GB
	other_name: Pen Drive
	weight:		8 Grams

	ProductId: P37446
	category:  Cloths
	size:	   XL
	colour:	   darkred
	material:	satin


	ProductId:	U3644748
	category:   Food
	expiry:     2 months from MFG
	MFG-date:	10th Jan, 2024

Write a code in java or python which should enable users to perform 'search' operation on above table. User should be able to search product using productId attribute.

