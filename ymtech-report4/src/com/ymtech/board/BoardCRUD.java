package com.ymtech.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 게시판 CRUD
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 9. 오전 12:41:55
 *
 */
public class BoardCRUD {

    // DB Connection 및 데이터 요청 정보
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;

    /**
     * BoardCRUD 객체가 생성될 때 드라이버 로드 및 Connection
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 8. 오후 5:17:38
     *
     */
    public BoardCRUD() {
        try {
            Class.forName(DB.DRIVER);
            con = DriverManager.getConnection(DB.URL, DB.ID, DB.PW);
            System.out.println("데이터베이스 연결 완료");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * DB 사용 후 자원 반납
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 8. 오후 5:18:52
     *
     * @throws SQLException
     */
    public void closeDb() throws SQLException {
        if (con != null) // con이 열려있는 경우
            con.close();
        if (stmt != null) // stmt가 열려있는 경우
            stmt.close();
        if (rs != null) // rs가 열려있는 경우
            rs.close();
    }

    /**
     * 모든 게시글을 출력하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 8. 오후 5:19:14
     *
     * @return
     * @throws SQLException
     */
    public List<Board> selectAll() throws SQLException {

        // 모든 게시글 정보를 담을 list
        ArrayList<Board> boardList = new ArrayList<Board>();
        // 게시글 정보를 담을 객체
        Board boardInfo;

        try {
            // Board의 모든 정보를 불러올 SELECT 쿼리
            stmt = con.prepareStatement(DB.SQL_BOARD_SELECT);
            rs = stmt.executeQuery();

            // 쿼리에 저장된 값을 입력
            while (rs.next()) {
                boardInfo = new Board(rs.getString("user_id"), rs.getString("title"), rs.getString("content"), rs.getString("create_time"), rs.getString("update_time"), rs.getInt("board_index"), rs.getInt("view_count"));
                boardList.add(boardInfo);
            }

        } finally {
            // db 종료
            closeDb();
        }
        // 모든 게시글 정보 반환
        return boardList;
    }

    /**
     * 선택한 게시글을 출력하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오전 12:42:26
     *
     * @param boardIndex
     * @return
     * @throws SQLException
     */
    public Board select(int boardIndex) throws SQLException {

        // 게시글 정보를 담을 객체
        Board boardInfo = null;

        try {
            // 조회수 증가
            stmt = con.prepareStatement(DB.SQL_BOARD_VIEW_COUNT);
            stmt.setInt(1, boardIndex);
            stmt.executeUpdate();
            stmt.close();

            // 쿼리 실행
            stmt = con.prepareStatement(DB.SQL_BOARD_SELECT);
            stmt.setInt(1, boardIndex);

            // 해당하는 게시물의 정보 요청
            while (rs.next()) {
                boardInfo = new Board(rs.getString("user_id"), rs.getString("title"), rs.getString("content"), rs.getString("create_time"), rs.getString("update_time"), rs.getInt("board_index"), rs.getInt("view_count"));
            }
        } finally {
            // db 종료
            closeDb();
        }
        return boardInfo;
    }

    /**
     * 유저 정보와 제목, 내용을 매개변수로 하는 게시글 입력 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오전 12:44:07
     *
     * @param user_id
     * @param title
     * @param content
     * @return
     * @throws SQLException
     */
    public Integer insert(String user_id, String title, String content) throws SQLException {
        // 입력에 성공했는지 확인하기 위한 변수
        int result = 0;

        try {
            // 쿼리 호출 및 입력
            stmt = con.prepareStatement(DB.SQL_BOARD_INSERT);
            stmt.setString(1, user_id);
            stmt.setString(2, title);
            stmt.setString(3, content);

            // 입력 성공 여부
            result = stmt.executeUpdate();
        } finally {
            // db 종료
            closeDb();
        }
        return result;
    }

    /**
     * boardIndex를 매개변수로 하는 게시글 삭제 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오전 12:45:18
     *
     * @param board_index
     * @return
     * @throws SQLException
     */
    public Integer delete(int board_index) throws SQLException {
        // 삭제 성공 여부를 확인하기 위한 변수
        int result = 0;

        try {
            // 쿼리 호출 및 입력
            stmt = con.prepareStatement(DB.SQL_BOARD_DELETE);
            stmt.setInt(1, board_index);

            // 삭제 성공 여부
            result = stmt.executeUpdate();
        } finally {
            // db 종료
            closeDb();
        }

        return result;
    }

    /**
     * 제목, 내용, boardIndex를 매개변수로 하는 게시글 수정 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오전 12:46:16
     *
     * @param title
     * @param content
     * @param boardIndex
     * @return
     * @throws SQLException
     */
    public Integer update(String title, String content, int boardIndex) throws SQLException {

        // 수정 성공 여부 및 수정된 개수
        int result = 0;

        try {
            // 쿼리 호출 및 입력
            stmt = con.prepareStatement(DB.SQL_BOARD_UPDATE);
            stmt.setString(1, title);
            stmt.setString(2, content);
            stmt.setInt(3, boardIndex);

            // 성공 여부 및 수정 개수
            result = stmt.executeUpdate();
        } finally {
            // db 종료
            closeDb();
        }

        return result;
    }
}