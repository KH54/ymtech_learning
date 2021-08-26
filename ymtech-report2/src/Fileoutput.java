import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author "KyungHun Park"
 * @since 2021. 8. 26.
 *
 *        NIO�� ����� Class
 */
class findNioDirectory implements FileVisitor<Path> {
    @Override // Directory�� �����ϱ� ����
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println(dir.toString()); // ������ Directory �̸� ���
        return FileVisitResult.CONTINUE; // ��ȸ�۾� ����
    }

    @Override // File�� �����Ͽ��� ��
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.toString());
        return FileVisitResult.CONTINUE;
    }

    @Override // File�� �������� ������ ��
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override // Directory �����ϰ� �� ��
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}

/**
 * 
 * @author "KyungHun Park"
 * @since 2021. 8. 26.
 *
 *        ���丮�� ��� ���� ���丮�� ������ ����ϴ� Ŭ����
 */
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
            File File = new File("C:\\Users\\user\\Desktop\\���н�������"); // directory���� Ȯ���ϴ� ����
            Path path = Paths.get("C:\\Users\\user\\Desktop\\���н�������"); // NIO�� ����ϱ� ���� ����

            File[] files = File.listFiles();

            if (files.length != 0) {
                // ���� ���丮 ��
                System.out.printf("current directory name : %s \n", File.getName()); // print

                // ����� ���� ���丮�� ���� ����� Read�ϴ� Method ȣ��
                findListLowDirectory(files);

                // ����� ���� ���丮�� ���� �� ���丮 ����� Read�ϴ� Method ȣ��
                findLowDirectory(files);

                try {
                    Files.walkFileTree(path, new findNioDirectory());
                } catch (Exception e) {
                    System.out.println("walkFileTree Error");
                }

            } else {
                System.out.println("�ش� ��ο��� ���� ���丮 �� ������ �����ϴ�."); // ���丮�� ������� ���
            }
        } catch (NullPointerException e) {
            System.out.println("ERROR : ��θ� ã�� �����ϴ�. �����մϴ�."); // ���丮���� �߸��Ǿ��� ���
        }
    }

    /*
     * 
     * @author "KyungHun Park"
     * 
     * @since 2021. 8. 25.
     *
     * @param files // File �迭�� ��ȯ�� ���� ��� files
     * 
     * ���丮�� ���ϰ� ���� ���丮���� ���� ���� ����� Read�ϴ� Method
     */
    static void findListLowDirectory(File[] files) { // �޼ҵ� �� �ٲٱ�

        // ��ϵ��� �����ϱ� ���� list
        List<File> list = new ArrayList<>();

        // list�� files�� ��� ����
        for (File piece : files) {
            list.add(piece);
            if (piece.isDirectory()) { // add�� piece�� ���丮�� ���
                findListLowDirectory(piece.listFiles());
            }
        }

        // list�� ����� ��ҵ��� �о� ���� ���� Iterator
        Iterator<File> iter = list.iterator(); // �÷����� ��ҵ��� �о���� ����� ���� ǥ��ȭ

        // ��ҵ��� �ϳ��� ���
        while (iter.hasNext()) {
            System.out.printf("%s \n", iter.next());
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
    static void findLowDirectory(File[] files) {

        for (int row = 0; row < files.length; row++) {

            // ����� �̸��� ����
            String fileName = files[row].getName();

            // ���õ� ����� ���丮���� Ȯ��
            if (files[row].isDirectory()) {
                System.out.printf("�ѤѤѤ�Directory name [ %s ] �ѤѤѤ�\n", fileName);

                findLowDirectory(files[row].listFiles()); // ���� ���丮�� �����ϴ� ����Լ�
            } else {
                System.out.println(fileName); // ���丮�� �ƴ� ������ ���
                if (row == files.length - 1) { // ���丮 ���� ���� read�� ������ �� ǥ��
                    System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ� \n");
                }
            }
        }
    }
}