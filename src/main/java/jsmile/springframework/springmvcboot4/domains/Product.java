package jsmile.springframework.springmvcboot4.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Product implements IDomainObject
{
   @Id
   @GeneratedValue( strategy = GenerationType.AUTO )
   private Integer id;
   private String description;
   private BigDecimal price;
   private String imageUrl;

   @Override
   public Integer getId()
   {
      return this.id;
   }

   @Override
   public void setId( Integer _id )
   {
      this.id = _id;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription( String description )
   {
      this.description = description;
   }

   public BigDecimal getPrice()
   {
      return price;
   }

   public void setPrice( BigDecimal price )
   {
      this.price = price;
   }

   public String getImageUrl()
   {
      return imageUrl;
   }

   public void setImageUrl( String imageUrl )
   {
      this.imageUrl = imageUrl;
   }

   @Override
   public String toString()
   {
      return "Product{" + "id=" + id + ", description='" + description + '\'' + ", price=" + price + ", imageUrl='" + imageUrl + '\'' + '}';
   }
}
