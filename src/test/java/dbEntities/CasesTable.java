package dbEntities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;

import java.sql.ResultSet;

public class CasesTable {
    static Logger logger = LogManager.getLogger(CasesTable.class);

    DataBaseService dataBaseService;

    public CasesTable(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    public void dropTable() {
        logger.info("Delete cases table.");
        String dropTableMilestonesSQL = "DROP TABLE cases;";

        dataBaseService.executeSQL(dropTableMilestonesSQL);
    }

    public void createTable() {
        logger.info("Create cases table");

        String createTableSQL = "CREATE TABLE cases (" +
                "ID SERIAL PRIMARY KEY, " +
                "title CHARACTER VARYING(30), " +
                "case_id INTEGER, " +
                "suite_id INTEGER, " +
                "section_id INTEGER, " +
                "project_id INTEGER" +
                ");";

        dataBaseService.executeSQL(createTableSQL);
    }

    public void addCase(String title, int caseId, int suiteId, int sectionId, int projectId) {
        logger.info("Add a row to table");

        String insertTableSQL = "INSERT INTO public.cases(" +
                "title, case_id, suite_id, section_id, project_id)" +
                "VALUES ('" + title + "', " + caseId + ", " + suiteId + ", " + sectionId + ", " + projectId + ");";

        dataBaseService.executeSQL(insertTableSQL);
    }

    public ResultSet getCaseById(int id) {
        logger.info("Get case by id.");

        String selectSQL = "SELECT * FROM public.cases WHERE id = " + id + "ORDER BY id ASC;";

        return dataBaseService.executeQuery(selectSQL);
    }

    public void updateCases() {
        logger.info("Update a row to table.");

        String updateSQL = "UPDATE cases SET title = 'Case_5' WHERE title = 'Case_4';";
        dataBaseService.executeSQL(updateSQL);
    }

    public void deleteCase() {
        logger.info("Delete a row to table.");

        String deleteSQL = "DELETE FROM cases WHERE title = 'Case_2';";
        dataBaseService.executeSQL(deleteSQL);
    }

    public ResultSet getAllCases() {
        String selectSQL = "SELECT * FROM public.cases ORDER BY id ASC;";

        return dataBaseService.executeQuery(selectSQL);
    }
}
