package InterfacePackage;

import AccountPackage.AccountException.AccountNumberNotFoundException;
import AccountPackage.AccountException.InvalidAcctNumException;
import DetailsPackage.RentalDetails;
import DetailsPackage.ReservationDetails;
import VehiclesPackage.VehicleExceptions.ReservedVehicleException;
import VehiclesPackage.VehicleExceptions.UnreservedVehicleException;
import VehiclesPackage.VehicleExceptions.VINNotFoundException;

import java.util.Scanner;

public class EmployeeUI implements UserInterface
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

            try
            {
                execute(selectionNum, input);
            }
            catch (VINNotFoundException v)
            {
                System.out.println("VIN not found");
            }
            catch (AccountNumberNotFoundException a)
            {
                System.out.println("Account number not found");
            }
            catch (InvalidAcctNumException i)
            {
                System.out.println("Incorrect account number");
            }
            catch (UnreservedVehicleException u)
            {
                System.out.println("Vehicle is not reserved");
            }
            catch (ReservedVehicleException r)
            {
                System.out.println("Vehicle is already reserved");
            }

            System.out.println();
        }

        quit = false;
    }

    private void execute(int selection, Scanner input) throws VINNotFoundException, AccountNumberNotFoundException,
            InvalidAcctNumException, UnreservedVehicleException, ReservedVehicleException
    {
        int vehicleType, estimatedMiles;
        String vin, acctNum, rentalPeriod;
        boolean dailyInsurance = false, primeCustomer = false;
        RentalDetails rentalDetails;
        ReservationDetails reservationDetails;

        switch (selection)
        {
            case 1:
                System.out.println("Enter vehicle type to see rates: 1 = car / 2 = SUV / 3 = truck");
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
                System.out.println("Enter vehicle type to see availability: 1 = car / 2 = SUV / 3 = truck");
                vehicleType = input.nextInt();

                switch (vehicleType)
                {
                    case 1:
                        displayResults(SystemInterface.getAvailCars());
                        break;
                    case 2:
                        displayResults(SystemInterface.getAvailSUVs());
                        break;
                    case 3:
                        displayResults(SystemInterface.getAvailTrucks());
                        break;
                }

                break;
            case 3:
                System.out.println("Enter vehicle type: 1 = car / 2 = SUV / 3 = truck");
                vehicleType = input.nextInt();

                System.out.println("Enter estimated rental period: (Ex, \"D2\" is 2 days)");
                rentalPeriod = input.next();

                System.out.println("Enter estimated miles: ");
                estimatedMiles = input.nextInt();

                System.out.println("Daily insurance included? 1 - Yes / 2 - No");
                selection = input.nextInt();
                switch (selection)
                {
                    case 1:
                        dailyInsurance = true;
                        break;
                    case 2:
                        dailyInsurance = false;
                        break;
                }

                System.out.println("A prime customer? 1 - Yes / 2 - No");
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

                rentalDetails = new RentalDetails(vehicleType, rentalPeriod, estimatedMiles, dailyInsurance, primeCustomer);

                displayResults(SystemInterface.estimatedRentalCost(rentalDetails));
                break;
            case 4:
                System.out.println("Enter the VIN of desired reservation: ");
                vin = input.next();

                System.out.println("Enter the account number for reservation: ");
                acctNum = input.next();

                System.out.println("Enter rental period: (Ex, \"D2\" is 2 days)");
                rentalPeriod = input.next();

                System.out.println("Daily insurance included? 1 - Yes / 2 - No");
                selection = input.nextInt();
                switch (selection)
                {
                    case 1:
                        dailyInsurance = true;
                        break;
                    case 2:
                        dailyInsurance = false;
                        break;
                }

                reservationDetails = new ReservationDetails(vin, acctNum, rentalPeriod, dailyInsurance);

                displayResults(SystemInterface.makeReservation(reservationDetails));
                break;
            case 5:
                System.out.println("Enter account number: ");
                acctNum = input.next();

                System.out.println("Enter the VIN to cancel reservation: ");
                vin = input.next();

                displayResults(SystemInterface.cancelReservation(vin, acctNum));
                break;
            case 6:
                System.out.println("Enter account nummber to search: ");
                acctNum = input.next();

                displayResults(SystemInterface.getAccount(acctNum));
//                displayResults(InterfacePackage.SystemInterface.getReservation(acctNum));
                break;
            case 7:
                System.out.println("Enter account number that is returning the vehicle: ");
                acctNum = input.next();

                System.out.println("Enter the VIN of the returned vehicle: ");
                vin = input.next();

                System.out.println("Enter number of miles used: ");
                estimatedMiles = input.nextInt();

                System.out.println("Enter number of days used: ");
                selection = input.nextInt();

                displayResults(SystemInterface.processReturnedVehicle(acctNum, vin, estimatedMiles, selection));
                break;
            case 8:
                quit = true;
                break;
        }
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

     private void displayMenu()
    {
        System.out.println();
        System.out.println("MAIN MENU - EMPOYEE");
        System.out.println("1 - View Current rates");
        System.out.println("2 - View Available Vehicles");
        System.out.println("3 - Calc Estimated Rental Cost");
        System.out.println("4 - Make a reservation");
        System.out.println("5 - Cancel Reservation");
        System.out.println("6 - View Corporate Account");
        System.out.println("7 - Process Returned Vehicle");
        System.out.println("8 - Quit");
        System.out.print("Enter choice: ");
    }
}


