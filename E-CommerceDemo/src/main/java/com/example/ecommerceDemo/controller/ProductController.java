package com.example.ecommerceDemo.controller;

import com.example.ecommerceDemo.model.Product;
import com.example.ecommerceDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/product/{id}")
    public String show(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute(product);
        return "product";
    }

    @RequestMapping(value = "/product", method = {RequestMethod.POST, RequestMethod.PUT})
    public String creatOrUpdate(@Valid Product product) {
        productService.save(product);
        return "redirect:/product/" + product.getId();
    }

}
