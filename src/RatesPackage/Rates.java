package RatesPackage;

//Class holds the vehicle rates class
public class Rates
{
    private VehicleRates[] rates = new VehicleRates[3];

    //Constructor takes in the rates classes and puts them in a VehicleRates array
    //Location in array is important for
    public Rates(VehicleRates car, VehicleRates suv, VehicleRates truck)
    {
        rates[0] = car;
        rates[1] = suv;
        rates[2] = truck;
    }

    //Returns the VehicleRates in array [0] as a car rate
    public VehicleRates getCarRates()
    {
        return rates[0];
    }

    //Updates the car rate in array [0]
    public void updateCarRates(VehicleRates r)
    {
        rates [0] = r;
    }

    //Returns the VehicleRates in array [1] as an SUV rate
    public VehicleRates getSUVRates()
    {
        return rates[1];
    }

    //Updates the SUV rate in array [1]
    public void updateSUVRates(VehicleRates r)
    {
        rates [1] = r;
    }

    //Returns the VehicleRates in array [2] as a truck rate
    public VehicleRates getTruckRates()
    {
        return rates[2];
    }

    //Updates the truck rate in array [2]
    public void updateTruckRates(VehicleRates r)
    {
        rates [2] = r;
    }

    //Calculates the estimated cost with given information
    public double calcEstimatedCost(int vehicleType, String estimatedRentalPeriod, int estimatedNumMiles, boolean dailyInsurance, boolean primeCustomer)
    {
        double rentalPeriodCost = 0, mileageCost = 0, dailyInsuranceCost = 0;
        int miles = estimatedNumMiles;
        char length = estimatedRentalPeriod.charAt(0);
        int lengthAmount = Integer.parseInt(estimatedRentalPeriod.replaceAll("[\\D]", ""));

        switch (vehicleType)
        {
            case 1:
                switch (length)
                {
                    case 'D':
                        rentalPeriodCost = rates[0].getDailyRate() * lengthAmount;

                        if (dailyInsurance)
                            dailyInsuranceCost = rates[0].getDailyInsurRate() * lengthAmount;
                        else
                            dailyInsuranceCost = 0;

                        break;
                    case 'W':
                        rentalPeriodCost = rates[0].getWeeklyRate() * lengthAmount;

                        if (dailyInsurance)
                            dailyInsuranceCost = rates[0].getDailyInsurRate() * lengthAmount * 7;
                        else
                            dailyInsuranceCost = 0;

                        break;
                    case 'M':
                        rentalPeriodCost = rates[0].getMonthlyRate() * lengthAmount;

                        if (dailyInsurance)
                            dailyInsuranceCost = rates[0].getDailyInsurRate() * lengthAmount * 30;
                        else
                            dailyInsuranceCost = 0;

                        break;
                }

                if (primeCustomer)
                {
                    if ((estimatedNumMiles - 100) < 0)
                       miles = 0;
                    else
                    {
                        miles = estimatedNumMiles - 100;
                    }
                }

                mileageCost = rates[0].getMileageChrg() * miles;

                break;
            case 2:
                switch (length)
                {
                    case 'D':
                        rentalPeriodCost = rates[1].getDailyRate() * lengthAmount;

                        if (dailyInsurance)
                            dailyInsuranceCost = rates[1].getDailyInsurRate() * lengthAmount;
                        else
                            dailyInsuranceCost = 0;

                        break;
                    case 'W':
                        rentalPeriodCost = rates[1].getWeeklyRate() * lengthAmount;

                        if (dailyInsurance)
                            dailyInsuranceCost = rates[1].getDailyInsurRate() * lengthAmount * 7;
                        else
                            dailyInsuranceCost = 0;

                        break;
                    case 'M':
                        rentalPeriodCost = rates[1].getMonthlyRate() * lengthAmount;

                        if (dailyInsurance)
                            dailyInsuranceCost = rates[1].getDailyInsurRate() * lengthAmount * 30;
                        else
                            dailyInsuranceCost = 0;

                        break;
                }

                if (primeCustomer)
                {
                    if ((estimatedNumMiles - 100) < 0)
                        miles = 0;
                    else
                    {
                        miles = estimatedNumMiles - 100;
                    }

                }

                mileageCost = rates[1].getMileageChrg() * miles;

                break;
            case 3:

                switch (length)
                {
                    case 'D':
                        rentalPeriodCost = rates[2].getDailyRate() * lengthAmount;

                        if (dailyInsurance)
                            dailyInsuranceCost = rates[2].getDailyInsurRate() * lengthAmount;
                        else
                            dailyInsuranceCost = 0;

                        break;
                    case 'W':
                        rentalPeriodCost = rates[2].getWeeklyRate() * lengthAmount;

                        if (dailyInsurance)
                            dailyInsuranceCost = rates[2].getDailyInsurRate() * lengthAmount * 7;
                        else
                            dailyInsuranceCost = 0;

                        break;
                    case 'M':
                        rentalPeriodCost = rates[2].getMonthlyRate() * lengthAmount;

                        if (dailyInsurance)
                            dailyInsuranceCost = rates[2].getDailyInsurRate() * lengthAmount * 30;
                        else
                            dailyInsuranceCost = 0;

                        break;
                }

                if (primeCustomer)
                {
                    if ((estimatedNumMiles - 100) < 0)
                        miles = 0;
                    else
                    {
                        miles = estimatedNumMiles - 100;
                    }

                }

                mileageCost = rates[2].getMileageChrg() * miles;

                break;
        }

        System.out.println(rentalPeriodCost);
        System.out.println(mileageCost);
        System.out.println(dailyInsuranceCost);

        return rentalPeriodCost + mileageCost + dailyInsuranceCost;
    }

    //Calculates the actual cost
    public double calcActualCost(Cost rates, int numDaysUsed, int numMilesDriven, boolean dailyInsurance, boolean primeCustomer)
    {
        double rentalPeriodCost = 0, mileageCost = 0, dailyInsuranceCost = 0;
        int miles = numMilesDriven;

        if (primeCustomer)
        {
            if ((numMilesDriven - 100) < 0)
                miles = 0;
            else
            {
                miles = numMilesDriven - 100;
            }
        }

        mileageCost = rates.getMileageChrg() * miles;

        if (dailyInsurance)
            dailyInsuranceCost = numDaysUsed * rates.getDailyInsurRate();

        if (numDaysUsed < 7)
        {
            rentalPeriodCost = rates.getDailyRate() * numDaysUsed;
        }
        else if (numDaysUsed >= 7 && numDaysUsed < 30)
        {
            double weeks = Math.ceil(numDaysUsed/7.0);
            rentalPeriodCost = rates.getWeeklyRate() * weeks;
        }
        else
        {
            double months = Math.ceil(numDaysUsed/30.0);
            rentalPeriodCost = rates.getMonthlyRate() * months;
        }

        System.out.println(rentalPeriodCost);
        System.out.println(mileageCost);
        System.out.println(dailyInsuranceCost);

        return rentalPeriodCost + mileageCost + dailyInsuranceCost;
    }
}
