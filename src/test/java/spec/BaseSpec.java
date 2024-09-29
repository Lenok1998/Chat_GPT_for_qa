package spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseSpec {

    // Метод для получения базовой спецификации запросов
    // Здесь задается базовый URL и заголовки, которые будут использоваться для всех запросов
    public static RequestSpecification getBaseSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("https://stellarburgers.nomoreparties.site/api/")
                .setContentType("application/json")
                .build();
    }
}