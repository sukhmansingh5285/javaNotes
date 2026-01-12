package mypack;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Id;
import java.io.*;

@Entity
public class Student101 implements Serializable
{
  @Id
  // @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long id;
  private String name;

  public Student101(long id, String name)
  {
    this.id = id;
    this.name = name;
  }

  public Student101()
  {
  }

  public long getId()
  {
    return this.id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }
}
