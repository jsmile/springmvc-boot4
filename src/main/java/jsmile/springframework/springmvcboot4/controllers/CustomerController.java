package jsmile.springframework.springmvcboot4.controllers;

import jsmile.springframework.springmvcboot4.domains.Customer;
import jsmile.springframework.springmvcboot4.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *  Class Anotation 적용 시
 * */
@RequestMapping( "/customer" )
@Controller
public class CustomerController
{
   private ICustomerService customerService;

   @Autowired
   public void setCustomerService( ICustomerService customerService )
   {
      this.customerService = customerService;
   }

   @RequestMapping( {"/", "/list"} )
   public String listAll( Model _model )
   {
      _model.addAttribute( "customers", customerService.listAll() );

      return "customer/list";
   }

   @RequestMapping( "/show/{_id}" )
   public String show( @PathVariable Integer _id, Model _model )
   {
      _model.addAttribute( "customer", customerService.getById( _id ) );

      return "customer/show";
   }

   @RequestMapping( "/new" )
   public String newCustomer( Model _model )
   {
      _model.addAttribute( "customer", new Customer() );

      return "customer/customerform";
   }

   /**
    *  class annotation 으로 인해 '/customer' 이고 RequestMethod.POST 인 경우
    * */
   @RequestMapping( method = RequestMethod.POST )
   public String saveOrUpdate( Customer _customer )
   {
      Customer customer = customerService.saveOrUpdate( _customer );

      return "redirect:customer/show/" + customer.getId();
   }

   @RequestMapping( "/edit/{_id}")
   public String edit( @PathVariable Integer _id, Model _model )
   {
      _model.addAttribute( "customer", customerService.getById( _id ) );

      return "customer/customerform";
   }

   @RequestMapping( "/delete/{_id}" )
   public String delete( @PathVariable Integer _id )
   {
      customerService.delete( _id );

      return "redirect:/customer/list";
   }






}
