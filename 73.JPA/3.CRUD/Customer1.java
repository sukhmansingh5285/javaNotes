package mypack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.PreRemove;

@Entity
public class Customer1 implements java.io.Serializable
{
  private int id;
  private String firstName;
  private String lastName;

  Customer1(int id, String firstName, String lastName)
  {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Customer1()
  {
  }

  @Id
  //@GeneratedValue
  public int getId()
  {
    return id;
  }

  public void setId(int pk)
  {
    id = pk;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName (String lastName)
  {
    this.lastName = lastName;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName (String firstName)
  {
    this.firstName = firstName;
  }

  @PrePersist
  public void PrePersist()
  {
    System.out.println("@PrePersist");
  }

  @PostPersist
  public void PostPersist()
  {
    System.out.println("@PostPersist");
  }

  @PostLoad
  public void postLoad()
  {
    System.out.println("@PostLoad");
  }

  @PreUpdate
  public void preUpdate()
  {
    System.out.println("@PreUpdate");
  }

  @PostUpdate
  public void PostUpdate()
  {
    System.out.println("@PostUpdate");
  }

  @PreRemove
  public void preRemove()
  {
    System.out.println("@PreRemove");
  }

  @PostRemove
  public void PostRemove()
  {
    System.out.println("@PostRemove");
  }
}