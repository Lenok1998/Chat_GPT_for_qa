package models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Модель ответа API на запрос создания бургера
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BurgerResponse {
    private boolean success;
    private String id;
    private String name;
    private String[] ingredients;
}

