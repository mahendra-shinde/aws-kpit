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
