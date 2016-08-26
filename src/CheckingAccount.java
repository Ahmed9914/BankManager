
public class CheckingAccount extends BankAccount {

    /**
     * Constructor with account details (name, number and routing info)
     *
     * @param accountHolderName
     * @param accountNumber
     * @param routingNumber
     */
    public CheckingAccount(String accountHolderName, String accountNumber, String routingNumber) {
        super(accountHolderName, accountNumber, routingNumber);
    }
}
