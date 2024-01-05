package com.mahendra;

import java.util.List;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;

public class App 
{
    public static void main( String[] args )
    {
       AmazonSQS sqs = AmazonSQSClient.builder().withCredentials(
            new ProfileCredentialsProvider()
       ).withRegion("us-east-1").build();

       String queueUrl = "https://sqs.us-east-1.amazonaws.com/890756660068/orders";

       // Get All the messages from the queue
       List<Message> messages = sqs.receiveMessage(queueUrl).getMessages();
       //messages.forEach(m -> System.out.println(m.getBody()));
       for(Message m : messages){
            System.out.println("Message: "+m.getBody());
            System.out.println("Attributes: "+m.getAttributes());
            System.out.println("Delete from the queue: ");
            String handle = m.getReceiptHandle();
            sqs.deleteMessage(queueUrl, handle);
       }

    }
}
