package TransactionPackage;

//Transaction class holds information of returned rentals and returns it to string
public class Transaction
{
    private String acctNum;
    private String companyName;
    private String vehicleType;
    private String rentalPeriod;
    private String rentalCost;

    //Constructor
    public Transaction(String acctNum, String companyName, String vehicleType, String rentalPeriod, String rentalCost)
    {
        this.acctNum = acctNum;
        this.companyName = companyName;
        this.vehicleType = vehicleType;
        this.rentalPeriod = rentalPeriod;
        this.rentalCost = rentalCost;
    }

    public String toString()
    {
        return "Account Number: " + acctNum
                + " Company Name: " + companyName
                + " Vehicle Type: " + vehicleType
                + " Rental Period: " + rentalPeriod
                + " Rental Cost: " + rentalCost;
    }

    public String getAcctNum()
    {
        return acctNum;
    }
}
