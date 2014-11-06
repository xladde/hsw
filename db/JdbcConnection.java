import java.sql.*;
import oracle.jdbc.*;

public class JdbcConnection {

    public static void main(String[] args) {
        String connection   = new String("jdbc:oracle:thin:@heron.wi.hs-wismar.de:1521:stud112");
        String username     = new String("scott");
        String password     = new String("tiger");
        String query        = new String("SELECT * FROM emp");

        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connecion conn = DriverManager.getConnection(connection, username, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            int i = 1;
            while(rs.next()) {
                System.out.println(i++ + " " + rs.getString(2) + " " + rs.getString(1));
            }
            rs.close();
            st.close();
            conn.close();
        } catch(SQLException ex) {
            // sth. with error handling
        } catch(Exception ex) {
            // sth. with error handling
        }
    }
}