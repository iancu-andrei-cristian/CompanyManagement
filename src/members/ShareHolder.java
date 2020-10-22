package members;

public class ShareHolder extends CompanyMember {

    double ownedPercentage;

    public ShareHolder(String firstName, String lastName, String socialSecurityNumber, double ownedPercentage) {
        super(firstName, lastName, socialSecurityNumber);
        this.ownedPercentage = ownedPercentage;
    }

    @Override
    public String getPositionTitle() {
        return "Shareholder";
    }

    @Override
    public String getWorkingOffice() {
        return "This user is a shareholder, he/she does not work in an office";
    }

    public double getOwnedPercentage() {
        return ownedPercentage;
    }

    public void setOwnedPercentage(double ownedPercentage) {
        this.ownedPercentage = ownedPercentage;
    }
}
