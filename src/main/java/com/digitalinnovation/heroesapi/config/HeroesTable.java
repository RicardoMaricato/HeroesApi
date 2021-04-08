package com.digitalinnovation.heroesapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static com.digitalinnovation.heroesapi.constans.HeroesConstant.ENDPOINT_DYNAMO;
import static com.digitalinnovation.heroesapi.constans.HeroesConstant.REGION_DYNAMO;

@Slf4j
public class HeroesTable {

    public static void main(String[] args) throws Exception {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        String tableName = "Heroes_Api_Table";

        try {
            log.info("Creating table, please wait...");
            Table table = dynamoDB.createTable(tableName,
                    Arrays.asList(new KeySchemaElement("id", KeyType.HASH)
                    ),
                    Arrays.asList(new AttributeDefinition("id", ScalarAttributeType.S)

                    ),
                    new ProvisionedThroughput(5L, 5L));
            table.waitForActive();
            log.info("Success " + table.getDescription().getTableStatus());

        }
        catch (Exception e) {
            log.info("The table could not be created");
            log.info(e.getMessage());
        }

    }
}
