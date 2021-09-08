package com.ymtech.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 댓글 CRUD Class
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 8. 오후 4:52:00
 *
 */
public class CommentCRUD {

    // DB Connection 및 데이터 요청 정보
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;

    /**
     * CommentCRUD 객체가 생성될 때 드라이버 로드 및 Connection
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 8. 오후 5:17:38
     *
     */
    public CommentCRUD() {
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
     * 모든 댓글 출력하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 8. 오후 5:19:14
     *
     * @return
     * @throws SQLException
     */
    public List<Comment> select() throws SQLException {

        // 모든 댓글 정보를 담을 list
        ArrayList<Comment> commentList = new ArrayList<Comment>();
        // 댓글 정보를 담을 객체
        Comment commentInfo;

        try {
            // 쿼리 입력 및 호출
            stmt = con.prepareStatement(DB.SQL_COMMENT_SELECT);
            rs = stmt.executeQuery();

            // 쿼리에 저장된 값을 입력
            while (rs.next()) {
                commentInfo = new Comment(rs.getString("user_id"), rs.getString("content"), rs.getString("create_time"), rs.getString("update_time"), rs.getInt("board_index"), rs.getInt("comment_index"), rs.getInt("parent_index"), rs.getInt("depth"),
                        rs.getInt("order"));
                commentList.add(commentInfo);
            }

        } finally {
            // db 종료
            closeDb();
        }
        // 모든 댓글 정보 반환
        return commentList;
    }

    /**
     * 유저 아이디, boardIndex, 내용, 댓글 깊이를 매개변수로 하는 댓글 작성 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오전 12:50:30
     *
     * @param user_id
     * @param boardIndex
     * @param content
     * @param depth
     * @return
     * @throws SQLException
     */
    public Integer insert(String user_id, int boardIndex, String content, int depth) throws SQLException {
        // 작성 성공 여부 반환 변수
        int result = 0;

        try {
            // 쿼리 입력 및 호출
            stmt = con.prepareStatement(DB.SQL_BOARD_INSERT);
            stmt.setString(1, user_id);
            stmt.setInt(2, boardIndex);
            stmt.setString(3, content);
            stmt.setInt(4, depth);

            // 쿼리 결과 입력
            result = stmt.executeUpdate();
        } finally {
            // db 종료
            closeDb();
        }
        return result;
    }

    /**
     * commentIndex를 매개변수로 하는 댓글 삭제 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오전 12:51:46
     *
     * @param board_index
     * @return
     * @throws SQLException
     */
    public Integer delete(int commentIndex) throws SQLException {
        // 삭제 성공 여부 반환 변수
        int result = 0;

        try {
            // 쿼리 입력 및 호출
            stmt = con.prepareStatement(DB.SQL_BOARD_DELETE);
            stmt.setInt(1, commentIndex);

            // 쿼리 결과 입력
            result = stmt.executeUpdate();
        } finally {
            // db 삭제
            closeDb();
        }

        return result;
    }

    /**
     * 내용, commentIndex를 매개변수로 하는 댓글 수정 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오전 12:52:51
     *
     * @param content
     * @param commentIndex
     * @return
     * @throws SQLException
     */
    public Integer update(String content, int commentIndex) throws SQLException {
        // 수정 성공 여부 및 수정 개수 반환 변수
        int result = 0;

        try {
            // 쿼리 입력 및 호출
            stmt = con.prepareStatement(DB.SQL_BOARD_UPDATE);
            stmt.setString(1, content);
            stmt.setInt(2, commentIndex);

            // 쿼리 결과 입력
            result = stmt.executeUpdate();
        } finally {
            // db 종료
            closeDb();
        }

        return result;
    }
}