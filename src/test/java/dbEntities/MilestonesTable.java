package dbEntities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;

import java.sql.ResultSet;

public class MilestonesTable {
    static Logger logger = LogManager.getLogger(MilestonesTable.class);

    DataBaseService dataBaseService;

    public MilestonesTable(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    public void dropTable() {
        logger.info("Delete milestones table.");
        String dropTableMilestonesSQL = "DROP TABLE milestones;";

        dataBaseService.executeSQL(dropTableMilestonesSQL);
    }
    public void createTable() {
        logger.info("Create milestones table");

        String createTableSQL = "CREATE TABLE milestones (" +
                "ID SERIAL PRIMARY KEY, " +
                "name CHARACTER VARYING(30), " +
                "milestone_id INTEGER, " +
                "project_id INTEGER" +
                ");";

        dataBaseService.executeSQL(createTableSQL);
    }

    public void addMilestone(String name, int milestoneId, int projectId) {
        logger.info("Add a row to table");

        String insertTableSQL = "INSERT INTO public.milestones(" +
                "name, milestone_id, project_id)" +
                "VALUES ('" + name + "', " + milestoneId + ", " + projectId + ");";

        dataBaseService.executeSQL(insertTableSQL);
    }

    public ResultSet getAllMilestones() {
        logger.info("Get all milestones.");
        String selectSQL = "SELECT * FROM public.milestones ORDER BY id ASC;";

        return dataBaseService.executeQuery(selectSQL);
    }

    public void updateMilestone() {
        logger.info("Update a row to table.");

        String updateSQL = "UPDATE milestones SET name = 'Release_7.0' WHERE name = 'Release_4.0';";
        dataBaseService.executeSQL(updateSQL);
    }

    public void deleteMilestone() {
        logger.info("Delete a row to table.");

        String deleteSQL = "DELETE FROM milestones WHERE name = 'Release_3.0';";
        dataBaseService.executeSQL(deleteSQL);
    }
}
