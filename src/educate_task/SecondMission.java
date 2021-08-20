package educate_task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author "KyungHun Park"
 * @since 2021. 8. 20.
 *
 */
public class SecondMission {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(); // �Է� ���� list
        Scanner sc = new Scanner(System.in);
        int control = 0;

        // list�� �� �Է�
        list.add("a");
        list.add("e");
        list.add("e");
        list.add("i");
        list.add("o");
        list.add("o");
        list.add("u");
        list.add("i");
        list.add("z");

        // ArrayList ����� HashSet ��� �� ��� ���� �������� 
        while (control != 3) {
            
            System.out.println("Choose method for deduplication");
            System.out.println("1. ArrayList 2. HashSet 3. quit");
            control = sc.nextInt();
            
            switch (control) {
            case 1:
                ArrList(list);
                break;
            case 2:
                HashSet(list);
                break;
            }
        }

    }

    // ArrayList�� �̿��� �ߺ�����
    public static void ArrList(List<String> list) {
        List<String> arrayList = new ArrayList<>();

        for (String data : list) {
            if (!arrayList.contains(data)) // ArrayList�� ���ԵǾ� ���� ������ data �߰�
                arrayList.add(data);
        }

        System.out.println("ArrayList result : " + arrayList+"\n");
    }

    // Set�� �̿��� �ߺ�����
    public static void HashSet(List<String> list) {
        HashSet<String> hashSet = new HashSet<>();

        for (String data : list) {
            hashSet.add(data); // Set�� �ߺ����� ���� ������ �ٷ� �Է�
        }
        System.out.println("HashSet result : " + hashSet+"\n");
    }
}
