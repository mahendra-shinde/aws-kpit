package com.mahendra;

import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

public class App 
{
    public static void main( String[] args )
    {
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
