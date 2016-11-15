package ua.com.vertex.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("ua.com.vertex")
@PropertySource("classpath:db.properties")
public class MainContext {

//    @Bean
//    @Scope(value = "prototype")
//    public UserDaoInf userDao() {
//        return new UserDao(dataSource());
//    }

    public DataSource dataSource() {
        return null;
    }


}
