import AccountPackage.Accounts;
import RatesPackage.*;
import TransactionPackage.Transactions;
import InterfacePackage.SystemInterface;
import VehiclesPackage.*;

import java.util.Arrays;

public class SystemInterfaceTest
{
    public static void main (String [] mains)
    {

        System.out.println();
        Vehicle car = new Chevrolet_Camaro();
        Vehicle suv = new Honda_Odyssey();
        Vehicle truck = new Ten_Foot();

        VehicleRates carrates = new CarRates();
        VehicleRates suvrates = new SUVRates();
        VehicleRates truckrates = new TruckRates();
        Rates rates = new Rates(carrates, suvrates, truckrates);

        Vehicles vehicles = new Vehicles();
        vehicles.add(car);
        vehicles.add(suv);
        vehicles.add(truck);

        Accounts accounts = new Accounts();
        Transactions transactions = new Transactions();

        SystemInterface si = new SystemInterface();

        si.initSystem(rates,vehicles,accounts,transactions);

        System.out.println(Arrays.toString(si.getCarRates()));

        String [] array = si.getAllVehicles();

        for (String element : array)
        {
            System.out.println(element);
        }
    }
}
