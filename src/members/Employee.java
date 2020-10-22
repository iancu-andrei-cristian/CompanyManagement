package members;

import office.JobTitle;
import payment.Salary;
import office.Office;
import office.Department;

import java.time.LocalDate;
import java.util.Date;

public class Employee extends CompanyMember {
    private Salary salary;
    private JobTitle jobTitle;
    private Office workingOffice;
    private LocalDate hiredDate;
    protected Department department;

    public Employee(String firstName, String lastName, String socialSecurityNumber, double baseSalary,
                    int workingHours, double extraHourPayment, int vacationDaysPerYear, Office workingOffice,
                    LocalDate hiredDate, Department department, JobTitle jobTitle) {
        super(firstName, lastName, socialSecurityNumber);
        this.salary = new Salary(baseSalary, workingHours, extraHourPayment, vacationDaysPerYear);
        this.workingOffice = workingOffice;
        this.hiredDate = hiredDate;
        this.department = department;
        this.jobTitle = jobTitle;
    }

    @Override
    public String getPositionTitle() {
        return jobTitle.name();
    }

    @Override
    public String getWorkingOffice() {
        return workingOffice.getName();
    }

    public void setWorkingOffice(Office workingOffice) {
        this.workingOffice = workingOffice;
    }

    public double getSalaryForCurrentMonth()
    {
        return salary.getSalaryForCurrentMonth();
    }

    public LocalDate getHiredDate() {
        return hiredDate;
    }

    public String getDepartment() {
        return department.getName();
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
