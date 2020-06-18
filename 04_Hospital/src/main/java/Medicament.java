import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "medicaments")
public class Medicament extends BaseEntity {
    private String name;
    private Set<Diagnose> diagnoses;

    public Medicament() {
    }

    public Medicament(String name) {
        this.setName(name);
    }

    @Column(name = "name", unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    @ManyToMany(mappedBy = "medicaments", targetEntity = Diagnose.class)
    public Set<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }
}
