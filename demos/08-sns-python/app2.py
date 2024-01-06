import boto3

client = boto3.client('sns')

resp1 = client.create_topic(Name="discountoffers")
arn = resp1['TopicArn']
print ("Created a new topic "+arn)

resp2 = client.subscribe(TopicArn=arn, Protocol='email', Endpoint='mahendra_unlimited@hotmail.com', ReturnSubscriptionArn=True)





