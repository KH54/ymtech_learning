/**
 * Old Model�� field�� ������ New Model
 * 
 * @author "KyungHun Park"
 * @since 2021. 9. 6.
 *
 */
public class NewModel {

    // field ���� ����
    private int people;
    private String driver;
    private double gasMileage;
    private boolean power;
    private String[] peopleName;

    // field �ʱ�ȭ
    public NewModel() {
        this.people = 1;
        this.driver = "����";
        this.gasMileage = 15.5;
        this.power = false;
        this.peopleName = new String[] { "����" };
    }

    // getter, setter
    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public double getGasMileage() {
        return gasMileage;
    }

    public void setGasMileage(double gasMileage) {
        this.gasMileage = gasMileage;
    }

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    public String[] getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String[] arr) {
        this.peopleName = arr;
    }

}
