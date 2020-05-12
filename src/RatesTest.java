import RatesPackage.CarRates;
import RatesPackage.Rates;
import RatesPackage.SUVRates;
import RatesPackage.TruckRates;

public class RatesTest
{
    public static void main(String [] agrs)
    {
        CarRates car = new CarRates();
        SUVRates suv = new SUVRates();
        TruckRates truck = new TruckRates();

        Rates rates = new Rates(car,suv,truck);

        System.out.println(rates.calcEstimatedCost(2,"M2", 500, true, true));

        System.out.println();

        System.out.println(rates.calcActualCost(car.cloneAsCostType(), 62, 500,
                true, true));


    }
}
