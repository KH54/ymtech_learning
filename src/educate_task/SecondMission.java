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
 *        ArrayList와 HashSet으로 list의 중복을 제거하는 class
 */
public class SecondMission {
    private static Logger logger = Logger.getLogger(SecondMission.class);

   /**
    * 
    * @author "KyungHun Park"
    * @since 2021. 8. 23.
    *
    * @return 입력된 값을 반환 
    * 
    * list에 중복 값을 입력
    */
    public static List<String> addList(){
        List<String> list = Arrays.asList("a","o","e","i","o","u","a","e"); // 입력 받을 list
        
        
        return list; 
    }
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(); // 입력 받을 list
        Scanner scControl = new Scanner(System.in); //
        int control = 0;
        
        list = addList(); // 중복된 값 입력

        // ArrayList 방법과 HashSet 방법 중 선택
        while (true) {
            try {
                System.out.println("중복 제거할 방법을 선택하세요");
                System.out.println("1. ArrayList 2. HashSet 3. quit");
                control = scControl.nextInt();

                if (control > 3) {
                    System.out.println("선택지에 있는 숫자만 입력하세요");
                    continue;
                } else if (control == 3) {
                    System.out.println("시스템을 종료합니다.");
                    break;
                }

            } catch (InputMismatchException ie) { // int형 타입이 아닌 값이 입력되었을 때
                System.out.println("숫자를 입력해주세요");
                scControl.nextLine(); // 입력받은 값을 초기화
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
     *             ArrayList를 이용한 중복제거
     */
    public static void arrList(List<String> list) {
        List<String> arrayList = new ArrayList<>();

        for (String data : list) {
            if (!arrayList.contains(data)) // ArrayList에 포함되어 있지 않으면 data 추가
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
     *             Set을 이용한 중복 제거
     */
    public static void hashSet(List<String> list) {
        HashSet<String> hashSet = new HashSet<>();

        for (String data : list) {
            hashSet.add(data); // Set은 중복값이 없기 때문에 바로 입력
        }
        System.out.println("HashSet result : " + hashSet + "\n");
    }
}
