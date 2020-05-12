package InterfacePackage;

import RatesPackage.CarRates;
import RatesPackage.SUVRates;
import RatesPackage.TruckRates;
import RatesPackage.VehicleRates;

import java.util.Random;
import java.util.Scanner;

public class ManagerUI implements UserInterface
{
    private boolean quit = false;

    @Override
    public void start()
    {
        int selectionNum;
        Scanner input = new Scanner(System.in);

        while (!quit)
        {
            displayMenu();
            selectionNum = input.nextInt();
            System.out.println();
            execute(selectionNum, input);

            System.out.println();
        }

        quit = false;
    }

    private void execute(int selection, Scanner input)
    {
        int vehicleType;
        String acctNum, companyName;
        boolean primeCustomer = false;

        switch (selection)
        {
            case 1:
                System.out.println("1 - View Rates / 2 - Update Rates");
                selection = input.nextInt();

                switch (selection)
                {
                    case 1:
                        System.out.println("Enter vehicle type to see rates: 1 = car, 2 = SUV, 3 = truck");
                        vehicleType = input.nextInt();

                        switch (vehicleType)
                        {
                            case 1:
                                displayResults(SystemInterface.getCarRates());
                                break;
                            case 2:
                                displayResults(SystemInterface.getSUVRates());
                                break;
                            case 3:
                                displayResults(SystemInterface.getTruckRates());
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("Enter vehicle type to update rates: 1 = car, 2 = SUV, 3 = truck");
                        vehicleType = input.nextInt();
                        double dailyRate, weeklyRate, monthlyRate, milageChrg, dailyInsurRate;
                        VehicleRates r;

                        switch (vehicleType)
                        {
                            case 1:
                                System.out.println("Enter new daily rate: ");
                                dailyRate = input.nextInt();

                                System.out.println("Enter new weekly rate: ");
                                weeklyRate = input.nextInt();

                                System.out.println("Enter new monthly rate: ");
                                monthlyRate = input.nextInt();

                                System.out.println("Enter new mileage charge: ");
                                milageChrg = input.nextInt();

                                System.out.println("Enter new daily insurance rate: ");
                                dailyInsurRate = input.nextInt();

                                r = new CarRates(dailyRate, weeklyRate, monthlyRate, milageChrg, dailyInsurRate);

                                displayResults(SystemInterface.updateCarRates(r));
                                break;
                            case 2:
                                System.out.println("Enter new daily rate: ");
                                dailyRate = input.nextInt();

                                System.out.println("Enter new weekly rate: ");
                                weeklyRate = input.nextInt();

                                System.out.println("Enter new monthly rate: ");
                                monthlyRate = input.nextInt();

                                System.out.println("Enter new mileage charge: ");
                                milageChrg = input.nextInt();

                                System.out.println("Enter new daily insurance rate: ");
                                dailyInsurRate = input.nextInt();

                                r = new SUVRates(dailyRate, weeklyRate, monthlyRate, milageChrg, dailyInsurRate);

                                displayResults(SystemInterface.updateSUVRates(r));
                                break;
                            case 3:
                                System.out.println("Enter new daily rate: ");
                                dailyRate = input.nextInt();

                                System.out.println("Enter new weekly rate: ");
                                weeklyRate = input.nextInt();

                                System.out.println("Enter new monthly rate: ");
                                monthlyRate = input.nextInt();

                                System.out.println("Enter new mileage charge: ");
                                milageChrg = input.nextInt();

                                System.out.println("Enter new daily insurance rate: ");
                                dailyInsurRate = input.nextInt();

                                r = new TruckRates(dailyRate, weeklyRate, monthlyRate, milageChrg, dailyInsurRate);

                                displayResults(SystemInterface.updateTruckRates(r));
                                break;
                        }

                        break;
                }
                break;
            case 2:
                displayResults(SystemInterface.getAllVehicles());
                break;
            case 3:
                System.out.println("1 - Add Account / 2 - Update Account");
                selection = input.nextInt();

                switch (selection)
                {
                    case 1:
                        acctNum = generateAcctNumber();

                        System.out.println("Enter Company Name: ");
                        companyName = input.next();

                        System.out.println("Prime Customer? 1 - Yes / 2 - No");
                        selection = input.nextInt();

                        switch (selection)
                        {
                            case 1:
                                primeCustomer = true;
                                break;
                            case 2:
                                primeCustomer = false;
                                break;
                        }

                        displayResults(SystemInterface.addAccount(acctNum, companyName, primeCustomer));

                        break;
                    case 2:
                        System.out.println("Enter Account Number to Update: ");
                        acctNum = input.next();

                        System.out.println("Enter New Name for Account: ");
                        companyName = input.next();

                        System.out.println("Prime Customer? 1 - Yes / 2 - No");
                        selection = input.nextInt();

                        switch (selection)
                        {
                            case 1:
                                primeCustomer = true;
                                break;
                            case 2:
                                primeCustomer = false;
                                break;
                        }

                        displayResults(SystemInterface.updateAccount(acctNum, companyName, primeCustomer));
                        break;
                }
                break;
            case 4:
                displayResults(SystemInterface.getAllReservations());
                break;
            case 5:
                displayResults(SystemInterface.getAllAccounts());
                break;
            case 6:
                displayResults(SystemInterface.getAllTransactions());
                break;
            case 7:
                quit = true;
                break;
        }
    }

    private void displayMenu()
    {
        System.out.println("MAIN MENU - MANAGER");
        System.out.println("1 - View / Update Vehicle Rates");
        System.out.println("2 - View All Vehicles");
        System.out.println("3 - Add / Update Account");
        System.out.println("4 - View All Reservations");
        System.out.println("5 - View All Accounts");
        System.out.println("6 - View All Transactions");
        System.out.println("7 - Quit");
        System.out.println("Enter Choice: ");
    }

    private void displayResults(String [] displayLines)
    {
        if (displayLines == null)
        {
            System.out.println("empty");
        }
        else {
            for (String element : displayLines) {
                if (element != null)
                    System.out.println(element);
            }
        }

        System.out.println();
    }

    private String generateAcctNumber()
    {
        Random r = new Random();
        int ranNum = r.nextInt(89999) + 10000;

        return Integer.toString(ranNum);
    }
}
