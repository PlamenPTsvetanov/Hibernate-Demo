import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "debit_cards")
public class DebitCard extends BillingDetail {
    private String bankName;
    private String SWIFTCode;

    public DebitCard() {
    }

    public DebitCard(long number, String bankName, String code) {
        super(number);
        this.bankName = bankName;
        this.SWIFTCode = code;
    }

    @Column(name = "bank_name", nullable = false)
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Column(name = "SWIFT_code", nullable = false)
    public String getSWIFTCode() {
        return SWIFTCode;
    }

    public void setSWIFTCode(String SWIFTCode) {
        this.SWIFTCode = SWIFTCode;
    }
}
