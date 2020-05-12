package RatesPackage;

//Set rates for SUV vehicle types

public class SUVRates extends VehicleRates
{
    public SUVRates()
    {
        super(29.95, 189.95, 679.95, 0.15, 14.95);
    }

    public SUVRates(double dailyRate, double weeklyRate, double monthlyRate, double milageChrg, double dailyInsurRate)
    {
        super(dailyRate, weeklyRate, monthlyRate, milageChrg, dailyInsurRate);
    }
}
