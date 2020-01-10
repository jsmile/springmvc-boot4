package jsmile.springframework.springmvcboot4.services;

import jsmile.springframework.springmvcboot4.domains.IDomainObject;

import java.util.*;

public abstract class AbstractMapService
{
   protected Map<Integer, IDomainObject> domainMap;

   public AbstractMapService()
   {
      this.domainMap = new HashMap<>();
      loadDomainObjects();
   }

   public List<IDomainObject> listAll() { return new ArrayList<>( domainMap.values() ); }

   public IDomainObject getById( Integer _id ) { return domainMap.get( _id ); }

   public IDomainObject saveOrUpdate( IDomainObject _domainObject )
   {
      if( _domainObject == null ) { throw new RuntimeException( "도메인 객체가 필요합니다. !!!" ); }
      else
      {
         if( _domainObject.getId() == null ) { _domainObject.setId( getNextKey() );}
         domainMap.put( _domainObject.getId(), _domainObject );
      }

      return _domainObject;
   }

   public void delete( Integer _id ) { this.domainMap.remove( _id ); }

   private Integer getNextKey() { return Collections.max( domainMap.keySet() ) + 1; }

   protected abstract void loadDomainObjects();

}
