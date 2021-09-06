import java.util.Arrays;
/**
 * Old Model을 New Model로 변환 후 출력
 * 
 * @author "KyungHun Park"
 * @since 2021. 9. 6.
 *
 */
public class Car {
    public static void main(String[] args) {

        // model 객체 생성
        OldModel om = new OldModel();
        NewModel no = new NewModel();

        // Old Model의 필드 출력
        System.out.printf("Old Model : %d, %s, %.1f, %b, %s \n", 
                om.getPeople(), om.getDriver(), om.getGasMileage(), om.isPower(), Arrays.toString(om.getPeopleName()));

        // New Model의 필드 출력
        System.out.printf("New Model : %d, %s, %.1f, %b, %s \n", 
                no.getPeople(), no.getDriver(), no.getGasMileage(), no.isPower(), Arrays.toString(no.getPeopleName()));

        // Old Model에 New Model 변환
        om.setPeople(no.getPeople());
        om.setGasMileage(no.getGasMileage());
        om.setPeopleName(no.getPeopleName());

        // 변환한 om 출력
        System.out.printf("Old Model : %d, %s, %.1f, %b, %s \n", 
                om.getPeople(), om.getDriver(), om.getGasMileage(), om.isPower(), Arrays.toString(om.getPeopleName()));
    }

}
