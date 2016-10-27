import com.dao.DepartmentDao;
import com.entity.Department;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author roy.zhuo
 */
public class TestSSSP {

    private ApplicationContext context = null;
    private DataSource dataSource = null;
    private DepartmentDao departmentDao;

    {
        context = new ClassPathXmlApplicationContext("spring.xml");
        dataSource = context.getBean(DataSource.class);
        departmentDao = (DepartmentDao) context.getBean(DepartmentDao.class);
    }

    @Test
    public void testConnect() {
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //测试获取部门信息的二级缓存
    @Test
    public void testDeptSecondLevolCache() {
        List<Department> departments = null;
        departments = departmentDao.findAllDepartments();
        System.out.println("------------");
        departments = departmentDao.findAllDepartments();
    }
}
