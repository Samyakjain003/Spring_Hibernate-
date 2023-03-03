package samyak.jain.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		
		if(theCode==null) {
			return true;
		}
		
		boolean result=theCode.startsWith(coursePrefix);
		
		return result;
	}

	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix=theCourseCode.value();
	}

}
