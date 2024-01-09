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