package org.RestAPI.Tests.Crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.RestAPI.Assert.AssertsActions;
import org.RestAPI.Base.CommontoAll;
import org.RestAPI.Modules.PayloadManager;
import org.RestAPI.Pojos.Request.authrequestPojo;
import org.RestAPI.Pojos.Respons.BookingResponse;
import org.RestAPI.endpoint.APIConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestCreateToken extends CommontoAll {


    @Owner("Rajat")
    @Description("Creating A Auth token")
    @Test
    public void Test_CreateaToken(){

        requestSpecification.basePath(APIConstants.Auth_URL);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.CreatAuth()).post();

//        BookingResponse bookingResponse = payloadManager.bookingResponse(response.asString());
        String gettoken = payloadManager.GetToken(response.asString());
//        validatableResponse.statusCode(200);
        System.out.println(gettoken);

        assertsActions.VerifyStatusCode(response,200);
        assertsActions.verifyStringKeyNotNull(gettoken);
    }




}
