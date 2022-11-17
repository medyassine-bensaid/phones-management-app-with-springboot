package com.fsb.tp4.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fsb.tp4.web.models.Product;
import com.fsb.tp4.web.models.request.ProductForm;

@Controller
public class ProductController {
	private static List<Product> products = new ArrayList<Product>();
	private static Long idCount =0L;
	 
    static {
    	products.add(new Product(++idCount, "SS-S9", "Samsung Galaxy S9",1000D, "samsung-s9.png"));
    	products.add(new Product(++idCount, "NK-5P", "Nokia 5.1 Plus", 600D, null));
    	products.add(new Product(++idCount, "IP-7", "iPhone 7",1500D, "iphone-7.jpg"));
    }
	@RequestMapping("/productList")
	public String productList(Model model) {
	 
	    model.addAttribute("products", products);
	    return "productList";
	}
	
	
	 @RequestMapping(value = { "/addProduct" }, method = RequestMethod.GET)
	 public String showAddProductPage(Model model) {
	 ProductForm productForm = new ProductForm();
	 model.addAttribute("productForm", productForm);
	 return "addProduct";
	 }
	 //hethi tzid product
	 @RequestMapping(value = { "/addProduct" }, method = RequestMethod.POST)
	 public String saveProduct(Model model,@Valid @ModelAttribute("productForm") ProductForm productForm, BindingResult bindingResult) 
	 {
	 if(bindingResult.hasErrors())
	 {
		 return "addProduct";
	 }
	 String Name = productForm.getName();
	 Double Price = productForm.getPrice();
	 Long Id = productForm.getId();
	 String Image = productForm.getImage();
	 String Code = productForm.getCode();
	 Product newProduct = new Product(Id,Code,Name,Price,Image);
	 products.add(newProduct);
	 return "redirect:/productList";
	 }
	 
	 @RequestMapping(value = { "/removeProduct" }, method = RequestMethod.GET)
	 public String showRemoveProductPage(Model model) {
	 ProductForm productForm = new ProductForm();
	 model.addAttribute("productForm", productForm);
	 return "removeProduct";
	 }
	 
	 @RequestMapping(value = {"/removeProduct"}, method = RequestMethod.POST)
	 public String removeProduct(Model model,@ModelAttribute("productForm") ProductForm productForm)
	 {

		 String name = productForm.getName();
		 for(int i=0; i<products.size(); i++)
		 {
			 if(name.equals(products.get(i).getName()))
				 products.remove(i);
		 }
		 return "redirect:/productList";
	 }
	 
	 @RequestMapping(value = { "/modifyProduct" }, method = RequestMethod.GET)
	 public String showModifyProductPage(Model model) {
	 ProductForm productForm = new ProductForm();
	 model.addAttribute("productForm", productForm);
	 return "modifyProduct";
	 }
	 
	 @RequestMapping(value = {"/modifyProduct"}, method = RequestMethod.POST)
	 public String modifyProduct(Model model,@Valid @ModelAttribute("productForm") ProductForm productForm,BindingResult bindingResult)
	 {
		 if(bindingResult.hasErrors())
		 {
			 return "modifyProduct";
		 }
		 String name = productForm.getName();
		 Double price = productForm.getPrice();
		 long id = productForm.getId();
		 String image = productForm.getImage();
		 String code = productForm.getCode();
		 for(int i=0; i<products.size(); i++)
		 {

			 if(id == products.get(i).getId())
			 {
				 products.get(i).setName(name);
				 products.get(i).setPrice(price);
				 products.get(i).setImage(image);
				 products.get(i).setCode(code);
			 }
		 }
		 return "redirect:/productList";
	 }
	 
	 
	 
	 
}