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
        List<String> list = new ArrayList<>(); // 입력 받을 list
        Scanner sc = new Scanner(System.in);
        int control = 0;

        // list에 값 입력
        list.add("a");
        list.add("e");
        list.add("e");
        list.add("i");
        list.add("o");
        list.add("o");
        list.add("u");
        list.add("i");
        list.add("z");

        // ArrayList 방법과 HashSet 방법 중 어느 것을 선택할지 
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

    // ArrayList를 이용한 중복제거
    public static void ArrList(List<String> list) {
        List<String> arrayList = new ArrayList<>();

        for (String data : list) {
            if (!arrayList.contains(data)) // ArrayList에 포함되어 있지 않으면 data 추가
                arrayList.add(data);
        }

        System.out.println("ArrayList result : " + arrayList+"\n");
    }

    // Set을 이용한 중복제거
    public static void HashSet(List<String> list) {
        HashSet<String> hashSet = new HashSet<>();

        for (String data : list) {
            hashSet.add(data); // Set은 중복값이 없기 때문에 바로 입력
        }
        System.out.println("HashSet result : " + hashSet+"\n");
    }
}
