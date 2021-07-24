package com.example;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;

public class LambdaMethodHandler {

	
	public String handleRequest(Map<String, Object> objeto, Context context) {
        context.getLogger().log("Input: " + objeto);
        Object age = objeto.get("age");
        if(age != null 
        		&& Integer.parseInt(age.toString()) > 29 && Integer.parseInt(age.toString()) < 41) {
        	return "Ingreso";
        }
        return "No ingreso";
    }
	
}
