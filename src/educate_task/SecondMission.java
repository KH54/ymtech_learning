package educate_task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * 
 * @author "KyungHun Park"
 * @since 2021. 8. 23.
 * 
 *        ArrayList�� HashSet���� list�� �ߺ��� �����ϴ� class
 */
public class SecondMission {
    private static Logger logger = Logger.getLogger(SecondMission.class);

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 8. 23.
     *
     * @return �Էµ� ���� ��ȯ
     * 
     *         list�� �ߺ� ���� �Է�
     */
    public static List<String> addList() {
        List<String> list = Arrays.asList("a", "o", "e", "i", "o", "u", "a", "e"); // �Է� ���� list

        return list;
    }

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 8. 23.
     *
     * @param list
     * 
     *             ArrayList�� �̿��� �ߺ�����
     */
    public static void useArrList(List<String> list) {
        List<String> arrayList = new ArrayList<>();

        for (String data : list) {
            if (!arrayList.contains(data)) { // ArrayList�� ���ԵǾ� ���� ������ data �߰�
                arrayList.add(data);
            }
        }

        System.out.println("ArrayList result : " + arrayList + "\n");
    }

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 8. 23.
     *
     * @param list
     * 
     *             Set�� �̿��� �ߺ� ����
     */
    public static void useHashSet(List<String> list) {
        HashSet<String> hashSet = new HashSet<>();

        for (String data : list) {
            hashSet.add(data); // Set�� �ߺ����� ���� ������ �ٷ� �Է�
        }
        System.out.println("HashSet result : " + hashSet + "\n");
    }

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 8. 24.
     *
     *        �ߺ����� �� ����� ����
     */
    public static void main() {
        List<String> list = new ArrayList<>(); // �Է� ���� list
        Scanner scControl = new Scanner(System.in); //
        int control = 0;

        list = addList(); // �ߺ��� �� �Է�

        // ArrayList ����� HashSet ��� �� ����
        while (true) {
            try {
                System.out.println("�ߺ� ������ ����� �����ϼ���");
                System.out.println("1. ArrayList 2. HashSet 3. quit");
                control = scControl.nextInt();
            } catch (InputMismatchException ie) { // int�� Ÿ���� �ƴ� ���� �ԷµǾ��� ��
                scControl.nextLine(); // �Է¹��� ���� �ʱ�ȭ
                logger.info(ie + "\n���ڸ� �Է��ϼ���");
                continue;
            } catch (Exception e) {
                logger.error(e + "\nSystem exit");
                System.exit(0);
            }

            switch (control) {
            case 1:
                useArrList(list);
                break;
            case 2:
                useHashSet(list);
                break;
            case 3:
                System.out.println("System exit");
                System.exit(0);
            default:
                System.out.println("�������� �ִ� ���ڸ� �Է��ϼ���");
            }
        }

    }
}