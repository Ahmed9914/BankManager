import java.math.BigDecimal;


public abstract class BankAccount {

    //account details are private and can only be accessed using getters, they can only be set in the constructor
    private final String mAccountHolderName;
    private final String mAccountNumber;
    private final String mRoutingNumber;
    //isActive doesn't need to be accessed outside this class and hence doesn't need getters/setters
    private boolean mIsActive;
    //balance needs to be protected so interest can be applied in child classes
    protected BigDecimal balance;

    /**
     * Constructor with account details (name, number and routing info)
     * @param accountHolderName
     * @param accountNumber
     * @param routingNumber
     */
    public BankAccount(String accountHolderName, String accountNumber, String routingNumber){
        this.mAccountHolderName = accountHolderName;
        this.mAccountNumber = accountNumber;
        this.mRoutingNumber = routingNumber;
        balance = BigDecimal.ZERO;
    }

    /**
     * Since this abstract class doesn't perform any minimum requirements for activating an account,
     * it will always return true.
     *
     * You should override this to check for any minimum requirements (e.g. minimal balance, etc)
     *
     * @return
     */
    public boolean activate(){
        mIsActive = true;
        return mIsActive;
    }

    /**
     * Add money to balance directly, account doesn't have to be active to accept deposits
     *
     * @param deposit the amount of money to deposit
     */
    public void deposit(BigDecimal deposit){
        balance = balance.add(deposit);
    }

    /**
     * Sends money to another account and updates the balance accordingly
     * @param amount the amount to be sent
     * @param toAccount the account receiving the money
     * @return true if money transferred successfully, false otherwise
     */
    public boolean sendMoney(BigDecimal amount, BankAccount toAccount){
        //check if balance can cover that transfer
        if(!mIsActive || balance.compareTo(amount)<0){
            //account not active or insufficient funds
            return false;
        }
        //take out of balance
        balance = balance.subtract(amount);
        //check that the receiver received the amount
        toAccount.deposit(amount);
        //success! return true
        return true;
    }

    // Public getters to read account details but not change them
    public String getAccountHolderName() {
        return mAccountHolderName;
    }
    public String getAccountNumber() {
        return mAccountNumber;
    }
    public String getRoutingNumber() {
        return mRoutingNumber;
    }
}
