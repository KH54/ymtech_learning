package com.ymtech.board.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ymtech.board.dao.ICommentDao;
import com.ymtech.board.vo.Comment;

/**
 * Comment의 crud
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 9. 오후 10:15:33
 *
 */
public class CommentDao extends GenericDao<Comment, Integer> implements ICommentDao {

    /**
     * 모든 댓글을 출력하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:15:49
     *
     */
    public List<Comment> select() {

        // DB 연결 및 쿼리 호출 실행
        try {
            // 상속받은 Generic의 selectAll 메소드의 결과 값을 반환
            return super.selectAll(DB.SQL_COMMENT_SELECT, (rs) -> {
                try {
                    // User에 ResultSet을 매개변수로 하는 생성자의 반환 값을 매개변수로
                    return new Comment(rs);
                } catch (SQLException ignor) {
                    return null;
                }
            });

        } catch (SQLException e) {
            System.out.println("Comment select SQL Error");

        }
        return null;
    }

    /**
     * 댓글 작성 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:17:22
     *
     */
    public Integer insert(Comment comment) {
        // 사용자 입력 값을 저장하기 위한 list
        List<Object> list = new ArrayList<>();

        list.add(comment.getUserId());
        list.add(comment.getBoardIndex());
        list.add(comment.getContent());
        list.add(comment.getParentIndex());
        try {
            // 상속받은 Generic의 insert 메소드의 결과 값을 반환
            return super.insert(DB.SQL_COMMENT_INSERT, list);
        } catch (SQLException e) {
            System.out.println("Comment insert SQL Error");
        }
        return null;
    }

    /**
     * 댓글 삭제 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:18:21
     *
     */
    public Integer delete(Comment comment) {

        try {
            // 상속받은 Generic의 delete 메소드의 결과 값을 반환
            return super.delete(DB.SQL_COMMENT_DELETE, comment.getCommentIndex());
        } catch (SQLException e) {
            System.out.println("Comment delete SQL Error");
        }
        return null;
    }

    /**
     * 댓글 수정 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:19:20
     *
     */
    public Integer update(Comment comment) {
        // 사용자 입력 값을 저장하기 위한 list
        List<Object> list = new ArrayList<>();

        list.add(comment.getContent());
        list.add(comment.getCommentIndex());

        try {
            // 상속받은 Generic의 update 메소드의 결과 값을 반환
            return super.update(DB.SQL_COMMENT_UPDATE, list);
        } catch (SQLException e) {
            System.out.println("Board update SQL Error");
        }
        return null;
    }
}