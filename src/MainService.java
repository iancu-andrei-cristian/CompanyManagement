import office.JobTitle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class MainService {

    private static void displayMenu() {
        System.out.println("Select command:");
        System.out.println("0. This menu");
        System.out.println("1. Add department");
        System.out.println("2. Add office");
        System.out.println("3. Add employee");
        System.out.println("4. Add manager");
        System.out.println("5. Add share holder");
        System.out.println("6. View all departments");
        System.out.println("7. View all offices");
        System.out.println("8. View all share holders");
        System.out.println("9. Filter employees by job title");
        System.out.println("10. Filter employees by office");
        System.out.println("11. Filter employees by department");
        System.out.println("12. Get full salary report");
    }

    public static void main(String[] args) {
        CompanyAdministrationService service = CompanyAdministrationService.getInstance();

        displayMenu();
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command number:");
            int command = in.nextInt();
            switch (command) {
                case 0: {
                    displayMenu();
                    break;
                }
                case 1: {
                    System.out.println("Write department name:");
                    String department = in.nextLine();
                    service.addDepartment(department);
                    break;
                }
                case 2: {
                    System.out.println("Write office name, address on one row, separated by ;, and capacity on the next line:");
                    String office = in.nextLine();
                    int capacity = in.nextInt();
                    String[] parts = office.split(";");
                    service.addOffice(parts[0], parts[1], capacity);
                    break;
                }
                case 3: {
                    System.out.println("Write first name, last name, social security number, separated by ; on one line");
                    String basicInfo = in.nextLine();
                    String basic[] = basicInfo.split(";");
                    System.out.println("Write base salary, working hours, extra hours payment, vacation days per year");
                    double baseSalary = in.nextDouble();
                    int workingHours = in.nextInt();
                    int extraHours = in.nextInt();
                    int vacationDays = in.nextInt();
                    System.out.println("Write office name");
                    String officeName = in.nextLine();
                    System.out.println("Write hired date");
                    String date = in.nextLine();
                    LocalDate hiredDate = LocalDate.parse(date);
                    System.out.println("Write department");
                    String departmentName = in.nextLine();
                    System.out.println("Select job title:");
                    service.getAllJobs();
                    String jobName = in.nextLine();
                    service.addEmployee(basic[0], basic[1], basic[2], baseSalary, workingHours, extraHours,
                            vacationDays, officeName, hiredDate, departmentName, JobTitle.valueOf(jobName));
                    break;
                }
                case 4: {
                    System.out.println("Write first name, last name, social security number, separated by ; on one line");
                    String basicInfo = in.nextLine();
                    String basic[] = basicInfo.split(";");
                    System.out.println("Write base salary, working hours, extra hours payment, vacation days per year");
                    double baseSalary = in.nextDouble();
                    int workingHours = in.nextInt();
                    int extraHours = in.nextInt();
                    int vacationDays = in.nextInt();
                    System.out.println("Write office name");
                    String officeName = in.nextLine();
                    System.out.println("Write hired date");
                    String date = in.nextLine();
                    LocalDate hiredDate = LocalDate.parse(date);
                    System.out.println("Write department");
                    String departmentName = in.nextLine();
                    service.addManager(basic[0], basic[1], basic[2], baseSalary, workingHours, extraHours,
                            vacationDays, officeName, hiredDate, departmentName);
                    break;
                }
                case 5: {
                    System.out.println("Write first name, last name, social security number, separated by ; on one line");
                    String basicInfo = in.nextLine();
                    String basic[] = basicInfo.split(";");
                    System.out.println("Write owned percentage:");
                    double owned = in.nextDouble();
                    service.addShareHolder(basic[0], basic[1], basic[2], owned);
                    break;
                }
                case 6: {
                    service.getDepartments();
                    break;
                }
                case 7: {
                    service.getOffices();
                    break;
                }
                case 8: {
                    service.getShareHolders();
                    break;
                }
                case 9: {
                    System.out.println("Write job title to filter by:");
                    String jobTitle = in.nextLine();
                    service.getPeopleWithJob(jobTitle);
                    break;
                }
                case 10: {
                    System.out.println("Write office to filter by:");
                   String officeName = in.nextLine();
                    service.getOfficeMembers(officeName);
                    break;
                }
                case 11: {
                    System.out.println("Write department to filter by:");
                    String departmentName = in.nextLine();
                    service.getDepartmentMembers(departmentName);
                    break;
                }
                case 12: {
                    service.getCurrentMonthSalaryReport();
                    break;
                }
            }
        }

    }
}
