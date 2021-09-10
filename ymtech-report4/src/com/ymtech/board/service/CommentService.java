package com.ymtech.board.service;

import java.util.Scanner;

import com.ymtech.board.dao.ICommentDao;
import com.ymtech.board.dao.impl.CommentDao;
import com.ymtech.board.dao.impl.CommentDao2;
import com.ymtech.board.vo.Comment;

/**
 * comment의 모든 기능을 사용자에게 입력받는 Class
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 9. 오후 10:54:34
 *
 */
public class CommentService {
    
    // CommentDao interface
    private ICommentDao commentDao;
    private ICommentDao commentDao2;
    
    // 댓글을 입력할 게시물을 보여주기 위함
    private BoardService boardS = new BoardService();
    
    // comment 객체 생성
    private Comment comment = new Comment();

    // 쿼리 작업을 위한 사용자 입력 값
    private Scanner controlCRUD = new Scanner(System.in);
    private String scanStr = "";
    private int scanInt = 0;
    

    // interface 초기화
    public CommentService() {
        this.commentDao = new CommentDao();
        this.commentDao2 = new CommentDao2();
    }

    // 쿼리에 입력할 컬럼을 입력받는 변수

    // 입력받은 변수를 저장

    /**
     * 댓글 생성
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:55:25
     *
     * @return
     */
    public int insert() {
        // 댓글을 입력할 수 있는 게시글 출력
        boardS.selectAll();
        
        // 사용자에게 새로 만들 댓글의 정보를 입력 받음
        
        System.out.println("ID, 댓글을 입력할 게시물 번호, 내용, 답글을 입력할 댓글(없으면 0)");

        // 사용자 id
        scanStr = controlCRUD.next();
        comment.setUserId(scanStr);

        // 댓글을 입력할 게시물 번호
        scanInt = controlCRUD.nextInt();
        comment.setBoardIndex(scanInt);

        // 댓글 내용
        scanStr = controlCRUD.next();
        comment.setContent(scanStr);

        // 답글을 입력할 댓글
        scanInt = controlCRUD.nextInt();
        comment.setParentIndex(scanInt);

        
        
        // 성공 또는 실패 시
        if (commentDao.insert(comment) > 0) {
            System.out.println("추가 성공");
            return 1;
        } else {
            System.out.println("추가 실패");
            return -1;
        }
    }

    /**
     * 모든 댓글 출력
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:56:16
     *
     */
    public void select() {
        System.out.println(commentDao.select().toString());
    }

    /**
     * 댓글 삭제
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:56:25
     *
     * @return
     */
    public int delete() {
        // 삭제할 댓글의 index를 사용자에게 입력 받음
        System.out.println("삭제할 댓글 번호 입력");
        scanInt = controlCRUD.nextInt();

        // 입력 받은 댓글의 index를 전달
        comment.setCommentIndex(scanInt);

        // 성공 또는 실패 시
        if (commentDao.delete(comment) > 0) {
            System.out.println("삭제 완료");
            return 1;
        } else {
            System.out.println("일치하는 댓글이 없습니다.");
            return -1;
        }
    }

    /**
     * 댓글 수정
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:57:00
     *
     * @return
     */
    public int update() {
        // 수정할 댓글의 번호를 사용자에게 입력 받음
        System.out.println("댓글 번호, 내용 입력");

        // 댓글 번호
        scanInt = controlCRUD.nextInt();
        comment.setCommentIndex(scanInt);

        // 수정할 댓글 내용
        scanStr = controlCRUD.next();
        comment.setContent(scanStr);

        // 성공 또는 실패 시
        if (commentDao.update(comment) > 0) {
            System.out.println("업데이트 성공");
            return 1;
        } else {
            System.out.println("업데이트 실패");
            return -1;
        }
    }
    
    // <-- UserDao2 -->
    
    /**
     * 댓글 생성
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 10. 오후 1:18:22
     *
     * @return
     */
    public int insertDao2() {
        // 사용자에게 새로 만들 댓글의 정보를 입력 받음
        System.out.println("ID, 댓글을 입력할 게시물 번호, 내용, 답글을 입력할 댓글(없으면 0)");

        // 사용자 id
        scanStr = controlCRUD.next();
        comment.setUserId(scanStr);

        // 댓글을 입력할 게시물 번호
        scanInt = controlCRUD.nextInt();
        comment.setBoardIndex(scanInt);

        // 댓글 내용
        scanStr = controlCRUD.next();
        comment.setContent(scanStr);

        // 답글을 입력할 댓글
        scanInt = controlCRUD.nextInt();
        comment.setParentIndex(scanInt);

        // 성공 또는 실패 시
        if (commentDao2.insert(comment) > 0) {
            System.out.println("추가 성공");
            return 1;
        } else {
            System.out.println("추가 실패");
            return -1;
        }
    }

    /**
     * 모든 댓글 출력
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 10. 오후 1:18:37
     *
     */
    public void selectDao2() {
        System.out.println(commentDao2.select().toString());
    }


    /**
     * 댓글 삭제
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 10. 오후 1:18:51
     *
     * @return
     */
    public int deleteDao2() {
        // 삭제할 댓글의 index를 사용자에게 입력 받음
        System.out.println("삭제할 댓글 번호 입력");
        scanInt = controlCRUD.nextInt();

        // 입력 받은 댓글의 index를 전달
        comment.setCommentIndex(scanInt);

        // 성공 또는 실패 시
        if (commentDao2.delete(comment) > 0) {
            System.out.println("삭제 완료");
            return 1;
        } else {
            System.out.println("삭제 실패");
            return -1;
        }
    }


    /**
     * 댓글 수정
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 10. 오후 1:18:56
     *
     * @return
     */
    public int updateDao2() {
        // 수정할 댓글의 번호를 사용자에게 입력 받음
        System.out.println("댓글 번호, 내용 입력");

        // 댓글 번호
        scanInt = controlCRUD.nextInt();
        comment.setCommentIndex(scanInt);

        // 수정할 댓글 내용
        scanStr = controlCRUD.next();
        comment.setContent(scanStr);

        // 성공 또는 실패 시
        if (commentDao2.update(comment) > 0) {
            System.out.println("업데이트 성공");
            return 1;
        } else {
            System.out.println("업데이트 실패");
            return -1;
        }
    }
}
