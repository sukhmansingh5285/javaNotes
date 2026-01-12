package mypack;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Id;

@Entity
@Table(name = "Employeenative")
public class Employee
{
  @Id
  @GeneratedValue
  @Column(name="id")
  private int id;

  @Column(name="empName")
  private String empName;

  @Column(name="empSalary")
  private int empSalary;

  public int getId(){
    return id;
  }

  public void setId(int id){
    this.id = id;
  }

  public String getEmpName(){
    return empName;
  }

  public void setEmpName(String empName){
    this.empName = empName;
  }

  public int getEmpSalary(){
    return empSalary;
  }

  public void setEmpSalary (int empSalary){
    this.empSalary = empSalary;
  }

  public String toString()
  {
    return id+empName+empSalary;
  }
}