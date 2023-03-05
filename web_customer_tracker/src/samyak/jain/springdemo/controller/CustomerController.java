package samyak.jain.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import samyak.jain.springdemo.entity.Customer;
import samyak.jain.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
		 //get the customer from the dao and add to the model
		List<Customer> customers=customerService.getCustomers();
		
		theModel.addAttribute("customers",customers);
		
		return "list-customers";
	}
}
