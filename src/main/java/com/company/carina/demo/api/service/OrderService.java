package com.company.carina.demo.api.service;

import com.company.carina.demo.api.PostOrderMethod;
import io.restassured.response.Response;

public class OrderService {

    public static String getOrderByOrderNo() {
        PostOrderMethod api = new PostOrderMethod();
        api.setProperties("api/order/order.properties");
        //call to endpoints
        Response response = api.callAPIExpectSuccess();
        return response.jsonPath().getString("id");

    }
}
