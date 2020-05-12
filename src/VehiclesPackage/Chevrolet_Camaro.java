package VehiclesPackage;

public class Chevrolet_Camaro extends Vehicle
{

    public Chevrolet_Camaro()
    {
        super("Chevrolet Camaro (Car)", 30, "KH4GM4565GD");
    }

    public int getVehicleType()
    {
        return 1;
    }

    @Override
    public String toString()
    {
        return getDescription()
                + " MPG: " + getMpg()
                + " Seating: 4 "
                + " VIN: " + getVin();
    }
}
