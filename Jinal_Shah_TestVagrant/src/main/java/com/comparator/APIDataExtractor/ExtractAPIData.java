package com.comparator.APIDataExtractor;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ExtractAPIData {

    private static float KELVIN_TO_CELSIUS = 273.15F;
    public Response queryParameter(String cityName) {

        RestAssured.baseURI = "http://api.openweathermap.org/data/2.5";
        RequestSpecification request = given();

        Response response = request.queryParam("q", cityName)
                .queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea").get("/weather");

        return response;
    }

    public Float getHumidityValue(Response response) {
        return extractValue(response, "main.humidity");
    }

    public Float getTempValue(Response response) {
        //extract temperature value from response by giving path
        Float tempKValue = extractValue(response, "main.temp");
        //Convert temperature from kelvin to celsius
        Float tempValue = tempKValue - KELVIN_TO_CELSIUS;
        Float tempCValue = Math.round(tempValue*100.0)/100.0F;
        return tempCValue;
    }

    private Float extractValue(Response response, String path) {
        return response.jsonPath().getFloat(path);
    }
}
