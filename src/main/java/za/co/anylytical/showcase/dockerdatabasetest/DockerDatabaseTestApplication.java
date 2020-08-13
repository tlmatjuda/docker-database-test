package za.co.anylytical.showcase.dockerdatabasetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, XADataSourceAutoConfiguration.class})
@SpringBootApplication
public class DockerDatabaseTestApplication {

	public static void main(String[] args) {
		SpringApplication.run( DockerDatabaseTestApplication.class, args);
	}

}
