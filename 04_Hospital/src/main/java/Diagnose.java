import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "diagnoses")
public class Diagnose extends BaseEntity {
    private String name;
    private String comment;
    private Patient patient;
    private Set<Medicament> medicaments;

    public Diagnose() {
    }

    public Diagnose(String name, String comment) {
        this.setName(name);
        this.setComment(comment);
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

    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        if (comment.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid comment");
        }
        this.comment = comment;
    }

    @ManyToOne
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @ManyToMany
    public Set<Medicament> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(Set<Medicament> medicaments) {
        this.medicaments = medicaments;
    }
}
