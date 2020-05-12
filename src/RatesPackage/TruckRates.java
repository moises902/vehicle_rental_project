package RatesPackage;

//Set rates for truck vehicle types

public class TruckRates extends VehicleRates
{
    public TruckRates()
    {
        super(34.95, 224.95, 797.95, 0.26, 22.95);
    }

    public TruckRates(double dailyRate, double weeklyRate, double monthlyRate, double milageChrg, double dailyInsurRate)
    {
        super(dailyRate,weeklyRate,monthlyRate, milageChrg, dailyInsurRate);
    }
}
