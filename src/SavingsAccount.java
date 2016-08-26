import java.math.BigDecimal;

public class SavingsAccount extends BankAccountWithInterest{
    private static final int MAX_TRANSFERS = 6;
    private int transferCount;

    /**
     * Constructor with account details (name, number and routing info)
     *
     * @param accountHolderName
     * @param accountNumber
     * @param routingNumber
     * @param annualInterestRate
     */
    public SavingsAccount(String accountHolderName, String accountNumber, String routingNumber,
                          double annualInterestRate) {
        super(accountHolderName, accountNumber, routingNumber, annualInterestRate);
    }

    @Override
    public boolean sendMoney(BigDecimal amount, BankAccount toAccount){
        if(transferCount<MAX_TRANSFERS){
            transferCount++;
            return super.sendMoney(amount, toAccount);
        }else {
            return false;
        }
    }

    //called once every month
    public void resetTransferCount(){
        transferCount = 0;
    }
}

