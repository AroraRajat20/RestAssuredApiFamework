package org.RestAPI.Tests.E2e;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IntegrationTestcases {


    //  Test E2E Scenario 1

    //  1. Create a Booking -> bookingID


    @Owner("Rajat")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Create a Booking -> bookingID")
    @Test
    public void Test_Create_Booking(){
        System.out.println("Booking Created");
        Assert.assertTrue(true);
    }

    // 2. Create Token -> token
    @Owner("Rajat")
    @Description("Create Token -> token")
    @Test(priority = 1, groups = "Qa")
    public void Test_Create_Token(){
        System.out.println("Token Created");
        Assert.assertTrue(true);
    }

    // 3. Verify that the Create Booking is working - GET Request to bookingID


    @Owner("Rajat")
    @Description("// 3. Verify that the Create Booking is working - GET Request to bookingID")
    @Test(priority = 0, groups = "reg")
    public void Test_verify_BookingId(){

        System.out.println("Verify BookingID");
        Assert.assertTrue(true);
    }

    // 4. Update the booking ( bookingID, Token) - Need to get the token, bookingID from above request

    @Owner("Rajat")
    @Description("Update Booking ID")
    @Test(priority = 2, groups = "QA")
    public void Test_Update_BookingID(){
        System.out.println("Booking updated");
        Assert.assertTrue(true);
    }


    // 5. Delete the Booking - Need to get the token, bookingID from above request

    @Owner("Rajat")
    @Description("Delete BookingID")
    @Test(priority =  3)
    public void Test_DeletID(){
        System.out.println("ID Deleted");
        Assert.assertTrue(true);


    }






}
