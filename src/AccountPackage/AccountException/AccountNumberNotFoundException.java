package AccountPackage.AccountException;

//Exception class when an account cannot be found

public class AccountNumberNotFoundException extends Exception
{
    public AccountNumberNotFoundException (String message)
    {
        super(message);
    }
}
