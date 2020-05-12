package RatesPackage;

//Set rates for car vehicle types

public class CarRates extends VehicleRates
{
    public CarRates()
    {
        super(24.95, 149.95, 514.95, 0.15, 14.95);
    }

    public CarRates(double dailyRate, double weeklyRate, double monthlyRate, double milageChrg, double dailyInsurRate)
    {
        super(dailyRate, weeklyRate, monthlyRate, milageChrg ,dailyInsurRate);
    }
}
