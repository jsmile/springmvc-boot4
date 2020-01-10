package jsmile.springframework.springmvcboot4.services;

import jsmile.springframework.springmvcboot4.domains.IDomainObject;
import jsmile.springframework.springmvcboot4.domains.Product;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ProductServiceImpl extends AbstractMapService implements IProductService
{
   @Override
   protected void loadDomainObjects()
   {

   }

   @Override
   public List<IDomainObject> listAll() { return super.listAll(); }

   @Override
   public Product getById( Integer _id ) { return (Product)super.getById( _id ); }

   @Override
   public Product saveOrUpdate( Product _product )
   {
      return (Product) super.saveOrUpdate( _product );
   }

   @Override
   public void delete( Integer _id ) { super.delete( _id ); }

}
