package org.RestAPI.Tests.Crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.RestAPI.Base.CommontoAll;
import org.RestAPI.Pojos.Respons.BookingResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUpdatepartialBooking extends CommontoAll {

    @Owner("Rajat")
    @Description("put")
    @Test
    public void Test_put()
    {
        String token= CreateaToken();
        requestSpecification.basePath("/booking/4191");
        response = RestAssured.given(requestSpecification).cookie("token", token).body(payloadManager.UpdatePut()).
                when().patch();
        validatableResponse =response.then().log().all();
        BookingResponse bookingResponse = payloadManager.bookingResponse(response.asString());
        Assert.assertEquals(response.getStatusCode(),200);

        assertsActions.verifyStringKeyNotNull(bookingResponse.getBookingid());






    }


}
