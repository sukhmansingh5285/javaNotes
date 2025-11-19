public interface ParkingLot{
  void parkCar(); //Decrease empty spot count by 1
  void unparkCar(); //Increase empyt spots by 1
  void getCapacity(); //Returns car capacity
  double calculateFee(Car ca); //Returns the price based on number of hours
  void doPayment(Car car);
}

class Car{

}

// Now consider that we went to implement a parking lot that is free.

public class FreeParking implements ParkingLot{
  public void parkCar(){

  }

  public void unparkCar(){

  }

  public double calculateFee(Car car){
    return 0;
  }

  public void doPayment(Car car){
    throw new Exception("Parking lot is free");
  }
}

/*
Our parking lot interface was composed of 2 things: Parking related logic (park car, unpark car, get capacity) and payment 
related logic.

But it is too specific. Because of that, our FreeParking class was forced to implement payment-related methods that are irrelevant.
*/

public interface ParkingLot{
  void parkCar(); // Decrease empty spot count by 1
  void unparkCar(); // Increase empty spots by 1
  void getCapacity(); // returns car capacity
}

public interface Payment{
  double calculateFee(Car car); // Returns the price based on number of hours
  void doPayment(Car car);
}