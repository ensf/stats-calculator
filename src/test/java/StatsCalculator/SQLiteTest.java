package StatsCalculator;
import static DataFrame.SQLite.*;

public class SQLiteTest {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewDB("test.db");
        String sql = "CREATE TABLE IF NOT EXISTS DataFrame (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	capacity real\n"
                + ");";
        queryDB("test.db",sql);
        insert("test.db","DataFrame","name, capacity","\'jack hammer\', 50.00");
        insert("test.db","DataFrame","name, capacity","\'drill bit\', 15.00");
        insert("test.db","DataFrame","name, capacity","\'2x4 block\', 5.00");
        insert("test.db","DataFrame","name, capacity","\'power washer\', 120.00");
        selectFrom("test.db","DataFrame","name, capacity");
    }

}
