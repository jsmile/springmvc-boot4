package jsmile.springframework.springmvcboot4.domains;

public class Customer implements IDomainObject
{
   private Integer id;
   private String firstName;
   private String lastName;
   private String email;
   private String phoneNumber;
   private String addressLine1;
   private String addressLine2;
   private String city;
   private String state;
   private String zipCode;

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

   public String getFirstName()
   {
      return firstName;
   }

   public void setFirstName( String _firstName )
   {
      this.firstName = _firstName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public void setLastName( String _lastName )
   {
      this.lastName = _lastName;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail( String _email )
   {
      this.email = _email;
   }

   public String getPhoneNumber()
   {
      return phoneNumber;
   }

   public void setPhoneNumber( String _phoneNumber )
   {
      this.phoneNumber = _phoneNumber;
   }

   public String getAddressLine1()
   {
      return addressLine1;
   }

   public void setAddressLine1( String _addressLine1 )
   {
      this.addressLine1 = _addressLine1;
   }

   public String getAddressLine2()
   {
      return addressLine2;
   }

   public void setAddressLine2( String _addressLine2 ) { this.addressLine2 = _addressLine2; }

   public String getCity()
   {
      return city;
   }

   public void setCity( String _city )
   {
      this.city = _city;
   }

   public String getState()
   {
      return state;
   }

   public void setState( String _state )
   {
      this.state = _state;
   }

   public String getZipCode()
   {
      return zipCode;
   }

   public void setZipCode( String _zipCode )
   {
      this.zipCode = _zipCode;
   }

   @Override
   public String toString()
   {
      return "Customer{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + ", phoneNumber='" + phoneNumber + '\'' + ", addressLine1='" + addressLine1 + '\'' + ", addressLine2='" + addressLine2 + '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + ", zipCode='" + zipCode + '\'' + '}';
   }
}
