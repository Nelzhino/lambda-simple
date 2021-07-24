package com.example;

import java.util.UUID;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.example.dto.UserRequest;
import com.example.dto.UserResponse;

public class SaveUserHandler implements RequestHandler<UserRequest, UserResponse> {

	private DynamoDB dynamoDB;
	private final String DYNAMODB_NAME_TABLE = "users";
	private final Regions REGION = Regions.US_EAST_1;

	public UserResponse handleRequest(UserRequest input, Context context) {
		this.dynamoDB = new DynamoDB(REGION);
		this.dynamoDB.getTable(DYNAMODB_NAME_TABLE).putItem(
				new Item()
					.with("id", UUID.randomUUID().toString())
					.with("name", input.getName())
					.with("country", input.getCountry())
					.with("age", input.getAge())
				);
		UserResponse userResponse = new UserResponse();
		userResponse.setMessages("Saved successfully!!!");

		return userResponse;
	}

}
