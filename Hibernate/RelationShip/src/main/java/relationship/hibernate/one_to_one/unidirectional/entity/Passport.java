package relationship.hibernate.one_to_one.unidirectional.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Passport_master")
public class Passport {

    @Id
    @Column(name = "passport_no")
    private String passportNo;
    @Column(name = "passport_name")
    private String nameOnPassport;

    @Column(name="passport_expiry_date")
    private LocalDate dateOfExpiry;

    public Passport() {
    }

    public Passport(String passportNo, String nameOnPassport, LocalDate dateOfExpiry) {
        this.passportNo = passportNo;
        this.nameOnPassport = nameOnPassport;
        this.dateOfExpiry = dateOfExpiry;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getNameOnPassport() {
        return nameOnPassport;
    }

    public void setNameOnPassport(String nameOnPassport) {
        this.nameOnPassport = nameOnPassport;
    }

    public LocalDate getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(LocalDate dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "passportNo='" + passportNo + '\'' +
                ", nameOnPassport='" + nameOnPassport + '\'' +
                ", dateOfExpiry=" + dateOfExpiry +
                '}';
    }
}
