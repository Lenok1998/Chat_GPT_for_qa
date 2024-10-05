package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Модель для создания нового бургера
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BurgerRequest {
    private String name;
    private String[] ingredients;
}