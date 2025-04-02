package springboot.project2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;

@RestController
@SpringBootApplication
public class Project2Application {
	private final Environment environment;
	public Project2Application(Environment environment) {
		this.environment = environment;
	}
	public static void main(String[] args) {
		SpringApplication.run(Project2Application.class, args);
	}
	@GetMapping("/db")
	public String database(){
		String activeProfile = environment.getActiveProfiles().length > 0 ? environment.getActiveProfiles()[0] : "default";
		return "Active Profile: " + activeProfile;
	}
}
