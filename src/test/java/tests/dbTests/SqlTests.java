package tests.dbTests;

import baseEntities.BaseDBTest;
import dbEntities.CasesTable;
import dbEntities.MilestonesTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlTests extends BaseDBTest {
    static Logger logger = LogManager.getLogger(SqlTests.class);

    @Test
    public void milestonesDbTest() {
        MilestonesTable milestonesTable = new MilestonesTable(dataBaseService);
        milestonesTable.dropTable();
        milestonesTable.createTable();

        milestonesTable.addMilestone("Release_3.0", 24,13);
        milestonesTable.addMilestone("Release_4.0", 25,13);
        milestonesTable.addMilestone("Release_5.0", 26,14);

        milestonesTable.updateMilestone();
        milestonesTable.deleteMilestone();

        ResultSet rs = milestonesTable.getAllMilestones();

        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int milestoneId = rs.getInt("milestone_id");
                int projectId = rs.getInt("project_id");

                logger.info("ID: " + id);
                logger.info("name: " + name);
                logger.info("milestone_id: " + milestoneId);
                logger.info("project_id: " + projectId);
            }
        } catch (SQLException sqlException) {
            logger.error(sqlException.getMessage());
        }
        logger.info("Test is completed...");
    }

    @Test
    public void casesDbTest() {
        CasesTable casesTable = new CasesTable(dataBaseService);
        casesTable.dropTable();
        casesTable.createTable();

        casesTable.addCase("Case_2", 2, 1, 2,14);
        casesTable.addCase("Case_3", 3, 1, 2,14);
        casesTable.addCase("Case_4", 4, 2, 1,14);

        casesTable.getCaseById(3);
        casesTable.updateCases();

        casesTable.deleteCase();

        ResultSet rs = casesTable.getAllCases();

        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("title");
                int caseId = rs.getInt("case_id");
                int suiteId = rs.getInt("suite_id");
                int sectionId = rs.getInt("section_id");
                int projectId = rs.getInt("project_id");

                logger.info("ID: " + id);
                logger.info("title: " + name);
                logger.info("case_id: " + caseId);
                logger.info("suite_id: " + suiteId);
                logger.info("section_id: " + sectionId);
                logger.info("project_id: " + projectId);
            }
        } catch (SQLException sqlException) {
            logger.error(sqlException.getMessage());
        }
        logger.info("Test is completed...");
    }
}
