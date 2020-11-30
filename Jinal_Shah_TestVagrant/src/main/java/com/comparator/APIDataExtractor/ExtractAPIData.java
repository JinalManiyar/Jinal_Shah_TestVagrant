package com.comparator.APIDataExtractor;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ExtractAPIData {


    private final String cityName;

    public ExtractAPIData(String cityName) {
        this.cityName = cityName;
    }

    public Response queryParameter() {

        RestAssured.baseURI = "http://api.openweathermap.org/data/2.5";
        RequestSpecification request = given();

        return request.queryParam("q", cityName)
                .queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea").get("/weather");
    }

    public Float getHumidityValue(Response response) {
        return extractValue(response, "main.humidity");
    }

    public Float getTempValue(Response response) {

        //extract temperature value from response by giving path
        Float tempKValue = extractValue(response, "main.temp");

        //Convert temperature from kelvin to celsius
        float KELVIN_TO_CELSIUS = 273.15F;
        float tempValue = tempKValue - KELVIN_TO_CELSIUS;
        return Math.round(tempValue*100.0)/100.0F;
    }

    private Float extractValue(Response response, String path) {
        return response.jsonPath().getFloat(path);
    }
}
