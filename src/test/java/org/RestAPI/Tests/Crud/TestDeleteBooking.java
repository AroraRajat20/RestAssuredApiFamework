package org.RestAPI.Tests.Crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.RestAPI.Base.CommontoAll;
import org.RestAPI.endpoint.APIConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDeleteBooking  extends CommontoAll {

    @Owner("Rajat Arora")
    @Description("Delete ID")
    @Test
    public void test_Delete(){
        String BookingID = "1542";
        String token = "c1ee7955e29b702";


        requestSpecification.basePath(APIConstants.UpdateBooking_URL + "/"+ BookingID).cookie("token", token);

        response = RestAssured.given(requestSpecification).when().delete();

        validatableResponse = response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),201);

//        assertsActions.VerifyStatusCode(response.getStatusCode(),201);

    }
}
