package com.ymtech.fileexplore;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *        디렉토리의 모든 하위 디렉토리와 파일을 출력하는 클래스
 * 
 * @author "KyungHun Park"
 * @since 2021. 9. 3.
 *
 */
public class Fileoutput {
    /**
     *             디렉토리 경로 설정과 디렉토리 내부 목록을 저장하는 files 생성
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 3.
     *
     * @param args
     * 
     */
    public static void main(String[] args) {

        // NioDirectory 클래스 인스턴스 생성
        NioDirectory nio = new NioDirectory();

        // 탐색할 디렉토리 경로 설정
        final String filePath = "C:\\Users\\user\\Desktop\\일학습병행제\\NCS\\새 폴더"; //

        try {
            // 해당 경로를 가진 file , path 객체 생성
            File file = new File(filePath);
            Path path = Paths.get(filePath);

            // 디렉토리의 파일목록을 files 배열로 반환
            File[] files = file.listFiles();

            // 디렉토리의 내부가 비어있지 않을 경우
            if (files.length != 0) {

                // 현재 디렉토리 명
                System.out.printf("Current directory name : %s \n", file.getName());

                // 현재와 하위 디렉토리의 파일 및 디렉토리 목록을 Read하는 Method 호출
                findLowDirectory(files);

                try {
                    //
                    Files.walkFileTree(path, nio);
                } catch (Exception e) {
                    System.out.println("walkFileTree Error");
                }

            } else { // 디렉토리가 비어있을 경우
                System.out.println("해당 경로에는 하위 디렉토리 및 파일이 없습니다.");
            }
        } catch (NullPointerException e) { // 디렉토리명이 잘못되었을 경우
            System.out.println("ERROR : 선택된 경로가 디렉토리가 아니거나 잘못된 경로입니다.");
        }
    }

    /**
     *              현재와 하위 디렉토리들이 가진 목록을 출력하는 메소드
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 3.
     *
     * @param files // File 배열로 반환한 디렉토리 및 파일 목록 files
     * 
     */
    static void findLowDirectory(File[] files) {
        StringBuffer fileName = new StringBuffer(); // 목록의 요소를 저장하기 위한 String 변수
        for (int row = 0; row < files.length; row++) {

            // 목록의 이름을 저장
            fileName = fileName.append(files[row].getName());

            // 선택된 목록이 디렉토리인 경우
            if (files[row].isDirectory()) {

                // 디렉토리일 경우 디렉토리명 출력
                System.out.printf("Directory name [ %s ] ㅡㅡㅡㅡ\n", fileName);

                // 하위 디렉토리로 진입하기 위해 재귀
                findLowDirectory(files[row].listFiles());
            } else { // 선택된 목록이 파일일 경우

                System.out.printf("\t %s \n", fileName);

                // 디렉토리 내의 모든 파일의 순회가 끝났을 경우
                if (row == files.length - 1) {
                    System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ \n");
                }
            }
            // 입력된 목록이 중복으로 출력되는 것을 방지하기 위해 delete 메소드를 사용하여 fileName을 초기화
            fileName = fileName.delete(0, fileName.length());
        }
    }
}