/**
 * New Model과 field가 동일한 Old Model
 * 
 * @author "KyungHun Park"
 * @since 2021. 9. 6.
 *
 */
public class OldModel {

    // field 변수 선언
    private int people;
    private String driver;
    private double gasMileage;
    private boolean power;
    private String[] peopleName;

    // field 초기화
    public OldModel() {
        people = 2;
        driver = "경훈";
        gasMileage = 10.0;
        power = true;
        peopleName = new String[] { "경훈", "영훈" };
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

    public void setPeopleName(String[] peopleName) {
        this.peopleName = peopleName;
    }

}
