import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiClient {

    @Step("Создаю пользователя")
    public static String createUser(String email, String password, String name) {
        CreateUserRequest createUserRequest = new CreateUserRequest(email, password, name);
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(createUserRequest) // заполни body
                .when()
                .post("/api/auth/register")
                .then().extract().jsonPath().getString("accessToken");
    }

    @Step("Удаление пользователя")
    public static Response deleteUser(String token) {
        return given()
                .header("Authorization", token) // заполни body
                .when()
                .delete("/api/auth/user");
    }

    public static class CreateUserRequest {
        private String email;
        private String password;
        private String name;

        public CreateUserRequest(String email, String password, String name) {
            this.email = email;
            this.password = password;
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
