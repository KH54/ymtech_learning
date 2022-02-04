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
 *        NIO�� ����� Class, fileVisitor�� ��ӹ޾�
 */
class NioDirectory implements FileVisitor<Path> {

    @Override // ���丮�� �����Ͽ��� ��
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

        // ������ ���丮 �̸� ���
        System.out.printf("���丮 : [%s]\n", dir.toString());

        // ��� Ž�� ����
        return FileVisitResult.CONTINUE;
    }

    @Override // ���Ͽ� �����Ͽ��� �� ����
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        // ������ ���� �̸� ���
        System.out.printf("\t���� %s \n", file.toString());
        
        // ��� Ž�� ����
        return FileVisitResult.CONTINUE;
    }

    @Override // ���Ͽ� �������� ������ �� ����
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.TERMINATE; // ���� �߻��� Ž�� ����
    }

    @Override // ���丮���� ���� �� ����
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE; // ��� Ž�� ����
    }
}