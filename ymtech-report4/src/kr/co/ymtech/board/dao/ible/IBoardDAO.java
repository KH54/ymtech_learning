package kr.co.ymtech.board.dao.ible;

import java.util.List;

import com.ymtech.board.vo.Board;

/**
 * Board Interface
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 9. 오후 9:21:32
 *
 */
public interface IBoardDAO {

    /**
     * 모든 게시글을 출력하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 9:23:35
     *
     * @return
     */
    public List<Board> selectAll();

    /**
     * 원하는 게시글을 출력하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 9:23:47
     *
     * @param board
     * @return
     */
    public String select(Board board);

    /**
     * 게시글 작성 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 9:23:52
     *
     * @param board
     * @return
     */
    public Integer insert(Board board);

    /**
     * 게시글 삭제 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 9:23:57
     *
     * @param board
     * @return
     */
    public Integer delete(Board board);

    /**
     * 게시글 수정 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 9:24:06
     *
     * @param board
     * @return
     */
    public Integer update(Board board);
}
