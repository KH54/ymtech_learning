package com.ymtech.cast;

import java.util.Arrays;
import java.util.List;

/**
 * List를 Array로 Array를 List로 변환하는 class
 * 
 * @author "KyungHun Park"
 * @since 2021. 9. 3.
 *
 */
public class Casting {
    public static void main(String[] args) {

        // 변환할 list, array 생성
        List<String> list = Arrays.asList("a", "b", "c");
        String[] array = { "1", "2", "3" };
        // 처음 값
        System.out.println(list);
        System.out.printf("%s \n\n", Arrays.toString(array));
        // 바뀐 값
        System.out.println(changeArr(array, list));
        System.out.printf("%s \n\n", Arrays.toString(changeList(list, array)));

    }

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 3.
     *
     * @param array 변경할 array*
     * @param ltis  array를 담을 list
     * @return 변경한 list 반환
     **/

    public static List<String> changeArr(String[] array, List<String> list) {
        list = Arrays.asList(array); // Arrays 클래스의 asList 메소드를 이용한 변환
        /*
         * for(String change : array) { list.add(change); } 반복문을 이용한 변환
         */
        return list;
    }

    /**
     * list를 array로 변경
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 3.
     *
     * @param list  변경할 list
     * @param array list를 담을 array
     * 
     * @return 변경한 array 반환
     * 
     */
    public static String[] changeList(List<String> list, String[] array) {
        array = list.toArray(new String[list.size()]); // toArray 메소드를 이용한 변환
        /*
         * int order =0; for(String change : list) { array[order++] += change; } 반복문을
         * 이용한 변환
         */
        return array;
    }
}