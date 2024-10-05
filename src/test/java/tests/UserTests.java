package tests;


import clients.UserClient;
import models.User;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTests {

    UserClient userClient = new UserClient();

    // Тест на регистрацию пользователя
    @Test
    public void testRegisterUser() {
        User user = new User("test@example.com", "password123", "Test User");
        Response response = userClient.registerUser(user);

        // Проверяем, что статус ответа 403 и получена ошибка доступа
        Assertions.assertEquals(403, response.statusCode());
        Assertions.assertFalse(response.jsonPath().getBoolean("success"));
    }

    // Тест на авторизацию пользователя
    @Test
    public void testLoginUser() {
        User user = new User("test@example.com", "password123", null);
        Response response = userClient.loginUser(user);

        // Проверяем, что статус ответа 401 и токен доступа пуст
        Assertions.assertEquals(401, response.statusCode());
        Assertions.assertNull(response.jsonPath().getString("accessToken"));
    }
}

