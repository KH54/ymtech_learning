package com.ymtech.board.service;

import java.util.Scanner;

import com.ymtech.board.dao.IBoardDao;
import com.ymtech.board.dao.impl.BoardDao;
import com.ymtech.board.dao.impl.BoardDao2;
import com.ymtech.board.vo.Board;

/**
 * board의 모든 기능을 사용자에게 입력받는 Class
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 9. 오후 10:50:46
 *
 */
public class BoardService {

    // boardDao interface
    private IBoardDao boardDao;
    private IBoardDao boardDao2;

    // board 객체 생성
    private Board board = new Board();

    // 쿼리 작업을 위한 사용자 입력 값
    private Scanner controlCRUD = new Scanner(System.in);

    // 입력받은 변수를 저장
    private String scanStr = "";
    private int scanInt = 0;
    
    // interface 초기화
    public BoardService() {
        this.boardDao = new BoardDao();
        this.boardDao2 = new BoardDao2();
    }

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
        if (boardDao.insert(board) > 0) {
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
        System.out.println("검색할 게시물의 index 입력");
        scanInt = controlCRUD.nextInt();
        board.setBoardIndex(scanInt);

        if (boardDao.select(board) != null) {
            System.out.println(boardDao.select(board));
        } else {
            System.out.println("입력한 게시글을 찾을 수 없습니다.");
        }

    }

    /**
     * 모든 게시글 출력
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:53:14
     *
     */
    public void selectAll() {
        System.out.println(boardDao.selectAll().toString());
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
        if (boardDao.delete(board) > 0) {
            System.out.println("삭제 완료");
            return 1;
        } else {
            System.out.println("입력한 게시글을 찾을 수 없습니다.");
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
        if (boardDao.update(board) > 0) {
            System.out.println("업데이트 성공");
            return 1;
        } else {
            System.out.println("업데이트 실패");
            return -1;
        }
    }

    // <-- UserDao2 -->

    /**
     * 게시글 생성
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 10. 오후 1:19:07
     *
     * @return
     */
    public int insertDao2() {
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
        if (boardDao2.insert(board) > 0) {
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
     * @since 2021. 9. 10. 오후 1:19:14
     *
     */
    public void selectDao2() {
        // 사용자에게 출력할 게시글의 index를 입력받음
        System.out.println("ID입력");
        scanInt = controlCRUD.nextInt();
        System.out.println(boardDao2.select(board));

    }

    /**
     * 모든 게시글 출력
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 10. 오후 1:19:27
     *
     */
    public void selectAllDao2() {
        System.out.println(boardDao2.selectAll().toString());
    }

    /**
     * 게시글 삭제
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 10. 오후 1:19:31
     *
     * @return
     */
    public int deleteDao2() {
        // 삭제할 게시글의 index를 사용자에게 입력 받음
        System.out.println("ID 입력");
        scanInt = controlCRUD.nextInt();

        // 입력 받은 게시글 index를 전달
        board.setBoardIndex(scanInt);

        // 성공 또는 실패 시
        if (boardDao2.delete(board) > 0) {
            System.out.println("삭제 완료");
            return 1;
        } else {
            System.out.println("삭제할 게시글이 없습니다.");
            return -1;
        }
    }

    /**
     * 게시글 수정
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 10. 오후 1:19:35
     *
     * @return
     */
    public int updateDao2() {
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
        if (boardDao2.update(board) > 0) {
            System.out.println("업데이트 성공");
            return 1;
        } else {
            System.out.println("업데이트 실패");
            return -1;
        }
    }
}
