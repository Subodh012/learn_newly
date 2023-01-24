package api_udemy;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
public class Basic1
{
public static void main(String[] args) 
{
//validate if add place api is working or not
	
//api is mainly based on three concept
	
//given==all input details
//when==submit api
//then=validate api

	RestAssured.baseURI="https://www.rahulshettyacademy.com";
//	given().queryParam(DEFAULT_BODY_ROOT_PATH, null)
	
}
}
