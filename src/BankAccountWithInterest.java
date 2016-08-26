import java.math.BigDecimal;

public abstract class BankAccountWithInterest extends BankAccount implements Interestable {

    private final double mAnnualInterestRate;

    /**
     * Constructor with account details (name, number and routing info)
     *
     * @param accountHolderName
     * @param accountNumber
     * @param routingNumber
     */
    public BankAccountWithInterest(
            String accountHolderName, String accountNumber, String routingNumber, double annualInterestRate) {
        super(accountHolderName, accountNumber, routingNumber);
        this.mAnnualInterestRate = annualInterestRate;
    }

    /**
     * Applies the monthly interest based on the annual interest rate
     * This will be called once every month
     */
    @Override
    public void applyInterest() {
        BigDecimal interest =  balance.multiply(new BigDecimal(mAnnualInterestRate));
        interest = interest.divide(new BigDecimal(12),BigDecimal.ROUND_DOWN);
        balance = balance.add(interest);
    }
}
