package com.ymtech.board.service;

import java.util.List;

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
    public int insert(Comment comment) {

        // 성공 또는 실패 시

        return commentDao.insert(comment) > 0 ? 1 : 0;
    }

    /**
     * 모든 댓글 출력
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:56:16
     *
     */
    public void select() {
        List<Comment> list = commentDao.select();

        for (Comment comment : list) {
            System.out.println(comment);
        }
    }

    /**
     * 댓글 삭제
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:56:25
     *
     * @return
     */
    public int delete(Comment comment) {

        // 성공 또는 실패 시
        return commentDao.delete(comment) > 0 ? 1 : -1;
    }

    /**
     * 댓글 수정
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:57:00
     *
     * @return
     */
    public int update(Comment comment) {

        // 성공 또는 실패 시

        return commentDao.update(comment) > 0 ? 1 : -1;
    }

    // <-- UserDao2 -->

    /**
     * 댓글 생성
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 13. 오후 2:21:05
     *
     * @param comment
     * @return
     */
    public int insertDao2(Comment comment) {

        // 성공 또는 실패 시

        return commentDao2.insert(comment) > 0 ? 1 : 0;
    }

    /**
     * 모든 댓글 출력
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 13. 오후 2:20:59
     *
     */
    public void selectDao2() {
        List<Comment> list = commentDao2.select();

        for (Comment comment : list) {
            System.out.println(comment);
        }
    }

    /**
     * 댓글 삭제
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 13. 오후 2:20:46
     *
     * @param comment
     * @return
     */
    public int deleteDao2(Comment comment) {

        // 성공 또는 실패 시
        return commentDao2.delete(comment) > 0 ? 1 : -1;
    }

    /**
     * 댓글 수정
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 13. 오후 2:20:40
     *
     * @param comment
     * @return
     */
    public int updateDao2(Comment comment) {

        // 성공 또는 실패 시
        return commentDao2.update(comment) > 0 ? 1 : -1;
    }
}
