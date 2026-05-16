package org.RestAPI.Assert;

import io.restassured.response.Response;
import org.testng.Assert;
import static org.assertj.core.api.Assertions.*;


import static org.testng.Assert.assertEquals;


public class AssertsActions {

    public void VerifyStatusCode(Response response, Integer expected){

//        assertEquals(response.getStatusCode(),expected);
        Assert.assertEquals(response.getStatusCode(),expected);

    }
    public void verifyResponseBody(String actual, String expected, String description){
        assertEquals(actual,expected,description);
    }
    public void verifyResponseBody(int actual, int expected, String description) {
        assertEquals(actual, expected, description);
    }
    public void verifyStatusCode(Response response, int expected) {
        assertEquals(response.getStatusCode(),expected);
    }
    public void verifyStringKey(String keyExpect,String keyActual){
        // AssertJ
        assertThat(keyExpect).isNotNull();
        assertThat(keyExpect).isNotBlank();
        assertThat(keyExpect).isEqualTo(keyActual);

    }
    public void verifyStringKeyNotNull(Integer keyExpect){
        // AssertJ
        assertThat(keyExpect).isNotNull();
    }
    public void verifyStringKeyNotNull(String keyExpect){
        // AssertJ
        assertThat(keyExpect).isNotNull();
    }
    public void verifyTrue(boolean keyExpect){
        // AssertJ
        Assert.assertTrue(keyExpect);
    }


}
