package office;

import members.Manager;

public class Department {
    String name;
    int numberOfEmployees;
    Manager manager;

    public Department(String name)
    {
        this.name = name;
        numberOfEmployees = 0;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getManager() {
        return manager.getFirstName() + " " + manager.getLastName();
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
