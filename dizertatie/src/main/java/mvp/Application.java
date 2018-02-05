package mvp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
	public CommandLineRunner demo(StudentRepository repository) {
		return (args) -> {
			// save a couple of Students
			repository.save(new Student("Jack", "Bauer", 7.9));
			repository.save(new Student("Chloe", "O'Brian", 10.0));
			repository.save(new Student("Kim", "Bauer", 9.5));
			repository.save(new Student("David", "Palmer", 8.7));
			repository.save(new Student("Michelle", "Dessler", 10.0));

			// fetch all Students
			log.info("Students found with findAll():");
			log.info("-------------------------------");
			for (Student Student : repository.findAll()) {
				log.info(Student.toString());
			}
			log.info("");

			// fetch an individual Student by ID
			Student Student = repository.findOne(1L);
			log.info("Student found with findOne(1L):");
			log.info("--------------------------------");
			log.info(Student.toString());
			log.info("");

			// fetch Students by last name
			log.info("Student found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			for (Student bauer : repository.findByLastName("Bauer")) {
				log.info(bauer.toString());
			}
			log.info("");

			// fetch Students by bac grade
			log.info("Student found with findByBacGrade('10.0'):");
			log.info("--------------------------------------------");
			for (Student bauer : repository.findByBacGrade(10.0)) {
				log.info(bauer.toString());
			}
			log.info("");

			// fetch Students with bac grade between 8 and 10
			log.info("Student found with findByBacGradeBetween(8.0,10.0):");
			log.info("--------------------------------------------");
			for (Student bauer : repository.findByBacGradeBetween(8.0, 10.0)) {
				log.info(bauer.toString());
			}
			log.info("");
			
			// fetch Students with bac grade higher than 9
			log.info("Student found with findByBacGradeGreaterThan(9.0):");
			log.info("--------------------------------------------");
			for (Student bauer : repository.findByBacGradeGreaterThan(9.0)) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}

}
