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
    * list�� �ߺ� ���� �Է�
    */
    public static List<String> addList(){
        List<String> list = Arrays.asList("a","o","e","i","o","u","a","e"); // �Է� ���� list
        
        
        return list; 
    }
    
    public static void main(String[] args) {
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

                if (control > 3) {
                    System.out.println("�������� �ִ� ���ڸ� �Է��ϼ���");
                    continue;
                } else if (control == 3) {
                    System.out.println("�ý����� �����մϴ�.");
                    break;
                }

            } catch (InputMismatchException ie) { // int�� Ÿ���� �ƴ� ���� �ԷµǾ��� ��
                System.out.println("���ڸ� �Է����ּ���");
                scControl.nextLine(); // �Է¹��� ���� �ʱ�ȭ
                logger.info(ie);

            } catch (Exception e) {
                logger.error(e.getMessage());
            }

            switch (control) {
            case 1:
                arrList(list);
                break;
            case 2:
                hashSet(list);
                break;
            }
        }

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
    public static void arrList(List<String> list) {
        List<String> arrayList = new ArrayList<>();

        for (String data : list) {
            if (!arrayList.contains(data)) // ArrayList�� ���ԵǾ� ���� ������ data �߰�
                arrayList.add(data);
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
    public static void hashSet(List<String> list) {
        HashSet<String> hashSet = new HashSet<>();

        for (String data : list) {
            hashSet.add(data); // Set�� �ߺ����� ���� ������ �ٷ� �Է�
        }
        System.out.println("HashSet result : " + hashSet + "\n");
    }
}
