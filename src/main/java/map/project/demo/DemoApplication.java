package map.project.demo;

import UI.PersistentConsoleUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static Test.TestLibrary.*;

@SpringBootApplication
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