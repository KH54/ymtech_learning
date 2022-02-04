import java.util.Arrays;

/**
 * Old Model�� field�� ������ New Model
 * 
 * @author "KyungHun Park"
 * @since 2021. 9. 6.
 *
 */
public class NewModel {

    // field ���� ����
    private int headCount; // �����̸� ����
    private String driver;
    private double gasMileage;
    private boolean power;
    private String[] peopleName;

    // �⺻ ������
    public NewModel() {

    }
    
    // om�� �ʵ带 �Է��ϴ� ������
    public NewModel(OldModel om) {
        this.headCount = om.getHeadCount();
        this.driver = om.getDriver();
        this.gasMileage = om.getGasMileage();
        this.power = om.isPower();
        this.peopleName = om.getPeopleName();
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
    public void setPeopleName(String[] arr) {
        this.peopleName = arr; 
    }
 
    // ��� field�� ���
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("NewModel [people=");
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
