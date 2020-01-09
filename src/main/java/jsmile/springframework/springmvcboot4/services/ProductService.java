package jsmile.springframework.springmvcboot4.services;

import jsmile.springframework.springmvcboot4.models.Product;

import java.util.List;

public interface ProductService
{
   public List<Product> listAllProducts();

   public Product getProductById( Integer _id );

   public Product saveOrUpdateProduct( Product _product );

   public void deleteProduct( Integer _id );
}
