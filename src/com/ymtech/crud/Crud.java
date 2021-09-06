package com.ymtech.crud;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 *        DB�� 'info' TABLE�� �����Ͽ� ����ڿ��� �Է� ���� ������ CRUD ����
 * 
 * @author "KyungHun Park"
 * @since 2021. 9. 03.
 * 
 */
public class Crud {
    public static void main(String[] args) {

        // DbControl Class �ν��Ͻ� ����
        DbControl dc = new DbControl();

        // log ����� ���� logger ����
        Logger logger = Logger.getLogger(Crud.class);

        // ����ڿ��� �Է��� �ޱ� ���� Scanner Class �ν��Ͻ� ����
        Scanner controlCRUD = new Scanner(System.in);

        // �۾��� �����ϱ� ���� ����ڿ��� �Է� ���� ���� �����ϴ� ����
        int control = 0;

        // break���� ��� ������ �����ϵ��� While�� ���
        while (true) {

            try {
                // ������ CRUD ����
                System.out.println("TABLE���� ������ �۾��� ������");
                System.out.println("1 : insert, 2 : delete, 3 : update, 4 : read, 5 : quit");

                // ����ڿ��� �۾��� �Է¹���
                control = controlCRUD.nextInt();

            } catch (InputMismatchException ie) { // int�� Ÿ���� �ƴ� ���� �ԷµǾ��� �� �α׸� ����� �� ���Է� ��û

                // enter�� �������� ���� �����ϴ� nextLine() �޼ҵ�. �Էµ� ���� �ʱ�ȭ �����ش�.
                controlCRUD.nextLine();
                logger.info("\n ���ڸ� �Է����ּ���") ;
                continue; // ���Է� ��û

            } catch (Exception e) { // �α׸� ����ϰ� �ý��� ����
                logger.error("\n �ý��� ����", e);
                System.exit(0);
            }

            /* ������� �Է¿� ���� �޼ҵ� ȣ�� */
            switch (control) {
            case 1: // �߰�
                dc.insert();
                break;

            case 2: // ����
                dc.delete();
                break;

            case 3: // ����
                dc.update();
                break;

            case 4: // �б�
                dc.read();
                break;

            case 5: // �ý��� ����
                System.out.println("�ý��� ����");
                controlCRUD.close(); // scanner ����
                System.exit(0);

            default: // 1~5�� �ƴ� �ٸ� ���ڸ� �Է��� ���
                System.out.println("�������� �ִ� ���ڸ� �Է����ּ���");
                break;
            }
            controlCRUD.nextLine(); // �Է¹޾Ҵ� ���� �ʱ�ȭ
        }

    }
}