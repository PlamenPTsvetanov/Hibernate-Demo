import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient extends BaseEntity {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private LocalDate dateOfBirth;
    private String picture;
    private boolean hasInsurance;
    private Set<Visitation> visitations;
    private Set<Diagnose> diagnoses;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String address,
                   String email, LocalDate dateOfBirth, String picture, boolean hasInsurance) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAddress(address);
        this.setEmail(email);
        this.setDateOfBirth(dateOfBirth);
        this.setPicture(picture);
        this.setHasInsurance(hasInsurance);
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.trim().length() == 0) {
            throw new IllegalArgumentException("Please enter a valid first name!");
        } else {
            this.firstName = firstName;
        }
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.trim().length() == 0) {
            throw new IllegalArgumentException("Please enter a valid last name!");
        } else {
            this.lastName = lastName;
        }
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address.trim().length() == 0) {
            throw new IllegalArgumentException("Please enter a valid address!");
        } else {
            this.address = address;
        }
    }

    @Column(name = "email", unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.trim().length() == 0 || !email.contains("@")) {
            throw new IllegalArgumentException("Please enter a valid email!");
        } else {
            this.email = email;
        }
    }

    @Column(name = "birth_date")
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth.getYear() == 0 || dateOfBirth.getMonth() == null || dateOfBirth.getYear() > 2020) {
            throw new IllegalArgumentException("Please enter a valid date of birth!");
        } else {
            this.dateOfBirth = dateOfBirth;
        }
    }

    @Column(name = "picture")
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        if (picture.trim().length() == 0) {
            throw new IllegalArgumentException("Please enter a valid picture!");
        } else {
            this.picture = picture;
        }
    }

    @Column(name = "has_Insurance")
    public boolean isHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    @OneToMany(mappedBy = "patient", targetEntity = Visitation.class)
    public Set<Visitation> getVisitations() {
        return visitations;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }

    @OneToMany(mappedBy = "patient", targetEntity = Diagnose.class)
    public Set<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }
}
