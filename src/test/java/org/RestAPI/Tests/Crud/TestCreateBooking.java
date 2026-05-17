package org.RestAPI.Tests.Crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.RestAPI.Base.CommontoAll;
import org.RestAPI.Pojos.Respons.BookingResponse;
import org.RestAPI.endpoint.APIConstants;
import org.testng.annotations.Test;

public class TestCreateBooking  extends CommontoAll {


    @Owner("Rajat")
    @Description("TC#1 - create a booking with vaild data")
    @Test
    public void Test_Create_BookingWithVaildCred(){

//        requestSpecification.basePath(APIConstants.UpdateBooking_URL);
//
//        response = requestSpecification.when().body(payloadManager.Create_Booking_withUserData()).post();

        requestSpecification.basePath(APIConstants.UpdateBooking_URL);

        response = RestAssured.given(requestSpecification).when()
                .body(payloadManager.Create_Booking_withUserData()).post();

        BookingResponse bookingResponse = payloadManager.bookingResponse(response.asString());

        assertsActions.VerifyStatusCode(response,200);
        assertsActions.verifyStringKeyNotNull(bookingResponse.getBookingid());

        response.prettyPrint();


    }



}
