package VehiclesPackage.VehicleExceptions;

//Exception class when the VIN of the vehicle cannot be found

public class VINNotFoundException extends Exception
{
    public VINNotFoundException (String message)
    {
        super(message);
    }
}
