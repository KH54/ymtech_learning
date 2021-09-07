import java.util.Arrays;

/**
 * New Model과 field가 동일한 Old Model
 * 
 * @author "KyungHun Park"
 * @since 2021. 9. 6.
 *
 */
public class OldModel {

    // field 변수 선언
    private int headCount;
    private String driver;
    private double gasMileage;
    private boolean power;
    private String[] peopleName;

    // 기본 생성자
    public OldModel() {

    }
    
    // nm의 필드를 입력하는 생성자
    public OldModel(NewModel nm) {
        this.headCount = nm.getHeadCount();
        this.driver = nm.getDriver();
        this.gasMileage = nm.getGasMileage();
        this.power = nm.isPower();
        this.peopleName = nm.getPeopleName();
    }

    // 사람의 수를 get
    public int getHeadCount() {
        return headCount;
    }
    // 사람의 수를 set
    public void setHeadCount(int people) {
        this.headCount = people;
    }
    
    // 드라이버의 이름을 get
    public String getDriver() {
        return driver;
    }
    // 드라이버의 이름을 set
    public void setDriver(String driver) {
        this.driver = driver;
    }
    
    // 연비를 get
    public double getGasMileage() {
        return gasMileage;
    }
    // 연비를 set
    public void setGasMileage(double gasMileage) {
        this.gasMileage = gasMileage;
    }
    
    // 시동 상태를 get
    public boolean isPower() {
        return power;
    }
    // 시동 상태를 set
    public void setPower(boolean power) {
        this.power = power;
    }
    
    // 탑승한 사람의 이름을 get
    public String[] getPeopleName() {
        return peopleName;
    }
    // 탑승한 사람의 이름을 set
    public void setPeopleName(String[] peopleName) {
        this.peopleName = peopleName;
    }

    // 모든 field를 출력
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
