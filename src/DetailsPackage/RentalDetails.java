package DetailsPackage;

//This class only hold the information required for rentals
//Only has a constructor and getters

public class RentalDetails
{
    private int vehicleType, estimatiedNumMiles;
    private boolean dailyInsurance, primeCustomer;
    private String estimatedRentalPeriod;

    public RentalDetails(int vehicleType, String estimatedRentalPeriod, int estimatiedNumMiles, boolean dailyInsurance, boolean primeCustomer)
    {
        this.vehicleType = vehicleType;
        this.estimatedRentalPeriod = estimatedRentalPeriod;
        this.estimatiedNumMiles = estimatiedNumMiles;
        this.dailyInsurance = dailyInsurance;
        this.primeCustomer = primeCustomer;
    }

    public int getVehicleType()
    {
        return vehicleType;
    }

    public String getEstimatedRentalPeriod()
    {
        return estimatedRentalPeriod;
    }

    public int getEstimatiedNumMiles()
    {
        return estimatiedNumMiles;
    }

    public boolean isDailyInsurance()
    {
        return dailyInsurance;
    }

    public boolean isPrimeCustomer()
    {
        return primeCustomer;
    }
}
