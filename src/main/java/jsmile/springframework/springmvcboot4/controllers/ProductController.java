package jsmile.springframework.springmvcboot4.controllers;

import jsmile.springframework.springmvcboot4.models.Product;
import jsmile.springframework.springmvcboot4.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

   @RequestMapping( "/product/{_id}" )
   public String product( @PathVariable Integer _id, Model _model )
   {
      _model.addAttribute( "product", productService.getProductById( _id ) );

      return "product";
   }

   @RequestMapping( "/product/new" )
   public String newProduct( Model _model )
   {
      _model.addAttribute( "product", new Product() );

      return "productform";
   }

   @RequestMapping( value = "/product", method = RequestMethod.POST)
   public String saveOrUpdateProduct( Product product )
   {
      Product savedProduct = productService.saveOrUpdateProduct( product );

      return "redirect:/product/" + savedProduct.getId();
   }
}
