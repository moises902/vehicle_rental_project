package TransactionPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

//Aggregation of transaction classes

public class Transactions
{
    private List<Transaction> transactions;
    private int indexIterator;

    public Transactions()
    {
        transactions = new ArrayList<>();
        indexIterator = 0;
    }

    public Transactions(Transaction t)
    {
        transactions = new ArrayList<>();
        transactions.add(t);
        indexIterator = 0;
    }

    public void add(Transaction t)
    {
        transactions.add(t);
    }

    public void reset()
    {
        indexIterator = 0;
    }

    public boolean hasNext()
    {
       return indexIterator < transactions.size();
    }

    public Transaction next() throws NoSuchElementException
    {
        if (!hasNext())
        {
            throw new NoSuchElementException();
        }

        Transaction t = transactions.get(indexIterator);
        indexIterator++;

        return t;
    }
}
