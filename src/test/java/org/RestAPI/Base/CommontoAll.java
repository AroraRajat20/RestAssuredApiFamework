package org.RestAPI.Base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.RestAPI.Assert.AssertsActions;
import org.RestAPI.Modules.PayloadManager;
import org.RestAPI.endpoint.APIConstants;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import javax.swing.plaf.PanelUI;

public class CommontoAll {

    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;
    public AssertsActions assertsActions;
    public JsonPath jsonPath;
    public PayloadManager payloadManager;


    @BeforeTest
    public void Setup(){
        // Before making the request We have to setup the header and Base URL which is
        //+ common to all
        System.out.println("Test Strats form here");
        assertsActions = new AssertsActions();
        payloadManager = new PayloadManager();

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(APIConstants.BaseURL).contentType(ContentType.JSON).log().all();
//
//        requestSpecification = new RequestSpecBuilder().setBaseUri(APIConstants.BaseURL)
//                .addHeader("Content-Type", "application/json")
//                .build().log().all();


    }
    @AfterTest
    public void TearDown(){

        System.out.println("completed the Test");

    }


}
