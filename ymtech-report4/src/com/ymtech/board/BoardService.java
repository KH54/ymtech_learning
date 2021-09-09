package com.ymtech.board;

import java.util.Scanner;

import com.ymtech.board.vo.Board;

import kr.co.ymtech.dao.BoardDAO;

/**
 * board의 모든 기능을 사용자에게 입력받는 Class
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 9. 오후 10:50:46
 *
 */
public class BoardService {
    // Board의 DAO 호출
    private BoardDAO boarddao = new BoardDAO();
    // Board 필드와 getter/setter
    private Board board = new Board();

    // 쿼리에     // 쿼리에 입력할 컬럼을 입력받는 변수
    private Scanner controlCRUD = new Scanner(System.in);

    // 입력받은 변수를 저장
    private String scanStr = "";
    private int scanInt = 0;

    /**
     * 게시글 생성
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:52:12
     *
     * @return
     */
    public int insert() {
        // 사용자에게 새로 만들 게시글의 정보를 입력 받음
        System.out.println("ID, 제목, 내용순으로 입력");

        // 게시글 생성 유저 id
        scanStr = controlCRUD.next();
        board.setUserId(scanStr);

        // 제목
        scanStr = controlCRUD.next();
        board.setTitle(scanStr);

        // 내용
        scanStr = controlCRUD.next();
        board.setContent(scanStr);

        // 성공 또는 실패 시
        if (boarddao.insert(board) > 0) {
            System.out.println("추가 성공");
            return 1;
        } else {
            System.out.println("추가 실패");
            return -1;
        }
    }

    /**
     * 원하는 게시글 출력
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:52:50
     *
     */
    public void select() {
        // 사용자에게 출력할 게시글의 index를 입력받음
        System.out.println("ID입력");
        scanInt = controlCRUD.nextInt();
        System.out.println(boarddao.select(board));

    }

    /**
     * 모든 게시글 출력
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:53:14
     *
     */
    public void selectAll() {
        System.out.println(boarddao.selectAll().toString());
    }

    /**
     * 게시글 삭제
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:53:21
     *
     * @return
     */
    public int delete() {
        // 삭제할 게시글의 index를 사용자에게 입력 받음
        System.out.println("ID 입력");
        scanInt = controlCRUD.nextInt();

        // 입력 받은 게시글 index를 전달
        board.setBoardIndex(scanInt);
        
        // 성공 또는 실패 시
        if (boarddao.delete(board) > 0) {
            System.out.println("삭제 완료");
            return 1;
        } else {
            System.out.println("삭제할 게시글이 없습니다.");
            return -1;
        }
    }

    /**
     * 게시글 정보 수정
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:53:54
     *
     * @return
     */
    public int update() {
        // 수정할 게시글의 index를 입력 받고, 제목과 내용을 변경
        System.out.println("게시글 번호, 제목, 내용순으로 입력");

        // 게시글 번호
        scanInt = controlCRUD.nextInt();
        board.setBoardIndex(scanInt);

        // 제목
        scanStr = controlCRUD.next();
        board.setTitle(scanStr);

        // 내용
        scanStr = controlCRUD.next();
        board.setContent(scanStr);

        // 성공 또는 실패 시
        if (boarddao.update(board) > 0) {
            System.out.println("업데이트 성공");
            return 1;
        } else {
            System.out.println("업데이트 실패");
            return -1;
        }
    }
}
