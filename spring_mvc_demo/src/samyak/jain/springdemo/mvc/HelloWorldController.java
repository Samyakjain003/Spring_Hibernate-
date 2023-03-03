package samyak.jain.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// need the controller method to show the form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need the controller method to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//new controller method to read form data and 
	// add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		//read the request parameter from the HTML form
		String thename=request.getParameter("StudentName");
		//convert the data to all caps
		thename=thename.toUpperCase();
		//create the message
		String message="Yo! "+thename;
		//add message to the model
		model.addAttribute("message",message);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("StudentName")
		String thename,Model model) {
		
		//convert the data to all caps
		thename=thename.toUpperCase();
		//create the message
		String message="Namaste! "+thename;
		//add message to the model
		model.addAttribute("message",message);
		
		return "helloworld";
	}
	
}
