import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BillingDetail extends BaseEntity {
    private long number;
    private User owner;

    public BillingDetail() {
    }

    public BillingDetail(long number) {
        this.number = number;
    }
    @ManyToOne
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
