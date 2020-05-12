package VehiclesPackage;

import RatesPackage.Cost;
import VehiclesPackage.VehicleExceptions.ReservedVehicleException;
import VehiclesPackage.VehicleExceptions.UnreservedVehicleException;

public abstract class Vehicle
{
    private int mpg;
    private String description;
    private String vin;
    private Reservation resv;
    private Cost rates;

    public Vehicle(String description, int mpg, String vin)
    {
        this.description = description;
        this.mpg = mpg;
        this.vin = vin;
        resv = null;
        rates = null;
    }

    public String getDescription()
    {
        return description;
    }
    public int getMpg()
    {
        return mpg;
    }
    public String getVin()
    {
        return vin;
    }
    public Reservation getResv()
    {
        return resv;
    }
    public Cost getCost()
    {
        return rates;
    }

    // Returns a boolean indicating that the vehicle is reserved or not
    public boolean isReserved()
    {
        if (resv == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    // Method sets the reservation of the vehicle
    // Throws an exception if the vehicle is currently reserved
    public void setResv(Reservation resv) throws ReservedVehicleException
    {
        if (isReserved())
        {
            throw new ReservedVehicleException("Vehicle is already Reserved!");
        }
        else
        {
            this.resv = resv;
        }
    }

    // Method cancels the reservation of the vehicle
    // Throws an exception if vehicle is currently unreserved
    public void cancelReservation() throws UnreservedVehicleException
    {
        if (!isReserved())
        {
            throw new UnreservedVehicleException("VehiclesPackage.Vehicle is currently unreserved");
        }
        else
        {
            resv = null;
        }
    }

    //Set the rates of the vehicle
    public void setCost(Cost rates)
    {
        this.rates = rates;
    }

    public abstract String toString();
    public abstract int getVehicleType();
}
































