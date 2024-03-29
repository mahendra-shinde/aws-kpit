# NoSQL Database : AWS DynamoDB

NoSQL databases are a category of databases that provide a flexible and scalable approach to storing and retrieving data. Unlike traditional relational databases, which are based on a structured schema and use SQL for querying, NoSQL databases are designed to handle unstructured or semi-structured data and offer a variety of data models, such as document-oriented, key-value pairs, wide-column stores, or graph databases.

AWS DynamoDB is a fully managed NoSQL database service provided by Amazon Web Services (AWS). It is designed for high-performance and scalable applications with a need for low-latency data access. Here are some key features and concepts related to AWS DynamoDB:

1. **NoSQL Model:**
   - DynamoDB follows the key-value pair and document-oriented NoSQL model. Data is stored in flexible JSON-like documents, known as items.

2. **Tables:**
   - In DynamoDB, data is organized into tables. Each table is a collection of items, where each item represents a data record.

3. **Primary Key:**
   - Every DynamoDB table must have a primary key, which uniquely identifies each item in the table. The primary key can be a single attribute (simple primary key) or a combination of two attributes (composite primary key).

4. **Attributes:**
   - Items in DynamoDB tables consist of attributes, which are similar to fields or columns in a traditional database. Each attribute has a name and a value.

5. **Provisioned Throughput:**
   - DynamoDB requires users to specify the desired throughput capacity for both read and write operations. This capacity can be provisioned in advance to handle varying workloads.

6. **Auto Scaling:**
   - DynamoDB provides auto-scaling capabilities, allowing the database to automatically adjust its capacity based on the workload. This helps ensure consistent performance without manual intervention.

7. **Secondary Indexes:**
   - DynamoDB supports the creation of secondary indexes, allowing efficient querying of data based on attributes other than the primary key. This enables more flexibility in accessing and retrieving data.

8. **DynamoDB Streams:**
   - DynamoDB Streams is a feature that captures changes to items in a table. It enables the tracking of modifications and can be used for various purposes, such as triggering AWS Lambda functions in response to changes.

9. **Global Tables:**
   - DynamoDB supports the creation of global tables, allowing the replication of data across multiple AWS regions. This helps achieve low-latency access and provides disaster recovery capabilities.

10. **On-Demand Capacity:**
    - In addition to provisioned throughput, DynamoDB also offers on-demand capacity, where users pay for the read and write capacity they consume, without the need to provision capacity in advance.

AWS DynamoDB is widely used for various applications, including web and mobile applications, gaming, Internet of Things (IoT), and other scenarios where fast and scalable NoSQL database capabilities are required.

## DynamoDB Demo


1. **Sign in to the AWS Management Console:**
   - Go to the AWS Management Console (https://aws.amazon.com/), and sign in with your AWS account credentials.

2. **Navigate to DynamoDB:**
   - Once signed in, navigate to the DynamoDB service. You can find it under the "Database" section in the AWS Management Console.

3. **Click "Create Table":**
   - In the DynamoDB dashboard, click on the "Create table" button to begin the table creation process.

4. **Enter Table Details:**
   - Provide a name for your table in the "Table name" field.
   - Specify the primary key for your table. You can choose between a simple primary key (partition key) or a composite primary key (partition key and sort key).
   - Set the data types for your primary key attributes.

5. **Configure Provisioned Throughput or Use On-Demand:**
   - DynamoDB allows you to choose between Provisioned and On-Demand capacity modes.
     - For Provisioned Throughput, specify the desired read and write capacity units.
     - For On-Demand, you don't need to specify capacity; DynamoDB automatically scales based on actual consumption.

6. **Configure Additional Settings:**
   - Expand the "Additional settings" section to configure optional settings, such as encryption, auto-scaling, and DynamoDB Streams.
   - You can also enable a Time to Live (TTL) attribute if you want to automatically delete items after a certain period.

7. **Create Table:**
   - Once you've configured all the settings, click the "Create" button to create your DynamoDB table.

8. **Table Creation Confirmation:**
   - DynamoDB will take a few moments to create the table. Once the table is created, you will see a confirmation message.

Your DynamoDB table is now ready to use. You can start adding items, querying data, and performing other operations depending on your application requirements.

## Connect DynamoDB using AWS CLI

To interact with DynamoDB from the AWS Command Line Interface (CLI), you can use the `aws dynamodb` commands. Here are the basic steps to connect to DynamoDB and perform operations using the CLI:

### 1. Install and Configure AWS CLI:

Make sure you have the AWS CLI installed on your machine. You can download it from the [official AWS CLI website](https://aws.amazon.com/cli/).

After installation, configure the AWS CLI with your AWS credentials:

```bash
aws configure
```

You will be prompted to enter your AWS Access Key ID, Secret Access Key, default region, and output format.

### 2. Use DynamoDB Commands:

#### List Tables:

To list all the DynamoDB tables in your account, use the following command:

```bash
aws dynamodb list-tables
```

#### Describe Table:

To get detailed information about a specific DynamoDB table, use the `describe-table` command:

```bash
aws dynamodb describe-table --table-name YourTableName
```

```bash
aws dynamodb describe-table --table-name contacts
```

#### Put Item:

To add an item to a DynamoDB table, use the `put-item` command. Replace `YourTableName` with your actual table name and provide the item attributes:

```bash
aws dynamodb put-item --table-name YourTableName --item '{"AttributeName1": {"S": "Value1"}, "AttributeName2": {"N": "123"}}'
```

```bash
aws dynamodb put-item --table-name "contacts" --item '{ "contactid": { "N": "101" }, "lastname": { "S" :"Shinde" }, "firstname": { "S": "Dakshata" }, "school": { "S" :"St Mary" } }'
```

#### Get Item:

To retrieve an item from a DynamoDB table, use the `get-item` command:

```bash
aws dynamodb get-item --table-name YourTableName --key '{"AttributeName1": {"S": "Value1"}}'
```

```bash
aws dynamodb get-item   --table-name="contacts" --key='{ "contactid": { "N": "101" }, "lastname":{"S":"Shinde"}}'
```
#### Get All items

```bash
aws dynamodb scan --table-name contacts --output yaml
```

#### Query:

To perform a query operation, use the `query` command. This example queries based on a specific attribute value:

```bash
aws dynamodb query --table-name YourTableName --key-condition-expression "AttributeName = :value" --expression-attribute-values '{":value":{"S":"Value1"}}'
```

These are just basic examples, and there are many other DynamoDB operations you can perform using the AWS CLI. Refer to the [AWS CLI DynamoDB documentation](https://docs.aws.amazon.com/cli/latest/reference/dynamodb/index.html) for a comprehensive list of commands and options.

Remember to replace placeholders like `YourTableName`, `AttributeName`, and `Value1` with your actual table name, attribute names, and values.

## Connect and Use DynamoDB from Java Application

Make sure you have the AWS SDK for Java added to your project. If you're using Maven, you can include the following dependency in your `pom.xml`:

```xml
<dependencies>
   <dependency>
      <groupId>com.amazonaws</groupId>
      <artifactId>aws-java-sdk-dynamodb</artifactId>
      <version>1.12.633</version>
   </dependency>
</dependencies>
```

Now, you can use the following Java code:

```java

import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
public class DynamoDBTableCreation {

    public static void main(String[] args) {
        // Set up the DynamoDB client
         AmazonDynamoDB client = AmazonDynamoDBClient.builder().withRegion("us-east-1").build();
         ListTablesResult result = client.listTables();
         System.out.println("Number of tables in dynamodb: "+result.getTableNames().size());

         for(String table : result.getTableNames()){
            System.out.println("Table found: "+table);

            ScanResult scanResult = client.scan(new ScanRequest(table));
            for(Map<String, AttributeValue> item :  scanResult.getItems() ){
               for(String key : item.keySet()){
                System.out.println(key +" = "+ item.get(key) );
               }
            }
        }

    }
}
```

## Connect DynamoDB using Python boto3

To create a DynamoDB table and add records using Python and `boto3`, you need to have the `boto3` library installed. You can install it using:

```bash
pip install boto3
```

Here's an example Python script that demonstrates how to create a DynamoDB table and add records using `boto3`:

```python
import boto3

# Replace these values with your own
table_name = 'students'

# Initialize DynamoDB client
dynamodb = boto3.client('dynamodb')

# Define the table schema
table_schema = [
    {
        'AttributeName': 'rollnum',
        'KeyType': 'HASH'  # Hash key
    },
    {
        'AttributeName': 'lastname',
        'KeyType': 'RANGE'  # Sort key
    }
]

# Define the provisioned throughput for the table
provisioned_throughput = {
    'ReadCapacityUnits': 5,
    'WriteCapacityUnits': 5
}

# Create the table
dynamodb.create_table(
    TableName=table_name,
    AttributeDefinitions=[
        {'AttributeName': 'rollnum', 'AttributeType': 'N'},
        {'AttributeName': 'lastname', 'AttributeType': 'S'}
    ],
    KeySchema=table_schema,
    ProvisionedThroughput=provisioned_throughput
)

print(f'Table {table_name} created. Please wait for it to become active.')

# Wait for the table to become active
dynamodb.get_waiter('table_exists').wait(
    TableName=table_name
)

# Put some sample records into the table
items_to_put = [
    {'rollnum': {'N': '1'}, 'lastname': {'S': 'Kale'}, 'firstname': {'S': 'Asha'}},
    {'rollnum': {'N': '2'}, 'lastname': {'S': 'Bhosale'}, 'firstname': {'S': 'Asha'}},
    # Add more items as needed
]

for item in items_to_put:
    dynamodb.put_item(
        TableName=table_name,
        Item=item
    )

print('Records added to the table.')
```

This script creates a DynamoDB table with a composite primary key (partition key and sort key) and provisions throughput for read and write capacity. It then waits for the table to become active before adding sample records to it. Adjust the schema, throughput, and items as needed for your specific use case.