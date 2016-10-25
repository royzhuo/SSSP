import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author roy.zhuo
 */
public class TestSSSP {

    private ApplicationContext context = null;
    private DataSource dataSource = null;

    {
        context = new ClassPathXmlApplicationContext("spring.xml");
        dataSource = context.getBean(DataSource.class);
    }

    @Test
    public void testConnect() {
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
