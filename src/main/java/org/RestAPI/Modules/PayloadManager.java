package org.RestAPI.Modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.RestAPI.Pojos.Request.Booking;
import org.RestAPI.Pojos.Request.Bookingdates;
import org.RestAPI.Pojos.Request.PutRequestPojo;
import org.RestAPI.Pojos.Request.authrequestPojo;
import org.RestAPI.Pojos.Respons.BookingResponse;
import org.RestAPI.Pojos.Respons.GetbookingResponse;
import org.RestAPI.Pojos.Respons.authResponsePojo;

public class PayloadManager {

    Gson gson;
    Faker faker;


    public String Create_Booking_withUserData() {

        Booking booking = new Booking();
        booking.setFirstname("Rajat");
        booking.setLastname("Arora");
        booking.setTotalprice(1000);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2026-08-20");
        bookingdates.setCheckout("2026-08-20");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Dinner");

        gson = new Gson();
        String JsonBookingData = gson.toJson(booking);
        return JsonBookingData;


    }

    public String CreteBookingWithwrongBody() {
        Booking booking = new Booking();
        booking.setFirstname("会意; 會意");
        booking.setLastname("会意; 會意");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2026-08-20");
        bookingdates.setCheckout("2026-08-20");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Lunch");

        gson = new Gson();
        String JsonBookingData = gson.toJson(booking);
        return JsonBookingData;
    }


    public String CreateUSerFromFaker() {
        faker = new Faker();
        Booking booking = new Booking();
        booking.setFirstname(faker.name().firstName());
        booking.setLastname(faker.name().lastName());
        booking.setTotalprice(faker.random().nextInt(1000));
        booking.setDepositpaid(faker.random().nextBoolean());

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2026-08-20");
        bookingdates.setCheckout("2026-08-20");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds(faker.name().name());

        gson = new Gson();
        String JsonBookingData = gson.toJson(booking);
        return JsonBookingData;


    }


    public String CreatAuth() {

        authrequestPojo authrequestPojo = new authrequestPojo();
        authrequestPojo.setUsername("admin");
        authrequestPojo.setPassword("password123");

        gson = new Gson();
        String JsonAuth = gson.toJson(authrequestPojo);
        return JsonAuth;

    }

    public BookingResponse bookingResponse(String responseString) {
        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;
    }

    public String GetToken(String TokenResponse) {

        gson = new Gson();
        authResponsePojo authResponsePojo = gson.fromJson(TokenResponse, authResponsePojo.class);
        return authResponsePojo.getToken();


    }

    public String UpdatePut() {

        PutRequestPojo putRequestPojo = new PutRequestPojo();
        putRequestPojo.setFirstname("Rajat");
        putRequestPojo.setLastname("Arora");


        gson = new Gson();
        String jsonRespons = gson.toJson(putRequestPojo);
        return jsonRespons;

    }

    public GetbookingResponse getbookingResponse(String UpdateResponse){
        gson = new Gson();
    GetbookingResponse getbookingResponse = gson.fromJson(UpdateResponse,GetbookingResponse.class);
    return getbookingResponse;
}
}
