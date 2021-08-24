package educate_task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author "KyungHun Park"
 * @since 2021. 8. 23.
 *
 *        List를 Array로 Array를 List로 변환하는 class
 */
public class ThirdMission {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
        String[] array = { "1", "2", "3" };

        // 처음 값
        System.out.println(list);
        System.out.println(Arrays.toString(array) + "\n");

        // 바뀐 값
        System.out.println(arrayToList(array, list));
        System.out.println(Arrays.toString(listToArray(list, array)) + "\n");
        
        System.out.println(list);
        System.out.println(Arrays.toString(array) + "\n");


        list = arrayToList(array, list);
        array = listToArray(list, array);
    }
    
    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 8. 23.
     *
     * @param array 변경할 array
     * @param list  array를 담을 list
     * 
     * @return 변경한 list 반환
     * 
     *         array를 list로 변경
     */
    public static List<String> arrayToList(String[] array, List<String> list) {
        list = Arrays.asList(array); // Array API를 이용한 변환

        /*
         * for(String change : array) { list.add(change); } // for문을 이용한 변환
         */
        return list;
    }

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 8. 23.
     *
     * @param list  변경할 list
     * @param array list를 담을 array
     * 
     * @return 변경한 array 반환
     * 
     *         list를 array로 변경
     */
    public static String[] listToArray(List<String> list, String[] array) {
        array = list.toArray(new String[list.size()]); // List API를 이용한 변환

        /*
         * int order =0; for(String change : list) { array[order++] += change; } // for문을 이용한 변환
         */
        return array;
    }
}