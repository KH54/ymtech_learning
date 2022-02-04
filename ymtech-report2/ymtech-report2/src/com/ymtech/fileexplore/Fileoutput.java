package com.ymtech.fileexplore;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *        ���丮�� ��� ���� ���丮�� ������ ����ϴ� Ŭ����
 * 
 * @author "KyungHun Park"
 * @since 2021. 9. 3.
 *
 */
public class Fileoutput {
    /**
     *             ���丮 ��� ������ ���丮 ���� ����� �����ϴ� files ����
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 3.
     *
     * @param args
     * 
     */
    public static void main(String[] args) {

        // NioDirectory Ŭ���� �ν��Ͻ� ����
        NioDirectory nio = new NioDirectory();

        // Ž���� ���丮 ��� ����
        final String filePath = "C:\\Users\\user\\Desktop\\���н�������\\NCS\\�� ����"; //

        try {
            // �ش� ��θ� ���� file , path ��ü ����
            File file = new File(filePath);
            Path path = Paths.get(filePath);

            // ���丮�� ���ϸ���� files �迭�� ��ȯ
            File[] files = file.listFiles();

            // ���丮�� ���ΰ� ������� ���� ���
            if (files.length != 0) {

                // ���� ���丮 ��
                System.out.printf("Current directory name : %s \n", file.getName());

                // ����� ���� ���丮�� ���� �� ���丮 ����� Read�ϴ� Method ȣ��
                findLowDirectory(files);

                try {
                    //
                    Files.walkFileTree(path, nio);
                } catch (Exception e) {
                    System.out.println("walkFileTree Error");
                }

            } else { // ���丮�� ������� ���
                System.out.println("�ش� ��ο��� ���� ���丮 �� ������ �����ϴ�.");
            }
        } catch (NullPointerException e) { // ���丮���� �߸��Ǿ��� ���
            System.out.println("ERROR : ���õ� ��ΰ� ���丮�� �ƴϰų� �߸��� ����Դϴ�.");
        }
    }

    /**
     *              ����� ���� ���丮���� ���� ����� ����ϴ� �޼ҵ�
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 3.
     *
     * @param files // File �迭�� ��ȯ�� ���丮 �� ���� ��� files
     * 
     */
    static void findLowDirectory(File[] files) {
        StringBuffer fileName = new StringBuffer(); // ����� ��Ҹ� �����ϱ� ���� String ����
        for (int row = 0; row < files.length; row++) {

            // ����� �̸��� ����
            fileName = fileName.append(files[row].getName());

            // ���õ� ����� ���丮�� ���
            if (files[row].isDirectory()) {

                // ���丮�� ��� ���丮�� ���
                System.out.printf("Directory name [ %s ] �ѤѤѤ�\n", fileName);

                // ���� ���丮�� �����ϱ� ���� ���
                findLowDirectory(files[row].listFiles());
            } else { // ���õ� ����� ������ ���

                System.out.printf("\t %s \n", fileName);

                // ���丮 ���� ��� ������ ��ȸ�� ������ ���
                if (row == files.length - 1) {
                    System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ� \n");
                }
            }
            // �Էµ� ����� �ߺ����� ��µǴ� ���� �����ϱ� ���� delete �޼ҵ带 ����Ͽ� fileName�� �ʱ�ȭ
            fileName = fileName.delete(0, fileName.length());
        }
    }
}