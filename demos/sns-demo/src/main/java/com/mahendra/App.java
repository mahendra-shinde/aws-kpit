package com.mahendra;

import java.util.List;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicRequest;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicResult;
import com.amazonaws.services.sns.model.ListTopicsResult;
import com.amazonaws.services.sns.model.Subscription;
import com.amazonaws.services.sns.model.Topic;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AmazonSNS client = AmazonSNSClient.builder().withRegion("us-east-1").build();
        ListTopicsResult result = client.listTopics();
        List<Topic> topics =  result.getTopics();
        for(Topic t : topics){
            System.out.println("Topic Details :");
            System.out.println("Name: "+ t.getTopicArn().split(":")[5]);
            ListSubscriptionsByTopicResult results = client.listSubscriptionsByTopic(t.getTopicArn());
            for(Subscription sub : results.getSubscriptions()){
                System.out.println("\tSubscription : [ "+sub.getProtocol()+" ] "+sub.getEndpoint());
            }
        }

        client.publish("arn:aws:sns:us-east-1:890756660068:news", "The quick brown fox jumps over the lazy dog. The quick brown fox jumps over the lazy dog.  The quick brown fox jumps over the lazy dog.  ", "Prices of Oil dropped by 10%");

        CreateTopicResult result2 =  client.createTopic("discount-offers");
        String topicArn = result2.getTopicArn();
        client.subscribe(topicArn, "email", "mahendra_unlimited@hotmail.com");

        client.publish(topicArn, "The quick brown fox jumps over the lazy dog. The quick brown fox jumps over the lazy dog.  The quick brown fox jumps over the lazy dog.  ", "Prices of Oil dropped by 10%");
    }
}
