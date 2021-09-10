package com.ymtech.board.dao.impl;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class BoardDao2 implements IBoardDao {

    /**
     * 모든 게시글을 출력하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 9:40:53
     *
     */
    public List<Board> selectAll() {
        // 모든 게시글의 정보를 담을 list
        List<Board> boardList = new ArrayList<Board>();
        // 게시글의 정보를 담을 boardInfo
        Board boardInfo;

        // DB 연결 및 쿼리 호출 실행
        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); 
                PreparedStatement stmt = con.prepareStatement(DB.SQL_BOARD_SELECT_ALL); 
                ResultSet rs = stmt.executeQuery();) {
            
            // 쿼리문의 결과를 출력하여 저장
            while (rs.next()) {
                boardInfo = new Board(rs.getString("user_id"), rs.getString("title"), rs.getString("content"), rs.getString("create_time"), rs.getString("update_time"), rs.getInt("board_index"), rs.getInt("view_count"));
                boardList.add(boardInfo);
            }
            // 예외 발생시 종료
        } catch (Exception e) {
            System.out.println("Board SelectAll Error");
            System.exit(0);
        }
        return boardList;
    }

    /**
     * 원하는 게시글을 출력하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 9:41:29
     *
     */
    public String select(Board board) {

        // 선택한 게시물의 정보를 담을 객체
        Board boardInfo = null;
        // 담은 정보를 String으로 저장
        String Info = null;

        // DB 연결 및 쿼리 호출
        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); 
                PreparedStatement stmt = con.prepareStatement(DB.SQL_BOARD_SELECT);) {

            // 입력받은 index를 쿼리에 입력
            stmt.setInt(1, board.getBoardIndex());
            // 쿼리 실행
            ResultSet rs = stmt.executeQuery();

            // 조회수 증가를 위한 쿼리문
            PreparedStatement pstmt = con.prepareStatement(DB.SQL_BOARD_VIEW_COUNT);
            // 조회수를 증가할 게시물
            pstmt.setInt(1, board.getBoardIndex());
            // 쿼리 실행
            pstmt.executeUpdate();
            // pstmt 종료
            pstmt.close();

            // 쿼리문으로 호출한 게시물의 정보를 저장
            while (rs.next()) {
                boardInfo = new Board(rs.getString("user_id"), rs.getString("title"), rs.getString("content"), rs.getString("create_time"), rs.getString("update_time"), rs.getInt("board_index"), rs.getInt("view_count"));
                Info = boardInfo.toString();
            }
            // 예외 발생시 종료
        } catch (Exception e) {
            System.out.println("Board Select Error");
        }
        return Info;
    }

    /**
     * 게시글 작성 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 9:41:35
     *
     */
    public Integer insert(Board board) {
        // insert 성공 여부를 확인할 변수
        int result = 0;

        // DB 연결 및 쿼리 호출
        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); 
                PreparedStatement stmt = con.prepareStatement(DB.SQL_BOARD_INSERT);) {

            // 쿼리문에 정보 입력
            stmt.setString(1, board.getUserId());
            stmt.setString(2, board.getTitle());
            stmt.setString(3, board.getContent());

            // 쿼리 실행
            result = stmt.executeUpdate();

            // 예외 발생 시 종료
        } catch (SQLException e) {
            System.out.println("Board Insert Error System exit");
            System.exit(0);
        }
        return result;
    }

    /**
     * 게시글 삭제 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 9:41:40
     *
     */
    public Integer delete(Board board) {
        // delete 성공 여부를 확인할 변수
        int result = 0;

        // DB 연결 및 쿼리 호출
        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); 
                PreparedStatement stmt = con.prepareStatement(DB.SQL_BOARD_DELETE);) {

            // 쿼리문에 정보 입력
            stmt.setInt(1, board.getBoardIndex());

            // 쿼리문 실행
            result = stmt.executeUpdate();

            // 예외 발생 시 종료
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Board Delete Error System exit");
            System.exit(0);
        }

        return result;
    }

    /**
     * 게시글 수정 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 9:41:45
     *
     */
    public Integer update(Board board) {
        // update 성공 여부를 확인할 변수
        int result = 0;

        // DB 연결 및 쿼리 호출
        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); 
                PreparedStatement stmt = con.prepareStatement(DB.SQL_BOARD_UPDATE);) {

            // 쿼리문에 정보 입력
            stmt.setString(1, board.getTitle());
            stmt.setString(2, board.getContent());
            stmt.setInt(3, board.getBoardIndex());

            // 쿼리 실행
            result = stmt.executeUpdate();

            // 예외 발생 시 종료
        } catch (Exception e) {
            System.out.println("Board Update Error System exit");
            System.exit(0);
        }
        return result;
    }
}