import java.math.BigDecimal;
import java.time.LocalDate;

public class CertificatesOfDeposit extends BankAccountWithInterest {
    private static final BigDecimal MIN_DEPOSIT = new BigDecimal(1000);
    private final LocalDate mExpiryDate; //expiry date, allow withdrawals only after this date

    /**
     * Constructor with account details
     *
     * @param accountHolderName
     * @param accountNumber
     * @param routingNumber
     * @param annualInterestRate
     * @param expiryDate
     */
    public CertificatesOfDeposit(
            String accountHolderName, String accountNumber, String routingNumber,
            double annualInterestRate, LocalDate expiryDate) {
        super(accountHolderName, accountNumber, routingNumber, annualInterestRate);
        this.mExpiryDate = expiryDate;
    }

    @Override
    public boolean activate() {
        //only activate the account if the deposit meets min deposit requirement
        if (balance.compareTo(MIN_DEPOSIT) >= 0) {
            return super.activate();
        } else {
            return false;
        }
    }

    @Override
    public boolean sendMoney(BigDecimal amount, BankAccount toAccount) {
        //check if date now is larger than expiry date, which means we are now allowed to transfer money
        if (LocalDate.now().compareTo(mExpiryDate) > 0) {
            //super will do all other checks (sufficient funds and is active)
            return super.sendMoney(amount, toAccount);
        } else {
            //CD hasn't expired yet, meaning that we cannot transfer any money out till it expires
            return false;
        }
    }

}
