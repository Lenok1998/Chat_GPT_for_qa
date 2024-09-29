package models;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    // Модель заказа, содержит массив ингредиентов
    private String[] ingredients;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class ResponseUser {
    // Модель ответа при создании пользователя или авторизации
    private boolean success;    // Статус успешности
    private User user;          // Данные пользователя
    private String accessToken; // Токен доступа
    private String refreshToken; // Токен для обновления доступа
}