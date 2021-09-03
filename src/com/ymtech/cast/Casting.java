package com.ymtech.cast;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author "KyungHun Park"
 * @since 2021. 9. 3.
 *
 *        List�� Array�� Array�� List�� ��ȯ�ϴ� class
 */
public class Casting {
    public static void main(String[] args) {
        
        // ��ȯ�� list, array ����
        List<String> list = Arrays.asList("a", "b", "c");
        String[] array = { "1", "2", "3" };

        // ó�� ��
        System.out.println(list);
        System.out.printf("%s \n\n",Arrays.toString(array));

        // �ٲ� ��
        System.out.println(changeArr(array, list));
        System.out.printf("%s \n\n",Arrays.toString(changeList(list, array)));
        
        
    }
    
    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 3.
     *
     * @param array ������ array
     * @param ltis  array�� ���� list
     * 
     * @return ������ list ��ȯ
     * 
     *         array�� list�� ����
     */
    public static List<String> changeArr(String[] array, List<String> list) {
        list = Arrays.asList(array); // Arrays Ŭ������ asList �޼ҵ带 �̿��� ��ȯ

        /*
         * for(String change : array) 
         * { list.add(change); } 
         *  �ݺ����� �̿��� ��ȯ
         */
        return list;
    }

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 3.
     *
     * @param list  ������ list
     * @param array list�� ���� array
     * 
     * @return ������ array ��ȯ
     * 
     *         list�� array�� ����
     */
    public static String[] changeList(List<String> list, String[] array) {
        array = list.toArray(new String[list.size()]); // toArray �޼ҵ带 �̿��� ��ȯ

        /*
         * int order =0; 
         * for(String change : list) 
         * { array[order++] += change; } 
         *  �ݺ����� �̿��� ��ȯ
         */
        return array;
    }
}