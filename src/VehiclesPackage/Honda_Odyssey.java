package VehiclesPackage;

public class Honda_Odyssey extends Vehicle
{

    public Honda_Odyssey()
    {
        super("Honda Odyssey (SUV)", 28, "VM9RE2635TD");
    }

    public int getVehicleType()
    {
        return 2;
    }

    @Override
    public String toString()
    {
        return getDescription()
                + " MPG: " + getMpg()
                + " Seating: 7 "
                + " Storage: 6 Cubic ft."
                + " VIN: " + getVin();
    }


}
