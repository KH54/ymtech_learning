import java.util.Arrays;
/**
 * Old Model�� New Model�� ��ȯ �� ���
 * 
 * @author "KyungHun Park"
 * @since 2021. 9. 6.
 *
 */
public class Car {
    public static void main(String[] args) {

        // model ��ü ����
        OldModel om = new OldModel();
        NewModel no = new NewModel();

        // Old Model�� �ʵ� ���
        System.out.printf("Old Model : %d, %s, %.1f, %b, %s \n", 
                om.getPeople(), om.getDriver(), om.getGasMileage(), om.isPower(), Arrays.toString(om.getPeopleName()));

        // New Model�� �ʵ� ���
        System.out.printf("New Model : %d, %s, %.1f, %b, %s \n", 
                no.getPeople(), no.getDriver(), no.getGasMileage(), no.isPower(), Arrays.toString(no.getPeopleName()));

        // Old Model�� New Model ��ȯ
        om.setPeople(no.getPeople());
        om.setGasMileage(no.getGasMileage());
        om.setPeopleName(no.getPeopleName());

        // ��ȯ�� om ���
        System.out.printf("Old Model : %d, %s, %.1f, %b, %s \n", 
                om.getPeople(), om.getDriver(), om.getGasMileage(), om.isPower(), Arrays.toString(om.getPeopleName()));
    }

}
