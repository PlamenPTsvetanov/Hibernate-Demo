import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visitations")
public class Visitation extends BaseEntity {
    private LocalDate visit;
    private String comment;
    private Patient patient;

    public Visitation() {
    }

    public Visitation(LocalDate date, String comment) {
        this.setVisit(date);
        this.setComment(comment);
    }

    @Column(name = "date_of_visit")
    public LocalDate getVisit() {
        return visit;
    }

    public void setVisit(LocalDate visit) {
        if (visit.getYear() == 0 || visit.getMonth() == null) {
            throw new IllegalArgumentException("Invalid date of visit!");
        }
        this.visit = visit;
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
}
