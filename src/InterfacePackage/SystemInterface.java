package InterfacePackage;

import AccountPackage.Account;
import AccountPackage.AccountException.AccountNumberNotFoundException;
import AccountPackage.AccountException.InvalidAcctNumException;
import AccountPackage.Accounts;
import DetailsPackage.RentalDetails;
import DetailsPackage.ReservationDetails;
import RatesPackage.Rates;
import RatesPackage.VehicleRates;
import TransactionPackage.Transaction;
import TransactionPackage.Transactions;
import VehiclesPackage.Reservation;
import VehiclesPackage.Vehicle;
import VehiclesPackage.VehicleExceptions.ReservedVehicleException;
import VehiclesPackage.VehicleExceptions.UnreservedVehicleException;
import VehiclesPackage.VehicleExceptions.VINNotFoundException;
import VehiclesPackage.VehicleNode;
import VehiclesPackage.Vehicles;

public class SystemInterface {
    private static Rates agencyRates;
    private static Vehicles agencyVehicles;
    private static Accounts accounts;
    private static Transactions transactionHistory;

    public void initSystem(Rates r, Vehicles v, Accounts a, Transactions t) {
        agencyRates = r;
        agencyVehicles = v;
        accounts = a;
        transactionHistory = t;
    }

    //Vehicle rates-related methods

    public static String [] getCarRates() {
        VehicleRates rates = agencyRates.getCarRates();

        String[] array = new String[5];

        array[0] = "Daily: $" + rates.getDailyRate();
        array[1] = "Weekly: $" + rates.getWeeklyRate();
        array[2] = "Monthly: $" + rates.getMonthlyRate();
        array[3] = "Per Mile: $" + rates.getMileageChrg();
        array[4] = "Daily Insur: $" + rates.getDailyInsurRate();

        return array;
    }

    public static String [] getSUVRates() {
        VehicleRates rates = agencyRates.getSUVRates();

        String[] array = new String[5];

        array[0] = "Daily: $" + rates.getDailyRate();
        array[1] = "Weekly: $" + rates.getWeeklyRate();
        array[2] = "Monthly: $" + rates.getMonthlyRate();
        array[3] = "Per Mile: $" + rates.getMileageChrg();
        array[4] = "Daily Insur: $" + rates.getDailyInsurRate();

        return array;
    }

    public static String [] getTruckRates() {
        VehicleRates rates = agencyRates.getTruckRates();

        String[] array = new String[5];

        array[0] = "Daily: $" + rates.getDailyRate();
        array[1] = "Weekly: $" + rates.getWeeklyRate();
        array[2] = "Monthly: $" + rates.getMonthlyRate();
        array[3] = "Per Mile: $" + rates.getMileageChrg();
        array[4] = "Daily Insur: $" + rates.getDailyInsurRate();

        return array;
    }

    public static String [] updateCarRates(VehicleRates r)
    {
        agencyRates.updateCarRates(r);
        VehicleRates rates = agencyRates.getCarRates();

        String[] array = new String[5];

        array[0] = "Daily: $" + rates.getDailyRate();
        array[1] = "Weekly: $" + rates.getWeeklyRate();
        array[2] = "Monthly: $" + rates.getMonthlyRate();
        array[3] = "Per Mile: $" + rates.getMileageChrg();
        array[4] = "Daily Insur: $" + rates.getDailyInsurRate();

        return array;
    }

    public static String [] updateSUVRates(VehicleRates r) {
        agencyRates.updateSUVRates(r);
        VehicleRates rates = agencyRates.getSUVRates();

        String[] array = new String[5];

        array[0] = "Daily: $" + rates.getDailyRate();
        array[1] = "Weekly: $" + rates.getWeeklyRate();
        array[2] = "Monthly: $" + rates.getMonthlyRate();
        array[3] = "Per Mile: $" + rates.getMileageChrg();
        array[4] = "Daily Insur: $" + rates.getDailyInsurRate();

        return array;
    }

    public static String [] updateTruckRates(VehicleRates r) {
        agencyRates.updateTruckRates(r);
        VehicleRates rates = agencyRates.getTruckRates();

        String[] array = new String[5];

        array[0] = "Daily: $" + rates.getDailyRate();
        array[1] = "Weekly: $" + rates.getWeeklyRate();
        array[2] = "Monthly: $" + rates.getMonthlyRate();
        array[3] = "Per Mile: $" + rates.getMileageChrg();
        array[4] = "Daily Insur: $" + rates.getDailyInsurRate();

        return array;
    }

    public static String [] estimatedRentalCost(RentalDetails details)
    {
        String [] array = new String [1];

        double estimatedCost = agencyRates.calcEstimatedCost(details.getVehicleType(), details.getEstimatedRentalPeriod(),
                details.getEstimatiedNumMiles(), details.isDailyInsurance(), details.isPrimeCustomer());

        array[0] = "Estimated Total: $"  + estimatedCost;

        return array;
    }

    public static String [] processReturnedVehicle(String acctNum, String vin, int numDaysUsed, int numMilesDriven)
            throws VINNotFoundException, UnreservedVehicleException,
            AccountNumberNotFoundException, InvalidAcctNumException
    {
        String [] array  = new String [1];

        Vehicle hold = agencyVehicles.getVehicle(vin);
        Account acchold = accounts.getAccount(acctNum);

        if (hold.isReserved())
        {
            double calcCost = agencyRates.calcActualCost(hold.getCost(), numDaysUsed, numMilesDriven,
                    hold.getResv().isInsuranceSelected(), hold.getResv().isPrimeCustomer());

            Transaction newTransaction = new Transaction(hold.getResv().getAcctNum(), accounts.getAccount(hold.getResv().getAcctNum()).getCompanyName(),
                    hold.getResv().getVehicleType(),  hold.getResv().getRentalPeriod(), "Total Cost: $" + calcCost);

            transactionHistory.add(newTransaction);
            agencyVehicles.getVehicle(vin).cancelReservation();
            acchold.removeVehicle();

            array[0] = "Total Cost: $" + calcCost;
        }
        else
        {
            throw new UnreservedVehicleException("Vehicle must be reserved first!");
        }

        return array;
    }

    //vehicle - related methods

    public static String []  getAvailCars()
    {
        int size = 0;
        int counter = 0;
        Vehicle hold;

        while (agencyVehicles.hasNext())
        {
            hold = agencyVehicles.next();

            if (!hold.isReserved() && hold.getVehicleType() == 1)
                size++;
        }

        if (size == 0)
            System.out.println("Empty");

        agencyVehicles.reset();

        String [] array = new String [size];

        while (agencyVehicles.hasNext())
        {
            hold = agencyVehicles.next();

            if (!hold.isReserved() && hold.getVehicleType() == 1)
            {
                array[counter] = hold.toString();
                counter++;
            }
        }

        agencyVehicles.reset();

        return array;
    }

    public static String []  getAvailSUVs()
    {
        int size = 0;
        int counter = 0;
        Vehicle hold;

        while (agencyVehicles.hasNext())
        {
            hold = agencyVehicles.next();

            if (!hold.isReserved() && hold.getVehicleType() == 2)
                size++;
        }

        agencyVehicles.reset();

        String [] array = new String [size];

        while (agencyVehicles.hasNext())
        {
            hold = agencyVehicles.next();

            if (!hold.isReserved() && hold.getVehicleType() == 2)
            {
                array[counter] = hold.toString();
                counter++;
            }
        }

        agencyVehicles.reset();

        return array;
    }

    public static String [] getAvailTrucks()
    {
        int size = 0;
        int counter = 0;
        Vehicle hold;

        while (agencyVehicles.hasNext())
        {
            hold = agencyVehicles.next();

            if (!hold.isReserved() && hold.getVehicleType() == 3)
                size++;
        }

        agencyVehicles.reset();

        String [] array = new String [size];

        while (agencyVehicles.hasNext())
        {
            hold = agencyVehicles.next();

            if (!hold.isReserved() && hold.getVehicleType() == 3)
            {
                array[counter] = hold.toString();
                counter++;
            }
        }

        agencyVehicles.reset();

        return array;
    }

    public static String [] getAllVehicles()
    {
        int size = 0;

        while (agencyVehicles.hasNext())
        {
            size++;
            agencyVehicles.next();
        }

        agencyVehicles.reset();

        String [] array = new String [size];
        int counter = 0;

        while (agencyVehicles.hasNext())
        {
            Vehicle hold = agencyVehicles.next();

            if (hold.isReserved())
                array [counter] = hold.toString() + " RESERVED";
            else
                array[counter] = hold.toString() + " UNRESERVED";

            counter++;
        }

        agencyVehicles.reset();

        return array;
    }

    public static String [] makeReservation(ReservationDetails details)
            throws VINNotFoundException, AccountNumberNotFoundException,
            InvalidAcctNumException, ReservedVehicleException
    {
        String [] array = new String [1];

        Vehicle hold = agencyVehicles.getVehicle(details.getVIN());
        Account accHold = accounts.getAccount(details.getAcctNum());

        Reservation resv = new Reservation(details.getAcctNum(), hold.getVehicleType(),
                hold.getDescription(), details.getRentalperiod(), details.isInsurance(), accHold.isPrimeCustomer());

        hold.setCost(agencyRates.getCarRates().cloneAsCostType());
        hold.setResv(resv);

        VehicleNode vehicle = new VehicleNode(hold);
        accHold.setLinkedList(vehicle);

        array[0] = resv.toString();

        return array;
    }

    public static String [] cancelReservation(String vin, String acctNum)
            throws VINNotFoundException, UnreservedVehicleException, AccountNumberNotFoundException,
            InvalidAcctNumException
    {
        String [] array = new String [1];

        agencyVehicles.getVehicle(vin).cancelReservation();
        accounts.getAccount(acctNum).removeVehicle();

        array [0] = "Vehicle " + agencyVehicles.getVehicle(vin).getVin() + " Is now unreserved.";

        return array;
    }

    public static String [] getReservation(String acctNum)
            throws AccountNumberNotFoundException, InvalidAcctNumException
    {
        String [] array = accounts.getAccount(acctNum).getVehiclesReserved();

        return array;
    }

    public static String [] getAllReservations()
    {
        int size = 0, counter = 0;

        while (agencyVehicles.hasNext())
        {
            if (agencyVehicles.next().isReserved())
                size++;
        }

        agencyVehicles.reset();

        String [] array = new String [size];

        while (agencyVehicles.hasNext())
        {
            Vehicle hold = agencyVehicles.next();

            if (hold.isReserved())
            {
                array[counter] = hold.getResv().toString();
                counter++;
            }

        }

        agencyVehicles.reset();

        return array;
    }

    //customer accounts-related methods

    public static String [] addAccount(String acctNum, String companyName, boolean primeCustomer)
    {
        String [] array = new String[2];

        Account acc = new Account(acctNum,companyName,primeCustomer);
        accounts.add(acc);

        array[0] = acc.toString();
        array[1] = "Account added";

        return array;
    }

    public static String [] getAccount (String acctNum) throws AccountNumberNotFoundException, InvalidAcctNumException
    {
        Account hold = accounts.getAccount(acctNum);
        String [] array;

        if (hold.getVehiclesReserved() != null)
        {
            array = new String[hold.getVehiclesReserved().length + 2];
            String [] arrayHold = hold.getVehiclesReserved();

            array[0] = hold.toString();
            array[1] = "Reservations: ";

            for (int i = 0; i < arrayHold.length; i++)
            {
                array[i + 2] = arrayHold[i];
            }
        }
        else
        {
            array = new String [1];

            array[0] = hold.toString();
        }


        return array;
    }

    public static String [] updateAccount(String acctNum, String companyName, boolean primeCustomer)
    {
        String [] array = new String[2];

        Account newAccount = new Account(acctNum, companyName, primeCustomer);
        accounts.updateAccount(newAccount);
        accounts.reset();

        array [0] = newAccount.toString();
        array [1] = "Account Updated";

        return array;
    }

    public static String [] getAllAccounts()
    {
        int size = 0;

        while (accounts.hasNext())
        {
            size++;
            accounts.next();
        }

        accounts.reset();

        String [] array = new String [size];
        int counter = 0;

        while (accounts.hasNext())
        {
            array [counter] = accounts.next().toString();
            counter++;
        }

        accounts.reset();

        return array;
    }

    //transactions-related methods

    public static String [] getAllTransactions()
    {
        int size = 0;

        while (transactionHistory.hasNext())
        {
            size++;
            transactionHistory.next();
        }

        transactionHistory.reset();

        String [] array = new String [size];
        int counter = 0;

        while (transactionHistory.hasNext())
        {
            array [counter] = transactionHistory.next().toString();
            counter++;
        }

        transactionHistory.reset();

        return array;
    }

    public static String [] getAccountTransaction(String acctNum)
    {
        int size = 0;

        while (transactionHistory.hasNext())
        {
            Transaction hold = transactionHistory.next();

            if (hold.getAcctNum().equals(acctNum))
               size++;
        }

        transactionHistory.reset();
        String [] array = new String [size];
        int counter = 0;

        while (transactionHistory.hasNext())
        {
            Transaction hold = transactionHistory.next();

            if (hold.getAcctNum().equals(acctNum))
                array[counter] = hold.toString();
        }

        return array;
    }
}
