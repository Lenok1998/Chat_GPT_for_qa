package clients;


import models.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static spec.BaseSpec.getBaseSpec;

public class UserClient extends BaseClient {

    private final String USER_ENDPOINT = "auth/register";

    // Метод для регистрации нового пользователя
    public Response registerUser(User user) {
        return post(getBaseSpec(), user, USER_ENDPOINT);
    }

    // Метод для авторизации пользователя
    public Response loginUser(User user) {
        return post(getBaseSpec(), user, "auth/login");
    }

    // Метод для удаления пользователя по токену
    public Response deleteUser(String token) {
        return given()
                .spec(getBaseSpec())
                .header("Authorization", token)
                .when()
                .delete("auth/user")
                .then()
                .extract()
                .response();
    }
}



