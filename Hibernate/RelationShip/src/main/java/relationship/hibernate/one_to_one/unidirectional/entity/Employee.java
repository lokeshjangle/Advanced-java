package relationship.hibernate.one_to_one.unidirectional.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Employee_master")
public class Employee {

    @Id
    @Column(name = "emp_no")
    private int employeeNo;
    @Column(name = "emp_name")
    private String name;
    @Column(name = "emp_salary")
    private int salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ppt_no")  //Refers tp foreign key column of Employee_master table which refers to Primary key of passport_master table
    private Passport passportDetails;  //Refer to passport

    public Employee() {
    }

    public Employee(int employeeNo, String name, int salary, Passport passportDetails) {
        this.employeeNo = employeeNo;
        this.name = name;
        this.salary = salary;
        this.passportDetails = passportDetails;
    }

    public int getEmployeeNo() {


        return employeeNo;
    }

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Passport getPassportDetails() {
        return passportDetails;
    }

    public void setPassportDetails(Passport passportDetails) {
        this.passportDetails = passportDetails;
    }
}
