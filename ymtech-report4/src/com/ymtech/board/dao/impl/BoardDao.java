package com.ymtech.board.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        try {
            // 상속받은 Generic의 selectAll 메소드의 결과 값을 반환
            return super.selectAll(DB.SQL_BOARD_SELECT_ALL, (rs) -> {
                try {
                    return new Board(rs);
                } catch (SQLException ignore) {
                    return null;
                }
            });
        } catch (SQLException e) {
            System.out.println("Board selectAll SQL Error");
        }
        return null;
    }

    /**
     * 원하는 게시글을 출력하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 15. 오후 2:24:20
     *
     */
    public Board select(Board board) {
        try {
            // 상속받은 Generic의 select 메소드의 결과 값을 반환
            return super.select(DB.SQL_BOARD_DELETE, board.getBoardIndex(), (rs) -> {
                try {
                    // User에 ResultSet을 매개변수로 하는 생성자의 반환 값을 매개변수로
                    return new Board(rs);
                } catch (SQLException ignore) {
                    return null;
                }
            });
        } catch (SQLException e) {
            System.out.println("Board select SQL Error");
            return null;
        }
    }

    /**
     * 게시글 작성 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 9:41:35
     *
     */
    public Integer insert(Board board) {
        // 사용자 입력 값을 저장하기 위한 list
        List<Object> list = new ArrayList<>();

        list.add(board.getUserId());
        list.add(board.getTitle());
        list.add(board.getContent());

        try {
            // 상속받은 Generic의 insert 메소드의 결과 값을 반환
            return super.insert(DB.SQL_BOARD_INSERT, list);
        } catch (SQLException e) {
            System.out.println("Board insert SQL Error");
        }
        return null;
    }

    /**
     * 게시글 삭제 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 15. 오후 2:24:46
     *
     */
    public Integer delete(Board board) {

        try {
            // 상속받은 Generic의 delete 메소드의 결과 값을 반환
            return super.delete(DB.SQL_BOARD_DELETE, board.getBoardIndex());
        } catch (SQLException e) {
            System.out.println("Board delete SQL Error");
        }
        return null;
    }

    /**
     * 게시글 수정 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 15. 오후 2:25:05
     *
     */
    public Integer update(Board board) {
        // 사용자 입력 값을 저장하기 위한 list
        List<Object> list = new ArrayList<>();

        list.add(board.getTitle());
        list.add(board.getContent());
        list.add(board.getBoardIndex());

        try {
            // 상속받은 Generic의 update 메소드의 결과 값을 반환
            super.update(DB.SQL_BOARD_UPDATE, list);
        } catch (SQLException e) {
            System.out.println("Board update SQL Error");
        }
        return null;
    }
}