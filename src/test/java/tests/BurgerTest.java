package tests;


import clients.BurgerClient;
import models.BurgerRequest;
import models.BurgerResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Тесты для API бургеров
 */
public class BurgerTest {

    private final BurgerClient burgerApi = new BurgerClient();

    @Test
    public void testCreateBurger() {
        // Подготовка данных для создания бургера
        String[] ingredients = {"lettuce", "cheese", "tomato"};
        BurgerRequest burgerRequest = new BurgerRequest("Stellar Burger", ingredients);

        // Вызов метода API
        BurgerResponse response = burgerApi.createBurger(burgerRequest);

        // Проверка ответа
        assertNotNull(response.getId(), "ID бургера не должен быть пустым");
        assertEquals("Stellar Burger", response.getName(), "Имя бургера не соответствует");
        assertEquals(3, response.getIngredients().length, "Количество ингредиентов не совпадает");
    }

}

