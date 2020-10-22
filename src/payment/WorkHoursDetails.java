package payment;

import java.time.LocalDate;

public class WorkHoursDetails {
    private int workingHours;
    private double extraHourPayment;
    private int vacationDaysPerYear;
    private int vacationDaysAvailable;
    private int extraHoursPerMonth[];

    public WorkHoursDetails(int workingHours, double extraHourPayment, int vacationDaysPerYear) {
        this.workingHours = workingHours;
        this.extraHourPayment = extraHourPayment;
        this.vacationDaysPerYear = vacationDaysPerYear;
        this.vacationDaysAvailable = vacationDaysPerYear;
        extraHoursPerMonth = new int[12];
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public double getExtraHourPayment() {
        return extraHourPayment;
    }

    public void setExtraHourPayment(double extraHourPayment) {
        this.extraHourPayment = extraHourPayment;
    }

    public int getVacationDaysPerYear() {
        return vacationDaysPerYear;
    }

    public void setVacationDaysPerYear(int vacationDaysPerYear) {
        this.vacationDaysPerYear = vacationDaysPerYear;
    }

    public int getVacationDaysAvailable() {
        return vacationDaysAvailable;
    }

    public void setVacationDaysAvailable(int vacationDaysAvailable) {
        this.vacationDaysAvailable = vacationDaysAvailable;
    }

    public void useVacationDays(int vacationDays) {
        vacationDaysAvailable -= vacationDays;
    }

    public void yearlyReset() {
        vacationDaysAvailable = vacationDaysPerYear;
        extraHoursPerMonth = new int[12];
    }

    public void setExtraHoursPerMonth(int hours, int month)
    {
        extraHoursPerMonth[month] = hours;
    }

    public int getExtraHoursForCurrentMonth()
    {
        return extraHoursPerMonth[LocalDate.now().getMonthValue()];
    }
}
