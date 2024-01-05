import boto3

s3 = boto3.resource('s3',region_name='us-east-1')

for bucket in s3.buckets.all():
    print(bucket.name)

response = s3.create_bucket(
    Bucket='xyz1y2yt',
    CreateBucketConfiguration={
        'LocationConstraint': 'us-east-1',
    },
)
print (response)

## Get the S3 client to perform CRUD on bucket objects
client = boto3.client('s3')
client.put_object(Bucket='xyz1y2yt', Key='file101.txt', Body=b'Hello World')