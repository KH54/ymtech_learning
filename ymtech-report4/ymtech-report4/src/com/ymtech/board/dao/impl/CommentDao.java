package com.ymtech.board.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.function.BiConsumer;

import com.ymtech.board.dao.ICommentDao;
import com.ymtech.board.vo.Comment;

/**
 * Comment CRUD Class
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 16. 오후 1:31:57
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
        // 상속받은 Generic의 selectAll 메소드의 결과 값을 반환
        return super.selectAll(DB.SQL_COMMENT_SELECT, (rs) -> {
            try {
                // User에 ResultSet을 매개변수로 하는 생성자의 반환 값을 매개변수로
                return new Comment(rs);
            } catch (SQLException ignor) {
                return null;
            }
        });
    }

    /**
     * 댓글 작성 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 16. 오후 1:31:45
     * @see
     */
    public Integer insert(Comment comment) {
        // 상속받은 Generic의 insert 메소드의 결과 값을 반환
        return super.insert(comment, DB.SQL_COMMENT_INSERT, new BiConsumer<PreparedStatement, Comment>() {

            @Override
            public void accept(PreparedStatement stmt, Comment comment) {
                try {
                    stmt.setString(1, comment.getUserId());
                    stmt.setInt(2, comment.getBoardIndex());
                    stmt.setString(3, comment.getContent());
                    stmt.setInt(4, comment.getParentIndex());
                } catch (SQLException e) {
                    System.out.println("CommentDao insert accept Error");
                }
            }
        });
    }

    /**
     * 댓글 삭제 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 16. 오후 1:31:40
     * @see
     */
    public Integer delete(Comment comment) {
        // 상속받은 Generic의 delete 메소드의 결과 값을 반환
        return super.delete(DB.SQL_COMMENT_DELETE, comment.getCommentIndex());
    }

    /**
     * 댓글 수정 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 16. 오후 1:31:33
     * @see
     */
    public Integer update(Comment comment) {
        // 상속받은 Generic의 update 메소드의 결과 값을 반환
        return super.update(comment, DB.SQL_COMMENT_UPDATE, new BiConsumer<PreparedStatement, Comment>() {

            @Override
            public void accept(PreparedStatement stmt, Comment comment) {
                try {
                    stmt.setString(1, comment.getContent());
                    stmt.setInt(2, comment.getCommentIndex());
                } catch (SQLException e) {
                    System.out.println("CommentDao update accept Error");
                }
            }
        });
    }
}