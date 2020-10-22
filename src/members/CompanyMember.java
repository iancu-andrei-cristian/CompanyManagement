package members;

public abstract class CompanyMember {
    protected String firstName;
    protected String lastName;
    protected String socialSecurityNumber;

    public CompanyMember(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public abstract String getPositionTitle();

    public abstract String getWorkingOffice();
}
