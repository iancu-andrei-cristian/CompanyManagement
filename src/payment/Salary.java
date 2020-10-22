package payment;

public class Salary {
    private double baseSalary;
    private WorkHoursDetails workHoursDetails;

    public Salary(double baseSalary, int workingHours, double extraHourPayment, int vacationDaysPerYear) {
        this.baseSalary = baseSalary;
        workHoursDetails = new WorkHoursDetails(workingHours, extraHourPayment, vacationDaysPerYear);
    }

    public double getSalaryForCurrentMonth()
    {
        return baseSalary + workHoursDetails.getExtraHourPayment() * workHoursDetails.getExtraHoursForCurrentMonth();
    }

    public void setExtraHourPayment(double extraHourPayment)
    {
        workHoursDetails.setExtraHourPayment(extraHourPayment);
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void useVacationDays(int usedDays)
    {
        workHoursDetails.useVacationDays(usedDays);
    }

    public void setExtraHoursPerMonth(int hours, int month)
    {
        workHoursDetails.setExtraHoursPerMonth(hours, month);
    }

    public void yearlyReset()
    {
        workHoursDetails.yearlyReset();
    }


}
