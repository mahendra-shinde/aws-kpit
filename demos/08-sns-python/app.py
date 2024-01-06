import boto3

client = boto3.client('sns')

response = client.list_topics()

for topic in response['Topics']:
    arn = topic['TopicArn']
    name = arn.split(':')
    print ("Topic Name: " + name[5])
    response = client.list_subscriptions_by_topic(TopicArn=arn)
    for sub in response['Subscriptions']:
        print ("[ {} ] {} ".format(sub['Protocol'], sub['Endpoint']) )



print ("Publish a news ")

client.publish(TopicArn='arn:aws:sns:us-east-1:890756660068:news', Subject="Latest News in Pune", Message="The qucik brown fox jumps over the lazy dog.")