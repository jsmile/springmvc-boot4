package jsmile.springframework.springmvcboot4.services;

import java.util.List;

public interface ICRUDService<T>
{
   public List<?> listAll();

   public T getById( Integer _id );

   public T saveOrUpdate( T _domainObject );

   public void delete( Integer _id );

}
