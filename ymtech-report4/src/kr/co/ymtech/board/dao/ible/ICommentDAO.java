package kr.co.ymtech.board.dao.ible;

import java.util.List;

import com.ymtech.board.vo.Comment;

/**
 * Comment Interface
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 9. 오후 9:20:13
 *
 */
public interface ICommentDAO {

    /**
     * 모든 댓글을 출력하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 9:25:07
     *
     * @return
     */
    public List<Comment> select();

    /**
     * 게시글에 댓글을 입력하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 9:25:14
     *
     * @param comment
     * @return
     */
    public Integer insert(Comment comment);

    /**
     * 댓글을 삭제하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 9:25:18
     *
     * @param comment
     * @return
     */
    public Integer delete(Comment comment);

    /**
     * 댓글을 수정하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 9:25:23
     *
     * @param comment
     * @return
     */
    public Integer update(Comment comment);
}
