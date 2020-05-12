package AccountPackage.AccountException;

//Exception class when an invalid account number is inputted
public class InvalidAcctNumException extends Exception
{
    public InvalidAcctNumException (String message)
    {
        super(message);
    }
}
