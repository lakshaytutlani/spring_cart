package loki.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import loki.cart.dao.ProductDao;

@Controller
@RequestMapping(value = "product")
public class ProductController {
	@Autowired 
    private ProductDao productDao; //will inject dao from xml file  

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("products", productDao.getProduct());
		return "product/index";
	}
	
	
	
}
