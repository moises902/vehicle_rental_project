import TransactionPackage.Transaction;
import TransactionPackage.Transactions;

public class TransactionTest
{
    public static void main(String [] args)
    {
        Transaction momscar = new Transaction("12345", "mc", "SUV", "3D","50");
        Transaction dreamcar = new Transaction("58403", "sc", "Car", "2W", "900");
        Transaction constructionCar = new Transaction("39481", "cc", "Truck", "4M", "5000");

        Transactions totalTrans = new Transactions();

        totalTrans.add(momscar);
        totalTrans.add(constructionCar);
        totalTrans.add(dreamcar);

        System.out.println(totalTrans.next());
        System.out.println(totalTrans.hasNext());
        System.out.println(totalTrans.next());
        System.out.println(totalTrans.hasNext());
        System.out.println(totalTrans.next());
        System.out.println(totalTrans.hasNext());
    }
}
