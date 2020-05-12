package VehiclesPackage;

public class Ten_Foot extends Vehicle
{

    public Ten_Foot()
    {
        super("Ten-Foot (Truck)", 12, "EJ5KU2435BC");
    }

    public int getVehicleType()
    {
        return 3;
    }

    @Override
    public String toString()
    {
        return getDescription()
                + " MPG: " + getMpg()
                + " Load Capacity: 5390 lbs."
                + " VIN: " + getVin();
    }
}
