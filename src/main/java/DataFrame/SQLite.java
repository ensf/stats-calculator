package DataFrame;
import java.sql.*;

public class SQLite {
    /**
     * Note: can work with any schema
     * Set up a new connection based on incoming parameter fn
     * @param db DB name to connect
     * @return a Connection to specified db
     */
    public static Connection connDB(String db) {
        String url = "jdbc:sqlite:" + db;
        Connection dbConnection = null;
        try {
            dbConnection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    /**
     * Note: can work with any schema
     * Initiate an empty SQLite file
     * @param db database name for the created database
     */
    public static void createNewDB(String db) {
        try (Connection connection = connDB(db))
        {
            if (connection != null) {
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println("Database: \""+db+"\" has been Created. \nDB Driver: " + metaData.getDriverName());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Note: can work with any schema
     * @param db
     * @param sql
     */
    public static void queryDB(String db, String sql) {
        try (Connection conn = connDB(db);
             Statement statement = conn.createStatement()) {
            statement.execute(sql);
            System.out.println("The following query was executed:\n---\n"+sql+"\n---");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Note: currently schema specific, need to make it universal
     * @param db
     * @param tb
     * @param colNames
     * @param values
     */
    public static void insert(String db,String tb,String colNames, String values) {
        String sql="INSERT INTO "+tb+"("+colNames+") VALUES ("+values+");";
        try (Connection conn = connDB(db);
             Statement statement = conn.createStatement()) {
            statement.execute(sql);
            System.out.println("The following query was executed:\n"+sql+"\n---");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Wrapper for SQL select from
     * @param db database name
     * @param tb table name
     * @param colNames columns to select from
     */
    public static void selectFrom(String db, String tb, String colNames){
        String sql = "SELECT "+colNames+" FROM "+tb;

        try (Connection conn = connDB(db);
             Statement statement  = conn.createStatement();
             ResultSet resultSet    = statement.executeQuery(sql)){
            // loop through the result set
            while (resultSet.next()) {
                System.out.println(//resultSet.getInt("id") +  "\t" +
                        resultSet.getString("name") + "\t" +
                        resultSet.getDouble("capacity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}