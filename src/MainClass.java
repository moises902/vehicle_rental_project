import AccountPackage.Account;
import AccountPackage.Accounts;
import RatesPackage.*;
import TransactionPackage.Transactions;
import InterfacePackage.EmployeeUI;
import InterfacePackage.ManagerUI;
import InterfacePackage.SystemInterface;
import VehiclesPackage.*;

import java.util.Scanner;

public class MainClass
{
    public static void main(String [] args)
    {
        int selection;
        Scanner input = new Scanner(System.in);
        boolean exit = false;

        //Agency Vehicles
        Vehicles vehicles = new Vehicles();

        Vehicle camaro = new Chevrolet_Camaro();
        vehicles.add(camaro);

        Vehicle odyssey = new Honda_Odyssey();
        vehicles.add(odyssey);

        Vehicle tenFoot = new Ten_Foot();
        vehicles.add(tenFoot);

        //Rates
        VehicleRates carRates = new CarRates();
        VehicleRates suvRates = new SUVRates();
        VehicleRates truckRates = new TruckRates();

        Rates rates = new Rates(carRates, suvRates, truckRates);

        //Accounts
        Accounts accounts = new Accounts();

        Account construction = new Account("12345",  "Construct", true);
        accounts.add(construction);

        Account sports = new Account("67890", "Sports", true);
        accounts.add(sports);

        Account esyoubee = new Account("25946", "EsYouVee", false);
        accounts.add((esyoubee));

        //Transactions
        Transactions transactions = new Transactions();

        SystemInterface si = new SystemInterface();
        si.initSystem(rates, vehicles, accounts, transactions);

        ManagerUI managerUI = new ManagerUI();
        EmployeeUI employeeUI = new EmployeeUI();

        while (!exit)
        {
            displayMenu();
            selection = input.nextInt();
            System.out.println();

            if (selection == 1)
                employeeUI.start();
            else if (selection == 2)
                managerUI.start();
            else if (selection == 3)
                exit = true;
        }

    }

    public static void displayMenu()
    {
        System.out.println();
        System.out.println("1 - Employee / 2 - Manager / 3 - Exit");
        System.out.print("Enter Selection: ");
    }
}
