import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shops {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "20000103";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";


    public static List getAllTables() throws SQLException {

        Statement db = connectionToDataBase();

        ArrayList<String> shopNames = new ArrayList<String>();
        String query = "select * from Grossary.Shops";
        ResultSet res = db.executeQuery(query);

        while (res.next()){
            shopNames.add(res.getString("Shop_name"));
        }
        db.close();
        return shopNames;
    }

    public static Statement connectionToDataBase() {
        Connection connection = null;
        Statement statement =null;
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Не удалось соеденить"+e);
        }

        return statement;

    }



}
