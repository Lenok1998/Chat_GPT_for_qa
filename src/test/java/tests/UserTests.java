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

        // Проверяем, что статус ответа 200 и регистрация успешна
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertTrue(response.jsonPath().getBoolean("success"));
    }

    // Тест на авторизацию пользователя
    @Test
    public void testLoginUser() {
        User user = new User("test@example.com", "password123", null);
        Response response = userClient.loginUser(user);

        // Проверяем, что статус ответа 200 и токен доступа не пуст
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertNotNull(response.jsonPath().getString("accessToken"));
    }
}

