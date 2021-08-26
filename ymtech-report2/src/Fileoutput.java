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
 *        NIO를 사용한 Class
 */
class findNioDirectory implements FileVisitor<Path> {
    @Override // Directory에 접근하기 전에
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println(dir.toString()); // 접근한 Directory 이름 출력
        return FileVisitResult.CONTINUE; // 순회작업 진행
    }

    @Override // File에 접근하였을 때
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.toString());
        return FileVisitResult.CONTINUE;
    }

    @Override // File에 접근하지 못했을 때
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override // Directory 접근하고 난 뒤
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}

/**
 * 
 * @author "KyungHun Park"
 * @since 2021. 8. 26.
 *
 *        디렉토리의 모든 하위 디렉토리와 파일을 출력하는 클래스
 */
public class Fileoutput {
    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 8. 25.
     *
     * @param args
     * 
     *             디렉토리 경로 설정과 디렉토리 내부 목록을 저장하는 files 생성
     */
    public static void main(String[] args) {
        try {
            File File = new File("C:\\Users\\user\\Desktop\\일학습병행제"); // directory인지 확인하는 구문
            Path path = Paths.get("C:\\Users\\user\\Desktop\\일학습병행제"); // NIO를 사용하기 위한 구문

            File[] files = File.listFiles();

            if (files.length != 0) {
                // 현재 디렉토리 명
                System.out.printf("current directory name : %s \n", File.getName()); // print

                // 현재와 하위 디렉토리의 파일 목록을 Read하는 Method 호출
                findListLowDirectory(files);

                // 현재와 하위 디렉토리의 파일 및 디렉토리 목록을 Read하는 Method 호출
                findLowDirectory(files);

                try {
                    Files.walkFileTree(path, new findNioDirectory());
                } catch (Exception e) {
                    System.out.println("walkFileTree Error");
                }

            } else {
                System.out.println("해당 경로에는 하위 디렉토리 및 파일이 없습니다."); // 디렉토리가 비어있을 경우
            }
        } catch (NullPointerException e) {
            System.out.println("ERROR : 경로를 찾을 없습니다. 종료합니다."); // 디렉토리명이 잘못되었을 경우
        }
    }

    /*
     * 
     * @author "KyungHun Park"
     * 
     * @since 2021. 8. 25.
     *
     * @param files // File 배열로 반환한 파일 목록 files
     * 
     * 디렉토리의 파일과 하위 디렉토리들이 가진 파일 목록을 Read하는 Method
     */
    static void findListLowDirectory(File[] files) { // 메소드 명 바꾸기

        // 목록들을 저장하기 위한 list
        List<File> list = new ArrayList<>();

        // list에 files의 목록 저장
        for (File piece : files) {
            list.add(piece);
            if (piece.isDirectory()) { // add한 piece가 디렉토리면 재귀
                findListLowDirectory(piece.listFiles());
            }
        }

        // list에 저장된 요소들을 읽어 오기 위한 Iterator
        Iterator<File> iter = list.iterator(); // 컬렉션의 요소들을 읽어오는 방법에 대한 표준화

        // 요소들을 하나씩 출력
        while (iter.hasNext()) {
            System.out.printf("%s \n", iter.next());
        }
    }

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 8. 25.
     *
     * @param files // File 배열로 반환한 디렉토리 및 파일 목록 files
     * 
     *              현재와 하위 디렉토리들이 가진 목록을 Read하는 Method
     */
    static void findLowDirectory(File[] files) {

        for (int row = 0; row < files.length; row++) {

            // 목록의 이름을 저장
            String fileName = files[row].getName();

            // 선택된 목록이 디렉토리인지 확인
            if (files[row].isDirectory()) {
                System.out.printf("ㅡㅡㅡㅡDirectory name [ %s ] ㅡㅡㅡㅡ\n", fileName);

                findLowDirectory(files[row].listFiles()); // 하위 디렉토리로 진입하는 재귀함수
            } else {
                System.out.println(fileName); // 디렉토리가 아닌 파일일 경우
                if (row == files.length - 1) { // 디렉토리 내의 파일 read가 끝났을 때 표시
                    System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ \n");
                }
            }
        }
    }
}