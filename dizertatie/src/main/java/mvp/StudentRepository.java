package mvp;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findByLastName(String lastName);
    
    List<Student> findByFirstName(String firstName);
    
    List<Student> findByBacGrade(Double bacGrade);
    
    List<Student> findByBacGradeBetween(Double minimumGrade,Double maximumGrade);
    
    List<Student> findByBacGradeGreaterThan(Double minimumGrade);
    
}
