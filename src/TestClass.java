import VehiclesPackage.*;
import VehiclesPackage.VehicleExceptions.ReservedVehicleException;
import VehiclesPackage.VehicleExceptions.UnreservedVehicleException;
import VehiclesPackage.VehicleExceptions.VINNotFoundException;

public class TestClass
{
    public static void main(String [] args) throws UnreservedVehicleException, ReservedVehicleException, NullPointerException, VINNotFoundException
    {
        //Testing VehiclesPackage.Vehicle Classes and abstract VehiclesPackage.Vehicle class
        Vehicle dreamCar = new Chevrolet_Camaro();
        Vehicle soccerMom = new Honda_Odyssey();
        Vehicle constructionWorker = new Ten_Foot();

        System.out.println(dreamCar.toString());
        System.out.println(soccerMom.toString());
        System.out.println(constructionWorker.toString());

        System.out.println();

        //Testing VehiclesPackage.Reservation class
        Reservation forSoccerMom = new Reservation("452356456", 2,soccerMom.getDescription(), "D2", true, true);

        System.out.println(forSoccerMom.toString());

        //Testing VehiclesPackage.Reservation class and abstract class
        soccerMom.setResv(forSoccerMom);
        System.out.println(soccerMom.isReserved());

        System.out.println();

        //Testing VehiclesPackage.Vehicles aggregation class
        Vehicles cars = new Vehicles();

        cars.add(dreamCar);
        cars.add(soccerMom);
        cars.add(constructionWorker);

        System.out.println(cars.next());
        System.out.println(cars.hasNext());
        System.out.println(cars.next());
        System.out.println(cars.hasNext());
        System.out.println(cars.next());
        System.out.println(cars.hasNext());

        System.out.println();

        cars.reset();

        cars.next();
        cars.next();
        System.out.println(cars.next());

        System.out.println();

        System.out.println(cars.getVehicle(soccerMom.getVin()));

        System.out.println();
        System.out.println();

    }
}
