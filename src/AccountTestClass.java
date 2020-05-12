import AccountPackage.*;
import AccountPackage.AccountException.AccountNumberNotFoundException;
import AccountPackage.AccountException.InvalidAcctNumException;
import VehiclesPackage.*;

public class AccountTestClass
{
  public static void main(String [] args) throws AccountNumberNotFoundException, InvalidAcctNumException
  {
      Vehicle soccerMom = new Honda_Odyssey();
      Vehicle dreamCar = new Chevrolet_Camaro();
      Vehicle constructionWorker = new Ten_Foot();

      VehicleNode momcar = new VehicleNode(soccerMom);
      VehicleNode dream = new VehicleNode(dreamCar);
      VehicleNode worker = new VehicleNode(constructionWorker);

      Account constructionCompany = new Account("12345", "CC",  true);
      Account sportsCompany = new Account("67890", "SC", true);
      Account momsCompany = new Account("75923", "MC", false);

      Accounts cars = new Accounts();

      cars.add(constructionCompany);
      cars.add(sportsCompany);
      cars.add(momsCompany);

      System.out.println(cars.getAccount("75923").toString());

      System.out.println();

      System.out.println(cars.next());
      System.out.println(cars.hasNext());
      System.out.println(cars.next());
      System.out.println(cars.hasNext());
      System.out.println(cars.next());
      System.out.println(cars.hasNext());

      cars.reset();

      System.out.println(cars.next());
      System.out.println(cars.hasNext());
  }
}
