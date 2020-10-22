package members;
import office.JobTitle;
import office.Office;
import office.Department;

import java.time.LocalDate;
import java.util.Date;

public class Manager extends Employee {

    public Manager(String firstName, String lastName, String socialSecurityNumber, double monthlyWage,
                   int workingHours, double extraHourPayment, int vacationDaysPerYear, Office workingOffice,
                   LocalDate hiredDate, Department department)  {
        super(firstName, lastName, socialSecurityNumber,  monthlyWage,
                workingHours, extraHourPayment,vacationDaysPerYear, workingOffice,
                hiredDate, department, JobTitle.Manager);
    }

    @Override
    public String getPositionTitle() {
        return this.department.getName() + " manager";
    }
}
