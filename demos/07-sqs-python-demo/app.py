import boto3

sqs = boto3.client('sqs')

response = sqs.receive_message(QueueUrl="https://sqs.us-east-1.amazonaws.com/890756660068/orders")

for message in response['Messages']:
    print (message['Body'])