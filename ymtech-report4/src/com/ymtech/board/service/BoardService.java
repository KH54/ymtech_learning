package com.ymtech.board.service;

import java.util.List;

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
    public int insert(Board board) {

        // 성공 또는 실패 시
        return boardDao.insert(board) > 0 ? 1 : -1;
    }

    /**
     * 원하는 게시글 출력
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:52:50
     *
     */
    public String select(Board board) {

        String list = boardDao.select(board);

        return boardDao.select(board) != null ? list : null;
    }

    /**
     * 모든 게시글 출력
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:53:14
     *
     */
    public void selectAll() {
        List<Board> list = boardDao.selectAll();

        for (Board board : list) {
            System.out.println(board);
        }
    }

    /**
     * 게시글 삭제
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:53:21
     *
     * @return
     */
    public int delete(Board board) {

        // 성공 또는 실패 시

        return boardDao.delete(board) > 0 ? 1 : -1;
    }

    /**
     * 게시글 정보 수정
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:53:54
     *
     * @return
     */
    public int update(Board board) {

        // 성공 또는 실패 시

        return boardDao.update(board) > 0 ? 1 : -1;
    }

    // <-- UserDao2 -->

    /**
     * 게시글 생성
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 13. 오후 2:19:51
     *
     * @param board
     * @return
     */
    public int insertDao2(Board board) {

        // 성공 또는 실패 시
        return boardDao2.insert(board) > 0 ? 1 : -1;
    }

    /**
     * 원하는 게시글 출력
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 13. 오후 2:19:46
     *
     * @param board
     * @return
     */
    public String selectDao2(Board board) {

        String list = boardDao2.select(board);

        return boardDao2.select(board) != null ? list : null;
    }

    /**
     * 모든 게시글 출력
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 13. 오후 2:19:39
     *
     */
    public void selectAllDao2() {
        List<Board> list = boardDao2.selectAll();

        for (Board board : list) {
            System.out.println(board);
        }
    }

    /**
     * 게시글 삭제
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 13. 오후 2:19:34
     *
     * @param board
     * @return
     */
    public int deleteDao2(Board board) {

        // 성공 또는 실패 시

        return boardDao2.delete(board) > 0 ? 1 : -1;
    }

    /**
     * 게시글 정보 수정
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 13. 오후 2:19:31
     *
     * @param board
     * @return
     */
    public int updateDao2(Board board) {

        // 성공 또는 실패 시

        return boardDao2.update(board) > 0 ? 1 : -1;
    }

}
