package org.RestAPI.Tests.Crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.RestAPI.Assert.AssertsActions;
import org.RestAPI.Base.CommontoAll;
import org.RestAPI.endpoint.APIConstants;
import org.testng.annotations.Test;

public class TestCheckPing  extends CommontoAll {

    @Owner("Rajat Arora")
    @Description("Check the ping Request")
    @Test
    public void Test_Check_ping()
    {
        requestSpecification.basePath(APIConstants.ping);

        response = RestAssured.given(requestSpecification).when()
                .get();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);

        AssertsActions.verifyTrue(response.asString().contains("Created"));





    }
}
