package org.RestAPI.Tests.Crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.RestAPI.Base.CommontoAll;
import org.RestAPI.Pojos.Respons.GetbookingResponse;
import org.RestAPI.endpoint.APIConstants;
import org.RestAPI.listeners.TestListener;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@Listeners(TestListener.class)
public class TestCheckbooking extends CommontoAll {
    @Owner("Rajat")
    @Description("// 2. Verify that the Create Booking is working - GET Request to bookingID")

    @Test(priority = 1)
    public void Test_verify_BookingId(){

        Integer BookingID = 2809;


        requestSpecification.basePath(APIConstants.UpdateBooking_URL+"/"+ "728");
        response = RestAssured.given(requestSpecification).when().log().all().get();

//        assertsActions.verifyStringKeyNotNull(response);

        validatableResponse = response.then().log().all();


        validatableResponse.statusCode(201).body(matchesJsonSchemaInClasspath(
                "schema/booking-schema.json"
        ));


        GetbookingResponse getbookingResponse =payloadManager.getbookingResponse(response.asString());
//        assertsActions.verifyStringKeyNotNull(getbookingResponse.getFirstname());
    }
}
