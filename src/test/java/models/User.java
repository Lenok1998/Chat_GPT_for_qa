package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    // Модель пользователя, содержит основные поля
    @JsonProperty("email")
    private String email;    // Электронная почта пользователя
    @JsonProperty("password")
    private String password; // Пароль пользователя
    @JsonProperty("name")
    private String name;     // Имя пользователя

    // Конструктор с параметрами
    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}


