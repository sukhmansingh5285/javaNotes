package mypack;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.*;
@Entity
@Table(name="Student2")
public class Student implements Serializable{

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE )
 //@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@Column(name = "firstname")
	private String firstname;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "email")
	private String email;
public  Student(long  id,String firstname,String lastname,String  email)
{
this.id=id;
this.firstname=firstname;
this.lastname=lastname;
this.email=email;

}
public   Student()
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
public String getFirstname() 
{
return this.firstname;
}

public void setFirstname(String firstname) 
{
this.firstname = firstname;
}   
public String getLastname() 
{
return this.lastname;
}

public void setLastname(String lastname) 
{
this.lastname = lastname;
}   
public String getEmail()
 {
return this.email;
}

public void setEmail(String email) 
{
this.email = email;
}
}
