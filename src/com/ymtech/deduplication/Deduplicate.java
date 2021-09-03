package com.ymtech.deduplication;

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
 * @since 2021. 9. 3.
 * 
 *        ArrayList와 HashSet으로 list의 중복을 제거하는 class
 */
public class Deduplicate {

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 3.
     *
     *        중복제거 할 방법을 하는 main 메소드
     */
    public static void main(String[] args) {

        // log 출력을 위한 logger 생성
        Logger logger = Logger.getLogger(Deduplicate.class);

        // 중복이 존재하는 list 생성
        List<String> list = Arrays.asList("a", "e", "i", "i", "o", "u", "a", "e");

        // 중복 제거 방법을 입력받기 위한 Scanner 클래스
        Scanner controlDup = new Scanner(System.in);

        int control = 0; // 입력받은 controlDup을 저장하기 위한 변수

        // ArrayList 방법과 HashSet 방법 중 선택
        while (control != 4) {
            System.out.println("중복 제거할 방법을 선택하세요");
            System.out.println("1. ArrayList 2. HashSet 3. Stream 4. quit");

            try {
                control = controlDup.nextInt(); // 사용자에게 입력받은 값을 저장

            } catch (InputMismatchException ie) { // int형 타입이 아닌 값이 입력되었을 때 로그 출력 후 재입력 요청
                logger.info(ie + "\n숫자만 입력하세요");
                controlDup.nextLine(); // 입력받은 값을 초기화
                continue; // 재입력 요청

            } catch (Exception e) { // 이슈로 인한 예외 발생시 로그를 출력한 뒤 종료
                logger.error(e + "\nSystem exit");
                controlDup.close(); // scanner 종료
                System.exit(0); // 시스템 종료
            }

            // switch case를 이용하여 입력받은 값에 따라 해당하는 메소드 호출
            switch (control) {

            case 1: // ArrayList를 사용한 방법
                useArrList(list);
                break;

            case 2: // HashSet을 사용한 방법
                useHashSet(list);
                break;

            case 3: // Stream을 사용한 방법
                useStream(list);
                break;

            case 4: // 시스템 종료
                System.out.println("System exit");
                controlDup.close(); // scanner 종료
                System.exit(0);

            default: // 1~4의 숫자가 아닌 다른 숫자를 입력한 경우
                System.out.println("선택지에 있는 숫자만 입력하세요");
            }
        }

    }

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 3.
     *
     * @param list
     * 
     *             ArrayList를 이용한 중복제거
     */
    public static void useArrList(List<String> list) {
        // 중복을 제거한 list를 담을 list 생성
        List<String> arrayList = new ArrayList<>();

        // for each를 사용하여 list의 요소를 data에 입력
        for (String data : list) {
            if (!arrayList.contains(data)) { // Contains로 입력하려는 값이 있는지 확인 후 list에 추가
                arrayList.add(data);
            }
        }

        // 중복을 제거한 뒤 리스트 출력
        System.out.printf("ArrayList result : %s \n", arrayList);
    }

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 3.
     *
     * @param list
     * 
     *             Set을 이용한 중복 제거
     */
    public static void useHashSet(List<String> list) {
        // 중복을 제거한 Set을 담을 Set 생성
        HashSet<String> hashSet = new HashSet<>();

        // for each를 사용하여 list의 요소를 data에 입력
        for (String data : list) {
            hashSet.add(data); // Set은 중복을 허용하지 않기 때문에 순서대로 입력
        }

        // 중복을 제거한 뒤 Set 출력
        System.out.printf("HashSet result : %s \n", hashSet);
    }

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 3.
     *
     * @param list
     * 
     *             Stream을 이용한 중복 제거
     */
    public static void useStream(List<String> list) {
        // Stream의 distinct를 사용한 중복제거
        list.stream().distinct().forEach(System.out::print);
    }
}