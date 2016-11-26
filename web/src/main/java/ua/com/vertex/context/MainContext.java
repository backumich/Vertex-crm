package ua.com.vertex.context;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("ua.com.vertex")
@PropertySource({"classpath:db.properties", "classpath:dummy.properties"})
public class MainContext {

    @Value("${db.url}")
    private String url;
    @Value("${driver}")
    private String driver;
    @Value("${user}")
    private String user;
    @Value("${password}")
    private String password;



//    @Bean
//    @Scope(value = "prototype")
//    public UserDaoInf userDao() {
//        return new UserDao(dataSource());
//    }
//
@Bean
    public DataSource dataSource() {
        return null;
    }


}
