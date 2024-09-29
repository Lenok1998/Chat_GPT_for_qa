package models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    // Модель пользователя, содержит основные поля
    private String email;    // Электронная почта пользователя
    private String password; // Пароль пользователя
    private String name;     // Имя пользователя
}


