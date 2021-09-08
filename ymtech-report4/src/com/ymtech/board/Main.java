package com.ymtech.board;

import java.sql.SQLException;

/**
 * user, board, comment의 CRUD Class
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 9. 오전 12:41:06
 *
 */
public class Main {
    /**
     * 모든 CRUD를 하는 메소드 // 분할해야함.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오전 12:41:22
     *
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        UserCRUD user = new UserCRUD();
        BoardCRUD board = new BoardCRUD();
        CommentCRUD comment = new CommentCRUD();

        /*-- User CRUD --*/
        // 사용자 추가
        if (user.insert() != 0) {
            System.out.println("추가 성공");
        } else {
            System.out.println("추가 실패");
        }

        // 사용자 삭제 (user_id)
        if (user.delete("user_id") != 0) {
            System.out.println("삭제 성공");
        } else {
            System.out.println("삭제 실패");
        }

        // 사용자 정보 수정 ( 유저아이디 )
        if (user.update("user_id") > 0) {
            System.out.println("수정 성공");
        } else {
            System.out.println("수정 실패");
        }
        // 원하는 사용자 정보 ( 유저아이디 )
        user.select("user_id");
        // 모든 사용자 정보
        user.selectAll();

        /*-- Board CRUD --*/

        // 게시글 작성 (유저아이디,제목,내용)
        if(board.insert("user_id", "title", "content") != 0) {
            System.out.println("작성 성공");
        } else {
            System.out.println("작성 실패");
        }

        // 게시글 삭제 (삭제할 boardIndex)
        if (board.delete(1) != 0) {
            System.out.println("삭제 성공");
        } else {
            System.out.println("삭제 실패");
        }

        // 게시글 수정 (제목, 내용, boardIndex )
        if (board.update("title", "content", 1) > 0) {
            System.out.println("수정 성공");
        } else {
            System.out.println("수정 실패");
        }

        // 게시글 전체 보기
        board.selectAll();

        // 게시글 선택해서 보기 ( boardIndex )
        board.select(1);

        /*-- Comment CRUD --*/

        // 댓글 작성 ( 유저아이디, boardIndex, 내용, commentIndex )
        if(comment.insert("user_id", 1, "content", 0) != 0) {
            System.out.println("작성 성공");
        } else {
            System.out.println("작성 실패");
        }

        // 댓글 삭제 ( commentIndex )
        if(comment.delete(0) != 0 ) {
            System.out.println("삭제 성공");
        } else {
            System.out.println("삭제 실패");
        }

        // 댓글 수정 ( 내용, commentIndex )
        if(comment.update("content", 0) > 0) {
            System.out.println("수정 성공");
        } else {
            System.out.println("수정 실패");
        }
    }

}
