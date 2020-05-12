package VehiclesPackage;

import VehiclesPackage.VehicleExceptions.VINNotFoundException;

import java.util.NoSuchElementException;

//Class is the linked list of Vehicle classes
public class Vehicles
{
    private VehicleNode agencyVehicle;
    private VehicleNode iterationPointer;

    public Vehicles()
    {
        agencyVehicle = null;
    }

    public Vehicles(Vehicles vech)
    {
        agencyVehicle = vech.agencyVehicle;
        iterationPointer = vech.agencyVehicle;
    }

    //Method adds another vehicle in the aggregation of vehicles
    public void add(Vehicle v)
    {
        VehicleNode newNode = new VehicleNode(v);

        if (agencyVehicle == null)
        {
            agencyVehicle = newNode;
            iterationPointer = newNode;
        }
        else
        {
            VehicleNode iterator = agencyVehicle;

            while (iterator.getNext() != null)
            {
                iterator = iterator.getNext();
            }

            iterator.setNext(newNode);
        }
    }

    //Method locates a vehicle in the linkedlist by VIN
    //Returns the vehicle if found
    public Vehicle getVehicle(String VIN) throws VINNotFoundException
    {
        VehicleNode node = agencyVehicle;

        while (node != null)
        {
            if (node.getData().getVin().equals(VIN))
            {
                return node.getData();
            }

            node = node.getNext();
        }

        if (node == null)
            throw new VINNotFoundException("VIN not found.");

        return node.getData();
    }

    //Determines if there is another vehicle after the iteration pointer
    public boolean hasNext()
    {
       return iterationPointer != null;
    }

    //Returns the vehicle that is in the list
    public Vehicle next() throws NoSuchElementException
    {
        VehicleNode node = iterationPointer;

        if(!hasNext())
        {
            throw new NoSuchElementException();
        }

        iterationPointer = iterationPointer.getNext();

        return node.getData();
    }

    //Resets the iteration pointer back to the first AccountNode
    public void reset()
    {
        iterationPointer = agencyVehicle;
    }
}