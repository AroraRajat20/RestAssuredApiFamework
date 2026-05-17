package org.RestAPI.Tests.E2e;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.RestAPI.Base.CommontoAll;
import org.RestAPI.Pojos.Request.PutRequestPojo;
import org.RestAPI.Pojos.Respons.BookingResponse;
import org.RestAPI.Pojos.Respons.GetbookingResponse;
import org.RestAPI.endpoint.APIConstants;
import org.codehaus.groovy.syntax.Token;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


public class IntegrationTestcases extends CommontoAll {



    //  1. Create a Booking -> bookingID


    @Owner("Rajat")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Create a Booking -> bookingID")
    @Test(priority = 0)
    public void Test_Create_Booking(ITestContext iTestContext){
        requestSpecification.basePath(APIConstants.UpdateBooking_URL);

        response = RestAssured.given(requestSpecification).body(payloadManager.Create_Booking_withUserData()).
                when().log().all().post();

        BookingResponse bookingResponse = payloadManager.bookingResponse(response.asString());
        assertsActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
        assertThat(bookingResponse.getBookingid()).isNotNull();
        Assert.assertEquals(response.getStatusCode(),200);

        Integer BookingID = bookingResponse.getBookingid();
        System.out.println(BookingID);
        response.prettyPrint();

        iTestContext.setAttribute("bookingID",BookingID);



    }

    // 2. Verify that the Create Booking is working - GET Request to booking

    @Owner("Rajat")
    @Description("// 2. Verify that the Create Booking is working - GET Request to bookingID")
    @Test(priority = 1)
    public void Test_verify_BookingId(ITestContext iTestContext){

        Integer BookingID = (Integer) iTestContext.getAttribute("bookingID");
        System.out.println(BookingID);

        requestSpecification.basePath(APIConstants.UpdateBooking_URL+"/"+ BookingID);
        response = RestAssured.given(requestSpecification).when().log().all().get();

//        assertsActions.verifyStringKeyNotNull(response);

        validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);

        GetbookingResponse getbookingResponse =payloadManager.getbookingResponse(response.asString());
        assertsActions.verifyStringKeyNotNull(getbookingResponse.getFirstname());
    }


    // 3. Update the booking ( bookingID, Token) - Need to get the token, bookingID from above request

    @Owner("Rajat")
    @Description("Update Booking ID")
    @Test(priority = 2)
    public void Test_Update_BookingID(ITestContext iTestContext){
        Integer BookingID = (Integer) iTestContext.getAttribute("bookingID");
        String Token = CreateaToken();
        requestSpecification.basePath(APIConstants.UpdateBooking_URL + "/"+ 4317);

        response = RestAssured.given(requestSpecification).cookie("token", Token).body(payloadManager.UpdatePut()).
                that().patch();

        validatableResponse = response.then().log().all();
        GetbookingResponse getbookingResponse =payloadManager.getbookingResponse(response.asString());

            Assert.assertEquals(response.getStatusCode(),200);
            assertsActions.verifyStringKeyNotNull(getbookingResponse.getFirstname());

            iTestContext.setAttribute("token",Token);

    }


    // 4. Delete the Booking - Need to get the token, bookingID from above request

    @Owner("Rajat")
    @Description("Delete BookingID")
    @Test(priority =  3)
    public void Test_DeleteID(ITestContext iTestContext){
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingID");
        String Token = (String) iTestContext.getAttribute("token");
        requestSpecification.basePath(APIConstants.UpdateBooking_URL+ "/"+ bookingid);
        response =RestAssured.given(requestSpecification).cookie("token", Token).when().delete();

        validatableResponse =response.then().log().all();

        assertThat(response.asString())
                .contains("Created");
        Assert.assertEquals(response.getStatusCode(),201);


    }

    // 5. Create Token -> token
    @Owner("Rajat")
    @Description("Create Token -> token")
    @Test(priority = 4)
    public void Test_Create_Token(ITestContext iTestContext){

        String Token = CreateaToken();
        System.out.println(Token);
        iTestContext.setAttribute("token",Token);
        assertThat(Token).isNotEmpty().isNotBlank();
    }






}
