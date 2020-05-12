package VehiclesPackage;

//Reservation class hold info
public class Reservation
{
    private String acctNum;
    private int vehicleType;
    private String description;
    private String rentalPeriod;
    private boolean insuranceSelected;
    private boolean primeCustomer;

    public Reservation()
    {
        acctNum = " ";
        vehicleType = 0;
        description = " ";
        rentalPeriod = " ";
        insuranceSelected = false;
    }

    public Reservation(String acctNum, int vehicleType, String description, String rentalPeriod,
                       boolean insuranceSelected, boolean primeCustomer)
    {
        this.acctNum = acctNum;
        this.vehicleType = vehicleType;
        this.description = description;
        this.rentalPeriod = rentalPeriod;
        this.insuranceSelected = insuranceSelected;
        this.primeCustomer = primeCustomer;
    }

    public boolean isInsuranceSelected()
    {
        return insuranceSelected;
    }

    public boolean isPrimeCustomer()
    {
        return primeCustomer;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public String getVehicleType()
    {
       if (vehicleType == 1)
           return "Car";
       else if (vehicleType == 2)
           return "SUV";
       else if (vehicleType == 3)
           return "Truck";
       else
           return "Invalid vehicle value";
    }

    public String getAcctNum()
    {
        return acctNum;
    }

    public String getRentalPeriod()
    {
        return rentalPeriod;
    }

    public String toString()
    {
        return "Account Number: " + acctNum
                + " Vehicle Type: " +  vehicleType
                + " Description: " + description
                + " Rental period: " + rentalPeriod
                + " Insurance Selected: " + insuranceSelected
                + " Prime Customer: " + primeCustomer;

    }
}
