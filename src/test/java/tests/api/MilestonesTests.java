package tests.api;

import adapters.ProjectAdapter;
import baseEntities.BaseApiTest;
import helpers.GsonHelper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Milestone;
import models.Project;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class MilestonesTests extends BaseApiTest {
    static Logger logger = LogManager.getLogger(MilestonesTests.class);

    @Test
    public void crudMilestoneTests() {
        Project expectedProject = Project.builder()
                .projectName("Project_13")
                .announcement("This is a description!!!")
                .projectType(2)
                .flag(true)
                .build();

        Response response1 = new ProjectAdapter().add(expectedProject);
        Project actualProject = GsonHelper.getProjectFromJson(response1.getBody().asString());
        System.out.println(actualProject.toString());

        int projectId = response1.getBody().jsonPath().getInt("id");
        logger.info(projectId);

        Milestone milestone = new Milestone();
        milestone.setName("Release 3.0");

        Response response2 = given()
            .pathParam("project_id", projectId)
            .body(milestone, ObjectMapperType.GSON)
            .log().all()
            .when()
            .post(Endpoints.ADD_MILESTONE)
            .then()
            .log().body()
            .assertThat()
            .statusCode(HttpStatus.SC_OK)
            .body("name", is(milestone.getName()))
            .extract()
            .response();

        Response response3 = given()
                .pathParam("project_id", projectId)
                .when()
                .get(Endpoints.GET_MILESTONES)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        int milestoneId = response2.getBody().jsonPath().getInt("id");
        logger.info(milestoneId);

        Milestone milestone1 = new Milestone();
        milestone1.setName("Release 4.0");

        Response response4 = given()
                .pathParam("milestone_id", milestoneId)
                .body(milestone1, ObjectMapperType.GSON)
                .log().all()
                .when()
                .post(Endpoints.UPDATE_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        Response response5 = given()
                .pathParam("milestone_id", milestoneId)
                .when()
                .post(Endpoints.DELETE_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
    }
}
