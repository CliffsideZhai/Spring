import com.alibaba.druid.pool.DruidDataSource;
import com.cliffside.service.BookService;
import com.cliffside.service.MultService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.sql.SQLException;

public class MyTest {

    @Test
    public void test01() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        System.out.println(dataSource);
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void test02() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bean = context.getBean(BookService.class);
        bean.checkout("lisi",1);
    }
    @Test
    public void test03() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MultService bean = context.getBean(MultService.class);
        bean.mult();
    }
}
