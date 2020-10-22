import members.Employee;
import members.Manager;
import members.ShareHolder;
import office.Department;
import office.JobTitle;
import office.Office;
//import org.jetbrains.annotations.Contract;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class CompanyAdministrationService {

    private List<Employee> employees;
    private List<ShareHolder> shareHolders;
    private List<Department> departments;
    private List<Office> offices;
    private double ownedPercentage = 0;

    private static final CompanyAdministrationService companyAdministrationService = new CompanyAdministrationService();

    private CompanyAdministrationService() {
    }

    //@Contract(pure = true)
    public static CompanyAdministrationService getInstance() {
        return companyAdministrationService;
    }

    public void addEmployee(String firstName, String lastName, String socialSecurityNumber, double monthlyWage,
                            int workingHours, double extraHourPayment, int vacationDaysPerYear, String workingOffice,
                            LocalDate hiredDate, String department, JobTitle jobTitle) {
        int depIndex = searchDepartment(department);
        if (depIndex == -1) {
            System.out.println("No such department!");
            return;
        }
        int offIndex = searchOffice(workingOffice);
        if (offIndex == -1) {
            System.out.println("No such office!");
            return;
        }
        employees.add(new Employee(firstName, lastName, socialSecurityNumber, monthlyWage,
                workingHours, extraHourPayment, vacationDaysPerYear, offices.get(offIndex),
                hiredDate, departments.get(depIndex), jobTitle));

        offices.get(offIndex).increaseEmployeesCurrentlyWorking(1);
    }

    public void addManager(String firstName, String lastName, String socialSecurityNumber, double monthlyWage,
                           int workingHours, double extraHourPayment, int vacationDaysPerYear, String workingOffice,
                           LocalDate hiredDate, String department) {

        int depIndex = searchDepartment(department);
        if (depIndex == -1) {
            System.out.println("No such department!");
            return;
        }

        int offIndex = searchOffice(workingOffice);
        if (offIndex == -1) {
            System.out.println("No such office!");
            return;
        }
        Manager newManager = new Manager(firstName, lastName, socialSecurityNumber, monthlyWage,
                workingHours, extraHourPayment, vacationDaysPerYear, offices.get(offIndex),
                hiredDate, departments.get(depIndex));

        departments.get(depIndex).setManager(newManager);
        employees.add(newManager);
    }

    public void addShareHolder(String firstName, String lastName, String socialSecurityNumber, double ownedPercentage) {
        if (this.ownedPercentage + ownedPercentage <= 100) {
            shareHolders.add(new ShareHolder(firstName, lastName, socialSecurityNumber, ownedPercentage));
        } else
            System.out.println("No such resource available for sale!");
    }

    public void addOffice(String name, String address, int employeesCapacity) {
        if (searchOffice(name) == -1)
            offices.add(new Office(name, address, employeesCapacity));
        else
            System.out.println("Office already exists!");
    }

    public void addDepartment(String name) {
        if (searchDepartment(name) == -1) {
            departments.add(new Department(name));
        }
        else
            System.out.println("Department already exists!");
    }

    public void getShareHolders() {
        for (ShareHolder item : shareHolders) {
            System.out.println(item.getFirstName() + " " + item.getLastName() + " owns: " + item.getOwnedPercentage() + "%");
        }
    }

    public void getDepartments() {
        for (Department item : departments) {
            System.out.println(item.getName() + " has " + item.getNumberOfEmployees() + " and is managed by: " + item.getManager());
        }
    }

    public void getOffices() {
        for (Office item : offices) {
            System.out.println(item.getName() + " has a capacity of " + item.getEmployeesCapacity());
        }
    }

    public void getDepartmentMembers(String departmentName) {
        int index = searchDepartment(departmentName);
        if (index == -1) {
            System.out.println("No such department!");
            return;
        }
        System.out.println("Members of " + departmentName + ":");
        for (Employee employee : employees) {
            if (employee.getDepartment().equals(departmentName))
                System.out.println(employee.getFirstName() + " " + employee.getLastName() + " " + employee.getPositionTitle());
        }


    }

    public void getOfficeMembers(String officeName) {
        int index = searchOffice(officeName);
        if (index == -1) {
            System.out.println("No such office!");
            return;
        }
        System.out.println("Members of " + officeName + ":");
        for (Employee employee : employees) {
            if (employee.getWorkingOffice().equals(officeName))
                System.out.println(employee.getFirstName() + " " + employee.getLastName() + " " + employee.getPositionTitle());
        }


    }

    public int getPeopleWithJob(String jobName) {
        int numberOfPeople = 0;
        if (jobName.toLowerCase().equals("manager")) {
            for (Employee employee : employees)
                if (employee.getClass() == Manager.class) {
                    System.out.println(employee.getFirstName() + " " + employee.getLastName());
                    numberOfPeople++;
                }
        } else {
            for (Employee employee : employees)
                if (employee.getPositionTitle().equals(jobName)) {
                    System.out.println(employee.getFirstName() + " " + employee.getLastName());
                    numberOfPeople++;
                }
        }

        return numberOfPeople;
    }

    public void getCurrentMonthSalaryReport() {
        for (Employee employee: employees){
                System.out.println(employee.getFirstName() + " " + employee.getLastName() + " "
                + employee.getDepartment()+ " " + employee.getPositionTitle()+ " " + employee.getSalaryForCurrentMonth());
        }
    }

    public void getAllJobs(){
        System.out.println("Id: " + JobTitle.Accountant.ordinal() + " name: " + JobTitle.Accountant.name());
        System.out.println("Id: " + JobTitle.ContentCreator.ordinal() + " name: " + JobTitle.ContentCreator.name());
        System.out.println("Id: " + JobTitle.Designer.ordinal() + " name: " + JobTitle.Designer.name());
        System.out.println("Id: " + JobTitle.Engineer.ordinal() + " name: " + JobTitle.Engineer.name());
        System.out.println("Id: " + JobTitle.Programmer.ordinal() + " name: " + JobTitle.Programmer.name());
        System.out.println("Id: " + JobTitle.Recruiter.ordinal() + " name: " + JobTitle.Recruiter.name());
        System.out.println("Id: " + JobTitle.Researcher.ordinal() + " name: " + JobTitle.Researcher.name());
        System.out.println("Id: " + JobTitle.Trainee.ordinal() + " name: " + JobTitle.Trainee.name());
        System.out.println("Id: " + JobTitle.Worker.ordinal() + " name: " + JobTitle.Worker.name());
    }

    private int searchDepartment(String department) {
        for (int i = 0; i < departments.size(); i++) {
            if (department.equals(departments.get(i).getName()))
                return i;
        }
        return -1;
    }

    private int searchOffice(String office) {
        for (int i = 0; i < offices.size(); i++) {
            if (office.equals(offices.get(i).getName()))
                return i;
        }
        return -1;
    }

    public void showDepartments()
    {
        for(Department item: departments)
        {
            System.out.println(item.getName());
        }
    }
}
