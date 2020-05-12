package DetailsPackage;

//This class only hold the information required for reservations
//Only has a constructor and getters

public class ReservationDetails
{
    private String VIN, acctNum, rentalperiod;
    private boolean insurance;

    public ReservationDetails (String VIN, String acctNum, String rentalperiod, boolean insurance)
    {
        this.VIN = VIN;
        this.acctNum = acctNum;
        this.rentalperiod = rentalperiod;
        this.insurance = insurance;
    }

    public String getVIN()
    {
        return VIN;
    }

    public String getAcctNum()
    {
        return acctNum;
    }

    public String getRentalperiod()
    {
        return rentalperiod;
    }

    public boolean isInsurance()
    {
        return insurance;
    }
}
