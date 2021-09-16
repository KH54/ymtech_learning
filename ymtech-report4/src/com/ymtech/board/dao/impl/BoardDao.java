package com.ymtech.board.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.function.BiConsumer;

import com.ymtech.board.dao.IBoardDao;
import com.ymtech.board.vo.Board;

/**
 * Board의 crud
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 9. 오후 9:40:35
 *
 */
public class BoardDao extends GenericDao<Board, Integer> implements IBoardDao {

    /**
     * 모든 게시글을 출력하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 15. 오후 2:23:54
     *
     */
    public List<Board> selectAll() {
        // 상속받은 Generic의 selectAll 메소드의 결과 값을 반환
        return super.selectAll(DB.SQL_BOARD_SELECT_ALL, (rs) -> {
            try {
                return new Board(rs);
            } catch (SQLException ignore) {
                return null;
            }
        });
    }

    /**
     * 원하는 게시글을 출력하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 15. 오후 2:24:20
     *
     */
    public Board select(Board board) {

        // 상속받은 Generic의 select 메소드의 결과 값을 반환
        return super.select(DB.SQL_BOARD_DELETE, board.getBoardIndex(), (rs) -> {
            try {
                // User에 ResultSet을 매개변수로 하는 생성자의 반환 값을 매개변수로
                return new Board(rs);
            } catch (SQLException ignore) {
                return null;
            }
        });
    }

    /**
     * 게시글 작성 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 16. 오후 1:32:20
     * @see
     */
    public Integer insert(Board board) {
        // 상속받은 Generic의 insert 메소드의 결과 값을 반환
        return super.insert(board, DB.SQL_BOARD_INSERT, new BiConsumer<PreparedStatement, Board>() {

            @Override
            public void accept(PreparedStatement stmt, Board board) {
                try {
                    stmt.setString(1, board.getUserId());
                    stmt.setString(2, board.getTitle());
                    stmt.setString(3, board.getContent());
                } catch (SQLException e) {
                    System.out.println("BoardDao insert accpet Error");
                }
            }
        });
    }

    /**
     * 게시글 삭제 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 15. 오후 2:24:46
     *
     */
    public Integer delete(Board board) {
        // 상속받은 Generic의 delete 메소드의 결과 값을 반환
        return super.delete(DB.SQL_BOARD_DELETE, board.getBoardIndex());
    }

    /**
     * 게시글 수정 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 15. 오후 2:25:05
     *
     */
    public Integer update(Board board) {

        return super.update(board, DB.SQL_BOARD_UPDATE, new BiConsumer<PreparedStatement, Board>() {

            @Override
            public void accept(PreparedStatement stmt, Board board) {
                try {
                    stmt.setString(1, board.getTitle());
                    stmt.setString(2, board.getContent());
                    stmt.setInt(3, board.getBoardIndex());
                } catch (SQLException e) {
                    System.out.println("BoardDao update accept Error");
                }
            }
        });
    }
}