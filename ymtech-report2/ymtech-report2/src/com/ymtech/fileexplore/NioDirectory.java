package com.ymtech.fileexplore;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 
 * @author "KyungHun Park"
 * @since 2021. 8. 26.
 *
 *        NIO를 사용한 Class, fileVisitor를 상속받아
 */
class NioDirectory implements FileVisitor<Path> {

    @Override // 디렉토리에 접근하였을 때
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

        // 접근한 디렉토리 이름 출력
        System.out.printf("디렉토리 : [%s]\n", dir.toString());

        // 계속 탐색 진행
        return FileVisitResult.CONTINUE;
    }

    @Override // 파일에 접근하였을 때 실행
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        // 접근한 파일 이름 출력
        System.out.printf("\t파일 %s \n", file.toString());
        
        // 계속 탐색 진행
        return FileVisitResult.CONTINUE;
    }

    @Override // 파일에 접근하지 못했을 때 실행
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.TERMINATE; // 오류 발생시 탐색 종료
    }

    @Override // 디렉토리에서 떠날 때 실행
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE; // 계속 탐색 진행
    }
}