package tests.api;

import adapters.ProjectAdapter;
import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Case;
import models.Cases;
import models.Project;
import models.Section;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class CasesTests extends BaseApiTest {
    static Logger logger = LogManager.getLogger(CasesTests.class);

    @Test
    public void crudCasesTests() {
        Gson gson = new Gson();

        Project expectedProject = Project.builder()
                .projectName("Project_14")
                .announcement("This is a description!!!")
                .projectType(1)
                .flag(true)
                .build();

        Response response1 = new ProjectAdapter().add(expectedProject);

        int projectId = response1.getBody().jsonPath().getInt("id");
        logger.info(projectId);

        Section section = Section.builder()
                .name("Function_1")
                .sectionId(1)
                .build();

        Response response2 = given()
                .pathParam("project_id", projectId)
                .body(section, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.ADD_SECTION)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        int sectionId = response2.getBody().jsonPath().getInt("id");
        logger.info("section_id " + sectionId);

        Case case1 = Case.builder()
                .title("Case_1")
                .build();

        Response response3 = given()
                .pathParam("section_id", sectionId)
                .body(case1, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.ADD_CASE);

        Case actualCase = gson.fromJson(response3.getBody().asString(), Case.class);
        System.out.println(actualCase.toString());
        Assert.assertEquals(case1, actualCase);

        int caseId = response3.getBody().jsonPath().getInt("id");
        logger.info("case_id " + caseId);

        Response response4 = given()
                .pathParam("case_id", caseId)
                .when()
                .get(Endpoints.GET_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        Case actualCase2 = gson.fromJson(response4.getBody().asString(), Case.class);
        System.out.println(actualCase2.toString());
        Assert.assertEquals(case1, actualCase2);

        int suiteId = response4.getBody().jsonPath().getInt("suite_id");
        logger.info("suite_id " + suiteId);

        Case case2 = Case.builder()
                .title("Case_2")
                .build();

        Response response5 = given()
                .pathParam("case_id", caseId)
                .body(case2, ObjectMapperType.GSON)
                .log().all()
                .when()
                .post(Endpoints.UPDATE_CASE);

        Case actualCase3 = gson.fromJson(response5.getBody().asString(), Case.class);
        System.out.println(actualCase3.toString());
        Assert.assertEquals(case2, actualCase3);

        Response response6 = given()
                .pathParam("project_id", projectId)
                .pathParam("suite_id", suiteId)
                .when()
                .get(Endpoints.GET_CASES)
                .then()
                .log().body()
                .extract()
                .response();

        Cases actualCases = gson.fromJson(response6.getBody().asString(), Cases.class);
        System.out.println(actualCases.getCases().length);

        int[] caseIds = new int[actualCases.getCases().length];
        for (int i = 0; i < actualCases.getCases().length; i ++) {
            caseIds[i] = actualCases.getCases()[i].getId();
            System.out.println(Arrays.toString(caseIds));
        }

        Case case3 = Case.builder()
                .suiteId(2)
                .casesIds(caseIds)
                .build();

        Response response7 = given()
                .pathParam("section_id", sectionId)
                .body(case3, ObjectMapperType.GSON)
                .log().all()
                .when()
                .post(Endpoints.MOVE_CASES_TO_SECTION)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        Response response8 = given()
                .pathParam("case_id", caseId)
                .when()
                .post(Endpoints.DELETE_CASE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
    }
}
