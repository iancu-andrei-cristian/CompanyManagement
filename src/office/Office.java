package office;

public class Office {
    String name;
    String address;
    int employeesCapacity;
    int employeesCurrentlyWorking;

    public Office(String name, String address, int employeesCapacity) {
        this.name = name;
        this.address = address;
        this.employeesCapacity = employeesCapacity;
        employeesCurrentlyWorking = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEmployeesCapacity() {
        return employeesCapacity;
    }

    public void setEmployeesCapacity(int employeesCapacity) {
        this.employeesCapacity = employeesCapacity;
    }

    public int getEmployeesCurrentlyWorking() {
        return employeesCurrentlyWorking;
    }

    public void increaseEmployeesCurrentlyWorking(int employeesCurrentlyWorking) {
        this.employeesCurrentlyWorking += employeesCurrentlyWorking;
    }
}
