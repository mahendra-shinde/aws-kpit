import boto3

s3 = boto3.resource('s3')

for bucket in s3.buckets.all():
    print(bucket.name)
    client.delete_bucket (Bucket=bucket.name)
    
response = s3.create_bucket(Bucket='abcd364687')
print (response)

## Get the S3 client to perform CRUD on bucket objects
client = boto3.client('s3')
client.put_object(Bucket='abcd364687', Key='file101.txt', Body=b'Hello World')