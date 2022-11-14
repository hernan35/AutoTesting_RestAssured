import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import model.Post.Request.PostRequest;
import model.Post.Response.PostResponse;
import model.employee.Response.EmployeeResponse;
import model.employee.Resquest.Builder.Build;
import model.employee.Resquest.Builder.BuildNewEmployee;
import model.employee.Resquest.Builder.BuildNewEmployeeFake;
import model.employee.Resquest.Builder.EmployeeRequestBuilder;
import model.employee.Resquest.EmployeeRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static data.reader.managerData.getData;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DummyRest {

    String bearerToken="e99413b1c415ad6d592d5f2bef758493fc68c59188d9274a38219b8fc9cb5c55";
    ObjectMapper objectMapper = new ObjectMapper();

    Build buildUserRequest = new Build();

    EmployeeRequestBuilder employeenewr= new BuildNewEmployee();

    EmployeeRequestBuilder employeeFake= new BuildNewEmployeeFake();

    EmployeeResponse responseBodyEmployee;

    PostResponse responseBodyPostEmployee;

    @BeforeEach
    public void setup(){

        RestAssured.baseURI= getData("base.url");
        RestAssured.basePath=getData("base.path");
        RestAssured.filters(new RequestLoggingFilter(),new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON).build();

    }

    @Test

    public void createEmployeeNew() throws JsonProcessingException {

        buildUserRequest.setEmployeeRequestBuilder(employeenewr);
        buildUserRequest.buildEmployeeRequest();
        EmployeeRequest employeeRequest = buildUserRequest.getEmployeeRequest();
        String response=
                given()
                        .body(employeeRequest)
                        .header("Authorization",
                                "Bearer " + bearerToken)
                        .when()
                        .post("create")
                        .then()
                        .statusCode(200)
                        .extract().asString();

        responseBodyEmployee = objectMapper.readValue(response, EmployeeResponse.class);
        assertThat(responseBodyEmployee.getData().getName(),equalTo(responseBodyEmployee.getData().getName()));

    }

    @Test
    public void createPostEmployee() throws JsonProcessingException {
        PostRequest postRequest = new PostRequest.Builder().postEmployee().build();
        buildUserRequest.setEmployeeRequestBuilder(employeenewr);
        buildUserRequest.buildEmployeeRequest();
        EmployeeRequest employeeRequest = buildUserRequest.getEmployeeRequest();
        //Integer idUser=5943;
        String response=
                given()
                        .body(postRequest)
                        .header("Authorization",
                                "Bearer " + bearerToken)
                        .when()
                        .post("create")
                        .then()
                        .statusCode(200)
                        .extract().asString();

        responseBodyPostEmployee = objectMapper.readValue(response, PostResponse.class);
        assertThat(responseBodyPostEmployee.getData().getName(),equalTo(employeeRequest.getName()));

    }
}
