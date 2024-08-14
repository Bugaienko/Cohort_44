package app.constants;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Sergey Bugaenko
 * {@code @date} 13.08.2024
 */

public interface Constants {

    // http://localhost:8080/cars?id=5
    // jdbc:postgresql://localhost:5432/g_44_cars?user=postgres&password=pos1234

    String DB_DRIVER_PATH = "org.postgresql.Driver";

    String DB_ADDRESS = "jdbc:postgresql://localhost:5432";

    String DB_NAME = "g_44_cars";
    String DB_USER = "postgres";
    String DB_PASSWORD = "pos1234";

}
