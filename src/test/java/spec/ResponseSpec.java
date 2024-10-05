package spec;


import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.equalTo;

/**
 * Спецификация для ответов API
 */
public class ResponseSpec {

    public static ResponseSpecification getResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("success", equalTo(true))
                .build();
    }
}

