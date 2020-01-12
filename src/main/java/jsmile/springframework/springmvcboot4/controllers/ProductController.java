package jsmile.springframework.springmvcboot4.controllers;

import jsmile.springframework.springmvcboot4.domains.Product;
import jsmile.springframework.springmvcboot4.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping( "/product" )
@Controller
public class ProductController
{
   IProductService productService;

   @Autowired
   public void setProductService( IProductService _productService )
   {
      this.productService = _productService;
   }

   @RequestMapping( { "/", "/list" } )
   public String listAll( Model _model )
   {
      _model.addAttribute( "products", productService.listAll() );

      return "product/list";
   }

   @RequestMapping( "/show/{_id}" )
   public String getById( @PathVariable Integer _id, Model _model )
   {
      Product product = productService.getById( _id );
      _model.addAttribute( "product", product );

      return "product/show";
   }

   @RequestMapping( "/new" )
   public String newProduct( Model _model )
   {
      Product newProduct = new Product();
      _model.addAttribute( "product", newProduct );

      return "product/productform";
   }

   @RequestMapping( "/edit/{_id}" )
   public String edit( @PathVariable Integer _id, Model _model )
   {
      _model.addAttribute( "product", productService.getById( _id ) );

      return "product/productform";
   }

   @RequestMapping( method=RequestMethod.POST )
   public String saveOfUpdate( Product _product )
   {
      Product product = productService.saveOrUpdate( _product );

      return "redirect:/product/show/" + product.getId();
   }

   @RequestMapping( "/delete/{_id}" )
   public String delete( @PathVariable Integer _id )
   {
      productService.delete( _id );

      return "redirect:/product/list";
   }

}
