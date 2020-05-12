package AccountPackage;

//AccountNode is a linked list of Account data
public class AccountNode
{
    private Account data;
    private AccountNode next;

    public AccountNode(Account data)
    {
        this.data = data;
        next = null;
    }

    //Attaches a new Account node to the list
    public void setNext(AccountNode next)
    {
        this.next = next;
    }

    //Returns the data of the current AccountNode
    public Account getData()
    {
        return data;
    }

    //Returns the data of the next AccountNode
    public AccountNode getNext()
    {
        return next;
    }

    public void setData(Account data)
    {
        this.data = data;
    }
}