package clients;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseClient {

    // Базовый метод для выполнения POST-запросов
    protected Response post(RequestSpecification spec, Object body, String endpoint) {
        return given()
                .spec(spec)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    // Базовый метод для выполнения GET-запросов
    protected Response get(RequestSpecification spec, String endpoint) {
        return given()
                .spec(spec)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    // Дополнительные методы для PUT и DELETE могут быть добавлены здесь
}

