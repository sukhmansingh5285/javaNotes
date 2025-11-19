
public class BankDemo
{
  public static void main(String[] args)
  {
    CheckingAccount c = new CheckingAccount();
    System.out.println("Depositing $500");
    c.deposit(500.00);

    try
    {
      System.out.println("\n Withdrawing $100");
      c.withdraw(100.00);
      System.out.println("\n Withdrawing $500");
      c.withdraw(500.00);
    }catch(InsufficientFundException e)
    {
      System.out.println("Sorry, but you are short of $" + e.getAmount());
      e.printStackTrace();
    }
  }
}

class InsufficientFundException extends Exception
{
  private double amount;

  InsufficientFundException(double amount)
  {
    this.amount = amount;
  }

  public double getAmount()
  {
    return amount;
  }
}

class CheckingAccount
{
  private double amount = 0;
  
  public void deposit(double amount)
  {
    this.amount += amount;
  }

  public void withdraw(double amount) throws InsufficientFundException
  {
    if(this.amount < amount)  throw new InsufficientFundException(amount);  // use new (i didn't do it before)

    this.amount -= amount;
  }
}