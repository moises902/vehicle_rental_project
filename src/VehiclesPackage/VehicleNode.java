package VehiclesPackage;

//Class is a node for a linked list of Vehicle classes\
public class VehicleNode
{
    private Vehicle data;
    private VehicleNode next;

    public VehicleNode (Vehicle data)
    {
       this.data = data;
       next = null;
    }

    public void setNext(VehicleNode next)
    {
        this.next = next;
    }

    public Vehicle getData()
    {
        return data;
    }

    public VehicleNode getNext()
    {
        return next;
    }
}
