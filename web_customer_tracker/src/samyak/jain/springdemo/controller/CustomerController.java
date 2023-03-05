package samyak.jain.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import samyak.jain.springdemo.dao.CustomerDAO;
import samyak.jain.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject the customer Dao
	@Autowired
	private CustomerDAO customerDao;
	
	@RequestMapping("/list")
	public String listCustomer(Model theModel) {
		
		 //get the customer from the dao and add to the model
		List<Customer> customers=customerDao.getCustomers();
		
		theModel.addAttribute("customers",customers);
		
		return "list-customers";
	}
}
