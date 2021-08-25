import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Fileoutput {
    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 8. 25.
     *
     * @param args
     * 
     *             ���丮 ��� ������ ���丮 ���� ����� �����ϴ� files ����
     */
    public static void main(String[] args) {
        try {
            File File = new File("C:\\Users\\user\\Desktop\\���н�������");

            File[] files = File.listFiles();

            if(files.length != 0) {
            // ���� ���丮 ��
            System.out.println("current directory name" + " : " + File.getName());

            // ����� ���� ���丮�� ���� ����� Read�ϴ� Method ȣ��
            findLowDirectory(files);

            // ����� ���� ���丮�� ���� �� ���丮 ����� Read�ϴ� Method ȣ��
             findLowDirectory2(files);
            
            } else {
                System.out.println("�ش� ��ο��� ���� ���丮 �� ������ �����ϴ�."); // ���丮�� ������� ���
            }
        } catch (NullPointerException e) {
            System.out.println("ERROR : ��θ� ã�� �����ϴ�. �����մϴ�."); // ���丮���� �߸��Ǿ��� ���
        }

    }

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 8. 25.
     *
     * @param files // File �迭�� ��ȯ�� ���� ��� files
     * 
     *              ���丮�� ���ϰ� ���� ���丮���� ���� ���� ����� Read�ϴ� Method
     */
    static void findLowDirectory(File[] files) {

        // ��ϵ��� �����ϱ� ���� list
        List<File> list = new ArrayList<>();

        // list�� files�� ��� ����
        for (File piece : files) {
            list.add(piece);
            if (piece.isDirectory()) { // add�� piece�� ���丮�� ���
                findLowDirectory(piece.listFiles());
            }
        }
        // ���丮 ����
        list.sort(null);

        // list�� ����� ��ҵ��� �о� ���� ���� Iterator
        Iterator<File> iter = list.iterator();

        // ��ҵ��� �ϳ��� ���
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
    }

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 8. 25.
     *
     * @param files // File �迭�� ��ȯ�� ���丮 �� ���� ��� files
     * 
     *              ����� ���� ���丮���� ���� ����� Read�ϴ� Method
     */
    static void findLowDirectory2(File[] files) {

        for (int row = 0; row < files.length; row++) {

            // ����� �̸��� ����
            String fileName = files[row].getName();

            // ���õ� ����� ���丮���� Ȯ��
            if (files[row].isDirectory()) {
                System.out.println("�ѤѤѤ�Directory name" + "[" + fileName + "]" + "�ѤѤѤ�");

                findLowDirectory2(files[row].listFiles()); // ���� ���丮�� �����ϴ� ����Լ�
            } else {
                System.out.println(fileName); // ���丮�� �ƴ� ������ ���
                if (row == files.length - 1) { // ���丮 ���� ���� read�� ������ �� ǥ��
                    System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ� \n");
                }
            }
        }
    }
}
