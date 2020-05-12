package VehiclesPackage.VehicleExceptions;

//Exception class when vehicle isn't reserved

public class UnreservedVehicleException extends Exception
{
    public UnreservedVehicleException (String message)
    {
        super(message);
    }
}
