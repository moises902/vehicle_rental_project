package AccountPackage;

import AccountPackage.AccountException.AccountNumberNotFoundException;
import AccountPackage.AccountException.InvalidAcctNumException;

import java.util.NoSuchElementException;

//Accounts is an aggregation of accounts using the AccountNode class
public class Accounts
{
    private AccountNode accounts;
    private AccountNode iterationPointer;

    //Constructors of the class
    public Accounts ()
    {
        accounts = null;
    }

    public Accounts (Accounts account)
    {
        this.accounts = account.accounts;
        iterationPointer = this.accounts;
    }

    //Adds a new Account at the end of the list
    //If list is empty then next account will be first
    public void add (Account acc)
    {
        AccountNode node = new AccountNode(acc);

        if(accounts == null)
        {
            accounts = node;
            iterationPointer = node;
        }
        else
        {
            AccountNode iterator = accounts;

            while (iterator.getNext() != null)
            {
                iterator = iterator.getNext();
            }

            iterator.setNext(node);
        }
    }

    //Acquires a specific account in the list by searching the account number
    public Account getAccount (String acctNum) throws AccountNumberNotFoundException, InvalidAcctNumException
    {
        AccountNode node = accounts;

        if (acctNum.matches("[0-9]+") && acctNum.length() == 5)
        {
            while (node != null)
            {
                if (node.getData().getAcctNum().equals(acctNum))
                {
                    return node.getData();
                }

                node = node.getNext();
            }

            if (node == null)
            {
                throw new AccountNumberNotFoundException("AccountPackage.Account Not Found");
            }
        }
        else
        {
            throw new InvalidAcctNumException("Invalid AccountPackage.Account Number");
        }

        return node.getData();
    }

    //Determines if there is another account after the iteration pointer
    public boolean hasNext()
    {
        return iterationPointer != null;
    }

    //Returns the account that is in the list
    public Account next() throws NoSuchElementException
    {
        AccountNode node = iterationPointer;

        if(!hasNext())
        {
            throw new NoSuchElementException();
        }

        iterationPointer = iterationPointer.getNext();

        return node.getData();
    }

    //Able to search an account in the ist and change it
    public void updateAccount(Account acc)
    {
        AccountNode node = accounts;

        while (hasNext())
        {
            if (node.getData().getAcctNum().equals(acc.getAcctNum()))
                node.setData(acc);

            node = node.getNext();
            next();
        }
    }

    //Resets the iteration pointer back to the first AccountNode
    public void reset()
    {
        iterationPointer = accounts;
    }
}
