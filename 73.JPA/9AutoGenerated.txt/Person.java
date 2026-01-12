/* in JPA there are 4 strategies to automatically generate value for a primary key cloumn:

1.GenerationType.AUTO->
  The GenerationType.AUTO is the default generation type and lets the persistence provider choose the generation
  strategy.
2.GenerationType.IDENTITY->
  The GenerationType.IDENTITY is the easiest to use but not the best one from a performance point of view. It relies
  on an auto-incremented database column and lets the database generate a new value with each insert operation. From
  a database point of view, this is very efficient because the auto-increment columns are highly optimized, and it
  doesn't require any additional statements.
3. GenerationType.SEQUENCE->
  The GenerationType.SEQUENCE is to generate primary key values and uses a database sequqnce to generate unique values.
4. GenerationType.TABLE->
  The GenerationType.TABLE gets only rarely used nowadays. It simulates a sequence by storing and updating its current
  value in a database table which requires the use of pessimistic locks that put all transactions into sequential order.
  This slows down your application, and you should, therefore, prefer the GenerationType.SEQUENCE, if your database supports
  sequences, which most popular databases do.

To some extent there are only 3 strategies, the last 3 ones. Because the first 'Auto' just let the JPA implementation to
choose which one of the rest 3 strategies it will use. For example working with Oracle + EclipseLink 2.5.0, the "Auto" 
will result in the strategy "Table" being choosen. This behavior depends on the database and the JPA implementation
in your project */

package mypack;

import javax.persistence.Entity;
import java.io.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import javax.performance.Table;

@Entity
@Table(name="Person14")
public class Person implements Serializable
{
  // @Id
  // @GeneratedValue
  // @GeneratedValue(strategy=GenerationType.TABLE)
  // @GeneratedValue(strategy=GenerationType.IDENTITY)
  // @GeneratedValue(strategy=GenerationType.AUTO)
  @Id
  @SequenceGenerator (name="SEQ_GEN", sequenceName="jpaseq70", allocationSize=1)
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")

  private long id;
  private String name;
  private String surname;

  public Person() {}

  public Person(String name, String surname)
  {
    this.name = name;
    this.surname = surname;
  }

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getSurname()
  {
    return surname;
  }

  public void setSurname(String surname)
  {
    this.surname = surname;
  }

  @Override
  public String toString()
  {
    return "Person [id=" +id+", name"+name+ ", surname" + surname + "]";
  }
}