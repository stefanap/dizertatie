// tag::sample[]
package mvp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Double bacGrade;

    protected Student() {}

    public Student(String firstName, String lastName, Double bacGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bacGrade=bacGrade;
    }

    @Override
    public String toString() {
        return String.format(
                "Student[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }


	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public Double getBacGrade() {
		return bacGrade;
	}
}

