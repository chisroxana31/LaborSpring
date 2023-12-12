package map.project.demo;

import UI.PersistentConsoleUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static Test.TestLibrary.*;

@SpringBootApplication
@ComponentScan(basePackages = {"map.project.demo", "Domain", "Repo", "Controller"})
@EntityScan("Domain")
@EnableJpaRepositories("Repo")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("connected");
//		PersistentConsoleUI.startConsole();
//		testLibrarian();
//		testLibrary();
//		testFactory();
//		LibraryTest();
	}
}