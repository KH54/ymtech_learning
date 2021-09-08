package com.ymtech.board;

import java.sql.SQLException;

/**
 * user, board, comment�� CRUD Class
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 9. ���� 12:41:06
 *
 */
public class Main {
    /**
     * ��� CRUD�� �ϴ� �޼ҵ� // �����ؾ���.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. ���� 12:41:22
     *
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        UserCRUD user = new UserCRUD();
        BoardCRUD board = new BoardCRUD();
        CommentCRUD comment = new CommentCRUD();

        /*-- User CRUD --*/
        // ����� �߰�
        if (user.insert() != 0) {
            System.out.println("�߰� ����");
        } else {
            System.out.println("�߰� ����");
        }

        // ����� ���� (user_id)
        if (user.delete("user_id") != 0) {
            System.out.println("���� ����");
        } else {
            System.out.println("���� ����");
        }

        // ����� ���� ���� ( �������̵� )
        if (user.update("user_id") > 0) {
            System.out.println("���� ����");
        } else {
            System.out.println("���� ����");
        }
        // ���ϴ� ����� ���� ( �������̵� )
        user.select("user_id");
        // ��� ����� ����
        user.selectAll();

        /*-- Board CRUD --*/

        // �Խñ� �ۼ� (�������̵�,����,����)
        if(board.insert("user_id", "title", "content") != 0) {
            System.out.println("�ۼ� ����");
        } else {
            System.out.println("�ۼ� ����");
        }

        // �Խñ� ���� (������ boardIndex)
        if (board.delete(1) != 0) {
            System.out.println("���� ����");
        } else {
            System.out.println("���� ����");
        }

        // �Խñ� ���� (����, ����, boardIndex )
        if (board.update("title", "content", 1) > 0) {
            System.out.println("���� ����");
        } else {
            System.out.println("���� ����");
        }

        // �Խñ� ��ü ����
        board.selectAll();

        // �Խñ� �����ؼ� ���� ( boardIndex )
        board.select(1);

        /*-- Comment CRUD --*/

        // ��� �ۼ� ( �������̵�, boardIndex, ����, commentIndex )
        if(comment.insert("user_id", 1, "content", 0) != 0) {
            System.out.println("�ۼ� ����");
        } else {
            System.out.println("�ۼ� ����");
        }

        // ��� ���� ( commentIndex )
        if(comment.delete(0) != 0 ) {
            System.out.println("���� ����");
        } else {
            System.out.println("���� ����");
        }

        // ��� ���� ( ����, commentIndex )
        if(comment.update("content", 0) > 0) {
            System.out.println("���� ����");
        } else {
            System.out.println("���� ����");
        }
    }

}
