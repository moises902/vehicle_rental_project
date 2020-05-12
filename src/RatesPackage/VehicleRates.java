package RatesPackage;

//Abstract class for vehicle rates
public abstract class VehicleRates
{
    private double dailyRate, weeklyRate, monthlyRate, milageChrg, dailyInsurRate;

    public VehicleRates(double dailyRate, double weeklyRate, double monthlyRate, double milageChrg, double dailyInsurRate)
    {
        this.dailyRate = dailyRate;
        this.weeklyRate = weeklyRate;
        this.monthlyRate = monthlyRate;
        this.milageChrg = milageChrg;
        this.dailyInsurRate = dailyInsurRate;
    }

    //Returns the daily rate
    public double getDailyRate()
    {
        return dailyRate;
    }

    //Returns the weekly rate
    public double getWeeklyRate()
    {
        return weeklyRate;
    }

    //Returns the monthly rate
    public double getMonthlyRate()
    {
        return monthlyRate;
    }

    //Returns the mileage charge
    public double getMileageChrg()
    {
        return milageChrg;
    }

    //Returns the daily insurance rate
    public double getDailyInsurRate()
    {
        return dailyInsurRate;
    }

    //Creates a clone of the VehicleRates class as a Cost class
    private class ClonedCost implements Cost
    {
        @Override
        public double getDailyRate()
        {
            return VehicleRates.this.getDailyRate();
        }

        @Override
        public double getWeeklyRate()
        {
            return VehicleRates.this.getWeeklyRate();
        }

        @Override
        public double getMonthlyRate()
        {
            return VehicleRates.this.getMonthlyRate();
        }

        @Override
        public double getMileageChrg()
        {
            return VehicleRates.this.getMileageChrg();
        }

        @Override
        public double getDailyInsurRate() {
            return VehicleRates.this.getDailyInsurRate();
        }
    }

    //Returns the Cost class version of the VehicleRates class
    public Cost cloneAsCostType ()
    {
        ClonedCost cost = new ClonedCost();

        return cost;
    }
}
