package jsmile.springframework.springmvcboot4.controllers;

import jsmile.springframework.springmvcboot4.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController
{
   ProductService productService;

   @Autowired
   public void setProductService( ProductService _productService )
   {
      this.productService = _productService;
   }

   @RequestMapping( "/products" )
   public String listAllProducts( Model model )
   {
      model.addAttribute( "products", productService.listAllProducts() );
      System.out.println( "####################################");
      System.out.println( "Products : *" + productService.listAllProducts() );

      return "products";
   }
}
