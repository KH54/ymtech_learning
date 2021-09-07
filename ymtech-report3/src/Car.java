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
        NewModel nm = new NewModel();

        // Old Model�� �ʵ� ���
        System.out.println(om.toString());

        // New Model�� �ʵ� ���
        System.out.println(nm.toString());

        // Old Model�� New Model ��ȯ
        OldModel castOm = new OldModel(nm);
        NewModel castNm = new NewModel(om);
        // ��ȯ�� om ���
        System.out.println(castOm.toString());
        System.out.println(castNm.toString());
    }

}