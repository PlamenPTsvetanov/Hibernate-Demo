import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends BillingDetail {
    private String type;
    private LocalDate expirationDate;

    public CreditCard() {
    }

    public CreditCard(long number, String type, LocalDate expirationDate) {
        super(number);
        this.type = type;
        this.expirationDate = expirationDate;
    }

    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "expiration_date", nullable = false)
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
