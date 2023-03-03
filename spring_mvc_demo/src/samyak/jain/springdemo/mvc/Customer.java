package samyak.jain.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import samyak.jain.springdemo.mvc.validation.CourseCode;

public class Customer {
	private String firstName;
	
	@NotNull(message="is Required")
	@Size(min=1,message="is Required")
	private String lastName;
	
	@NotNull(message="is Required")
	@Min(value=0,message="must be greater than equal to 0")
	@Max(value=10,message="must be less than equal to 10")
	private Integer freePasses;
	
	@Pattern(regexp="^[A-Za-z0-9]{6}",message="must be of length 6")
	private String postalCode;
	
	@CourseCode(value="SAM", message="must be start with SAM")
	private String courseCode;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
}
