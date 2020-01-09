package jsmile.springframework.springmvcboot4.services;

import jsmile.springframework.springmvcboot4.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService
{
   private Map<Integer, Product> products;

   public ProductServiceImpl() { loadProducts(); }

   @Override
   public List<Product> listAllProducts()
   {
      return new ArrayList<>( products.values() );
   }

   @Override
   public Product getProductById( Integer _id )
   {
      return products.get( _id );
   }

   @Override
   public Product saveOrUpdateProduct( Product _product )
   {
      if( _product != null )
      {
         if( _product.getId() == null ) { _product.setId( getNextKey() );}
         products.put( _product.getId(), _product );
      }
      else { new RuntimeException( "상품 정보가 필요합니다." ); }

      return _product;
   }

   @Override
   public void deleteProduct( Integer _id )
   {
      products.remove( _id );
   }

   private Integer getNextKey()
   {
      return Collections.max( products.keySet() ) + 1;
   }

   private void loadProducts()
   {
      products = new HashMap<>();

      Product product1 = new Product();
      product1.setId( 1 );
      product1.setDescription( "상품 1" );
      product1.setPrice( new BigDecimal( "12.99" ) );
      product1.setImageUrl( "http://example.com/product1" );

      products.put( 1, product1 );

      Product product2 = new Product();
      product2.setId( 2 );
      product2.setDescription( "상품 2" );
      product2.setPrice( new BigDecimal( "14.99" ) );
      product2.setImageUrl( "http://example.com/product2" );

      products.put( 2, product2 );

      Product product3 = new Product();
      product3.setId( 3 );
      product3.setDescription( "상품 3" );
      product3.setPrice( new BigDecimal( "34.99" ) );
      product3.setImageUrl( "http://example.com/product3" );

      products.put( 3, product3 );

      Product product4 = new Product();
      product4.setId( 4 );
      product4.setDescription( "상품 4" );
      product4.setPrice( new BigDecimal( "44.99" ) );
      product4.setImageUrl( "http://example.com/product4" );

      products.put( 4, product4 );

      Product product5 = new Product();
      product5.setId( 5 );
      product5.setDescription( "상품 5" );
      product5.setPrice( new BigDecimal( "55.99" ) );
      product5.setImageUrl( "http://example.com/product5" );

      products.put( 5, product5 );

   }
}
