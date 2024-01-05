import boto3

queueUrl="https://sqs.us-east-1.amazonaws.com/890756660068/orders"
sqs = boto3.client('sqs')

sqs.send_message(
        QueueUrl=queueUrl,
        MessageBody=('Hello Hinjawadi')
)

response = sqs.receive_message(QueueUrl=queueUrl)

for message in response['Messages']:
    print (message['Body'])

