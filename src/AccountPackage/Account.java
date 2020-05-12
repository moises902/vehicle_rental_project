package AccountPackage;

import VehiclesPackage.VehicleNode;

//Class to store information of a certain account
public class Account
{
    private String acctNum;
    private String companyName;
    private VehicleNode reservedVehicles;
    private boolean primeCustomer;

    //Constructors for class
    public Account()
    {
        acctNum = " ";
        companyName = " ";
        reservedVehicles = null;
        primeCustomer = false;
    }

    public Account(String acctNum, String companyName, boolean primeCustomer)
    {
        this.acctNum = acctNum;
        this.companyName = companyName;
        this.primeCustomer = primeCustomer;
    }

    //Creates a linked list of reserved vehicles for a certain account
    public void setLinkedList(VehicleNode reservedVehicles)
    {
        this.reservedVehicles = reservedVehicles;
    }

    public void removeVehicle()
    {
        reservedVehicles = null;
    }

    //Returns the account number
    public String getAcctNum()
    {
        return acctNum;
    }

    //Returns the company name
    public String getCompanyName() {
        return companyName;
    }

    //Returns a string array with description of reserved vehicles in the account
    public String[] getVehiclesReserved()
    {
        String [] reservedVehiclesList = new String [11];
        VehicleNode node = reservedVehicles;

        if (node != null)
        {
            int index = 0;

            while (node.getNext() != null)
            {
                reservedVehiclesList[index] = node.getData().getDescription();
                node = node.getNext();
                index++;
            }

            reservedVehiclesList[index] = node.getData().toString();
        }
        else
        {
            reservedVehiclesList [0] = "empty";
        }

        return reservedVehiclesList;
    }

    //Returns a boolean if the account is prime or not
    public boolean isPrimeCustomer()
    {
        return primeCustomer;
    }

    //Returns a string of the accounts information
    public String toString ()
    {
        return "Account Number: " + acctNum
                + " Company Name: " + companyName
                + " Prime Customer: " + primeCustomer;
    }
}
