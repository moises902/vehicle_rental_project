package VehiclesPackage.VehicleExceptions;

//Exception class when vehicle is already reserved

public class ReservedVehicleException extends Exception
{
    public ReservedVehicleException (String message)
    {
        super(message);
    }
}
