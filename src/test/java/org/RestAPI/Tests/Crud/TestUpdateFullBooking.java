package org.RestAPI.Tests.Crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.RestAPI.Base.CommontoAll;
import org.RestAPI.Modules.PayloadManager;
import org.RestAPI.Pojos.Respons.BookingResponse;
import org.RestAPI.endpoint.APIConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUpdateFullBooking extends CommontoAll {

    @Owner("Rajat")
    @Description("put")
    @Test
    public void UpdateFull(){

        String token = CreateaToken();

         requestSpecification.basePath("/booking/1687");
         response = RestAssured.given(requestSpecification).cookie("token",token).body(payloadManager.CreteBookingWithwrongBody()).
                 when().log().all().put();

        BookingResponse bookingResponse = payloadManager.bookingResponse(response.asString());

        validatableResponse = response.then().log().all();

        assertsActions.verifyStringKeyNotNull(bookingResponse.getFirstname());
        Assert.assertEquals(response.getStatusCode(),200);




    }

}
