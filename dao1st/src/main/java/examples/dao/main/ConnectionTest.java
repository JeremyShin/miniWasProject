package examples.dao.main;

import examples.dao.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        DataSource ds = ac.getBean(DataSource.class);
        Connection conn = null;

        try{
            conn = ds.getConnection();
            if(conn != null) System.out.println("db Ok!!");
        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            if(conn != null) {
                try{
                    conn.close();
                }catch (SQLException e) {}
            }
        }
    }
}
