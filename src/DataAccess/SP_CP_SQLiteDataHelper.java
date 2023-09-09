package DataAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Framework.AppException;

public abstract class SP_CP_SQLiteDataHelper {

    private static String SP_CP_CONECTION = "jdbc:sqlite:src\\Utilities\\spcpCoordenadas.sql"; //SP_CP_CONECTION
    private static Connection conn = null;
    public SP_CP_SQLiteDataHelper(){}

    public static synchronized Connection openConnection() throws AppException{
        try {
            if(conn == null)
                conn = DriverManager.getConnection(SP_CP_CONECTION);
        } catch (SQLException e) {
            throw new AppException(e,"SPCPSQLiteDataHelper","Fallo la conexion a la base de datos");
        } 
        return conn;
    }
    protected static void closeConnection() throws AppException{
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            throw new AppException(e,"SPCPSQLiteDataHelper", "Fallo la conexión con la base de datos");
        }
    }
}