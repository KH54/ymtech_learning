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
 *        ArrayList�� HashSet���� list�� �ߺ��� �����ϴ� class
 */
public class Deduplicate {

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 3.
     *
     *        �ߺ����� �� ����� �ϴ� main �޼ҵ�
     */
    public static void main(String[] args) {

        // log ����� ���� logger ����
        Logger logger = Logger.getLogger(Deduplicate.class);

        // �ߺ��� �����ϴ� list ����
        List<String> list = Arrays.asList("a", "e", "i", "i", "o", "u", "a", "e");

        // �ߺ� ���� ����� �Է¹ޱ� ���� Scanner Ŭ����
        Scanner controlDup = new Scanner(System.in);

        int control = 0; // �Է¹��� controlDup�� �����ϱ� ���� ����

        // ArrayList ����� HashSet ��� �� ����
        while (control != 4) {
            System.out.println("�ߺ� ������ ����� �����ϼ���");
            System.out.println("1. ArrayList 2. HashSet 3. Stream 4. quit");

            try {
                control = controlDup.nextInt(); // ����ڿ��� �Է¹��� ���� ����

            } catch (InputMismatchException ie) { // int�� Ÿ���� �ƴ� ���� �ԷµǾ��� �� �α� ��� �� ���Է� ��û
                logger.info(ie + "\n���ڸ� �Է��ϼ���");
                controlDup.nextLine(); // �Է¹��� ���� �ʱ�ȭ
                continue; // ���Է� ��û

            } catch (Exception e) { // �̽��� ���� ���� �߻��� �α׸� ����� �� ����
                logger.error(e + "\nSystem exit");
                controlDup.close(); // scanner ����
                System.exit(0); // �ý��� ����
            }

            // switch case�� �̿��Ͽ� �Է¹��� ���� ���� �ش��ϴ� �޼ҵ� ȣ��
            switch (control) {

            case 1: // ArrayList�� ����� ���
                useArrList(list);
                break;

            case 2: // HashSet�� ����� ���
                useHashSet(list);
                break;

            case 3: // Stream�� ����� ���
                useStream(list);
                break;

            case 4: // �ý��� ����
                System.out.println("System exit");
                controlDup.close(); // scanner ����
                System.exit(0);

            default: // 1~4�� ���ڰ� �ƴ� �ٸ� ���ڸ� �Է��� ���
                System.out.println("�������� �ִ� ���ڸ� �Է��ϼ���");
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
     *             ArrayList�� �̿��� �ߺ�����
     */
    public static void useArrList(List<String> list) {
        // �ߺ��� ������ list�� ���� list ����
        List<String> arrayList = new ArrayList<>();

        // for each�� ����Ͽ� list�� ��Ҹ� data�� �Է�
        for (String data : list) {
            if (!arrayList.contains(data)) { // Contains�� �Է��Ϸ��� ���� �ִ��� Ȯ�� �� list�� �߰�
                arrayList.add(data);
            }
        }

        // �ߺ��� ������ �� ����Ʈ ���
        System.out.printf("ArrayList result : %s \n", arrayList);
    }

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 3.
     *
     * @param list
     * 
     *             Set�� �̿��� �ߺ� ����
     */
    public static void useHashSet(List<String> list) {
        // �ߺ��� ������ Set�� ���� Set ����
        HashSet<String> hashSet = new HashSet<>();

        // for each�� ����Ͽ� list�� ��Ҹ� data�� �Է�
        for (String data : list) {
            hashSet.add(data); // Set�� �ߺ��� ������� �ʱ� ������ ������� �Է�
        }

        // �ߺ��� ������ �� Set ���
        System.out.printf("HashSet result : %s \n", hashSet);
    }

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 3.
     *
     * @param list
     * 
     *             Stream�� �̿��� �ߺ� ����
     */
    public static void useStream(List<String> list) {
        // Stream�� distinct�� ����� �ߺ�����
        list.stream().distinct().forEach(System.out::print);
    }
}