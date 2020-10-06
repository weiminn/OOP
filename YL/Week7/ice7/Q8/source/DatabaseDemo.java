import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.mysql.jdbc.Driver;

public class DatabaseDemo {

    static Scanner sc = new Scanner(System.in);

    static String host = "localhost";
    static int port = 3306;
    static String dbName = "week6";
    static String dbURL = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?useSSL=false";

    static String username = "oop";
    static String password = "asd123";

    static String sql = "select * from member_v where username=?";

    public static void main(String[] args)  {
        prompt();
    }

    static void prompt(){
        System.out.print("\nEnter Username: ");
        String name = sc.nextLine();

        if(!name.equals("quit")){
            try {
                System.out.println("Connecting to Driver Library...");
                // step 1: Loads the JDBC driver
                // ** for some reason the first line doesn't work **
                // ** Can beloved Lifu explain? **
                // Class.forName("com.mysql.jdbc.Driver").getConstructor().newInstance();
                DriverManager.registerDriver(new Driver());

                System.out.println("Creating Connection...");
                // step 2: Gets a connection to the database
                Connection conn = DriverManager.getConnection(dbURL, username, password);

                System.out.println("Preparing Statment...");
                // step 3: Prepare the SQL to be sent to the database
                PreparedStatement stmt = conn.prepareStatement(sql);
                // bind the parameters
                stmt.setString(1, name);
    
                System.out.println("Looking for name...");
                // step 4: executes the query
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    System.out.println("Got result!");
                    String fullName = rs.getString("full_name");
                    System.out.println(fullName);
                } else {
                    prompt();
                }
            } catch (Exception e) {
                //TODO: handle exception
                System.err.println(e.getMessage());
            }
    
        } else {
            System.out.println("bye bye!");
        }
    }

}
