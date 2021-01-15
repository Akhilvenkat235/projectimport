package customerdata;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CustomerController {
	@Autowired
	public Customerservice customerservices;
	   
	@PostMapping("/customerinsert")
	public Map addCustomer(@RequestBody Customer product) {
		Map addproduct = null;
				try {
			addproduct = customerservices.addCustomer(product);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				return addproduct;
	}
	

}


