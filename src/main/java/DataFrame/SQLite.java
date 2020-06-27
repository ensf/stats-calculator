package DataFrame;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLite {
    /**
     * Initiate an empty SQLite file
     * @param fn database name for the created database
     */
    public static void createNewDB(String fn) {
        String url = "jdbc:sqlite:" + fn;
        try (Connection connection = DriverManager.getConnection(url)) {
            if (connection != null) {
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println("Database: \""+fn+"\" has been Created. \nDB Driver: " + metaData.getDriverName());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}