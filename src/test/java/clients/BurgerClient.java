package clients;

import models.BurgerRequest;
import models.BurgerResponse;
import spec.RequestSpec;
import spec.ResponseSpec;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * Страница для взаимодействия с API создания бургеров
 */
public class BurgerClient {

    public BurgerResponse createBurger(BurgerRequest burgerRequest) {
        // Выполнение запроса на создание нового бургера
        Response response = given()
                .spec(RequestSpec.getRequestSpecification())
                .body(burgerRequest)
                .when()
                .post("/burgers")
                .then()
                .spec(ResponseSpec.getResponseSpecification())
                .extract()
                .response();

        // Возвращаем результат десериализованным в модель BurgerResponse
        return response.as(BurgerResponse.class);
    }
}

