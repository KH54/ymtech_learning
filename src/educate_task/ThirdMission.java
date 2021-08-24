package educate_task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author "KyungHun Park"
 * @since 2021. 8. 23.
 *
 *        List�� Array�� Array�� List�� ��ȯ�ϴ� class
 */
public class ThirdMission {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
        String[] array = { "1", "2", "3" };

        // ó�� ��
        System.out.println(list);
        System.out.println(Arrays.toString(array) + "\n");

        // �ٲ� ��
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
     * @param array ������ array
     * @param list  array�� ���� list
     * 
     * @return ������ list ��ȯ
     * 
     *         array�� list�� ����
     */
    public static List<String> arrayToList(String[] array, List<String> list) {
        list = Arrays.asList(array); // Array API�� �̿��� ��ȯ

        /*
         * for(String change : array) { list.add(change); } // for���� �̿��� ��ȯ
         */
        return list;
    }

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 8. 23.
     *
     * @param list  ������ list
     * @param array list�� ���� array
     * 
     * @return ������ array ��ȯ
     * 
     *         list�� array�� ����
     */
    public static String[] listToArray(List<String> list, String[] array) {
        array = list.toArray(new String[list.size()]); // List API�� �̿��� ��ȯ

        /*
         * int order =0; for(String change : list) { array[order++] += change; } // for���� �̿��� ��ȯ
         */
        return array;
    }
}