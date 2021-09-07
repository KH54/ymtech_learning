import java.util.Arrays;

/**
 * New Model�� field�� ������ Old Model
 * 
 * @author "KyungHun Park"
 * @since 2021. 9. 6.
 *
 */
public class OldModel {

    // field ���� ����
    private int headCount;
    private String driver;
    private double gasMileage;
    private boolean power;
    private String[] peopleName;

    // �⺻ ������
    public OldModel() {

    }
    
    // nm�� �ʵ带 �Է��ϴ� ������
    public OldModel(NewModel nm) {
        this.headCount = nm.getHeadCount();
        this.driver = nm.getDriver();
        this.gasMileage = nm.getGasMileage();
        this.power = nm.isPower();
        this.peopleName = nm.getPeopleName();
    }

    // ����� ���� get
    public int getHeadCount() {
        return headCount;
    }
    // ����� ���� set
    public void setHeadCount(int people) {
        this.headCount = people;
    }
    
    // ����̹��� �̸��� get
    public String getDriver() {
        return driver;
    }
    // ����̹��� �̸��� set
    public void setDriver(String driver) {
        this.driver = driver;
    }
    
    // ���� get
    public double getGasMileage() {
        return gasMileage;
    }
    // ���� set
    public void setGasMileage(double gasMileage) {
        this.gasMileage = gasMileage;
    }
    
    // �õ� ���¸� get
    public boolean isPower() {
        return power;
    }
    // �õ� ���¸� set
    public void setPower(boolean power) {
        this.power = power;
    }
    
    // ž���� ����� �̸��� get
    public String[] getPeopleName() {
        return peopleName;
    }
    // ž���� ����� �̸��� set
    public void setPeopleName(String[] peopleName) {
        this.peopleName = peopleName;
    }

    // ��� field�� ���
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("OldModel [people=");
        builder.append(headCount);
        builder.append(", driver=");
        builder.append(driver);
        builder.append(", gasMileage=");
        builder.append(gasMileage);
        builder.append(", power=");
        builder.append(power);
        builder.append(", peopleName=");
        builder.append(Arrays.toString(peopleName));
        builder.append("]");
        return builder.toString();
    }

}
