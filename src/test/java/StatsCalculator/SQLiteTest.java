package StatsCalculator;
import static DataFrame.SQLite.createNewDB;

public class SQLiteTest {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewDB("newDB.db");
    }
}
