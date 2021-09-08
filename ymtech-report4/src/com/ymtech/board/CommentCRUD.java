package com.ymtech.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ��� CRUD Class
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 8. ���� 4:52:00
 *
 */
public class CommentCRUD {

    // DB Connection �� ������ ��û ����
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;

    /**
     * CommentCRUD ��ü�� ������ �� ����̹� �ε� �� Connection
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 8. ���� 5:17:38
     *
     */
    public CommentCRUD() {
        try {
            Class.forName(DB.DRIVER);
            con = DriverManager.getConnection(DB.URL, DB.ID, DB.PW);
            System.out.println("�����ͺ��̽� ���� �Ϸ�");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * DB ��� �� �ڿ� �ݳ�
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 8. ���� 5:18:52
     *
     * @throws SQLException
     */
    public void closeDb() throws SQLException {
        if (con != null) // con�� �����ִ� ���
            con.close();
        if (stmt != null) // stmt�� �����ִ� ���
            stmt.close();
        if (rs != null) // rs�� �����ִ� ���
            rs.close();
    }

    /**
     * ��� ��� ����ϴ� �޼ҵ�
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 8. ���� 5:19:14
     *
     * @return
     * @throws SQLException
     */
    public List<Comment> select() throws SQLException {

        // ��� ��� ������ ���� list
        ArrayList<Comment> commentList = new ArrayList<Comment>();
        // ��� ������ ���� ��ü
        Comment commentInfo;

        try {
            // ���� �Է� �� ȣ��
            stmt = con.prepareStatement(DB.SQL_COMMENT_SELECT);
            rs = stmt.executeQuery();

            // ������ ����� ���� �Է�
            while (rs.next()) {
                commentInfo = new Comment(rs.getString("user_id"), rs.getString("content"), rs.getString("create_time"), rs.getString("update_time"), rs.getInt("board_index"), rs.getInt("comment_index"), rs.getInt("parent_index"), rs.getInt("depth"),
                        rs.getInt("order"));
                commentList.add(commentInfo);
            }

        } finally {
            // db ����
            closeDb();
        }
        // ��� ��� ���� ��ȯ
        return commentList;
    }

    /**
     * ���� ���̵�, boardIndex, ����, ��� ���̸� �Ű������� �ϴ� ��� �ۼ� �޼ҵ�
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. ���� 12:50:30
     *
     * @param user_id
     * @param boardIndex
     * @param content
     * @param depth
     * @return
     * @throws SQLException
     */
    public Integer insert(String user_id, int boardIndex, String content, int depth) throws SQLException {
        // �ۼ� ���� ���� ��ȯ ����
        int result = 0;

        try {
            // ���� �Է� �� ȣ��
            stmt = con.prepareStatement(DB.SQL_BOARD_INSERT);
            stmt.setString(1, user_id);
            stmt.setInt(2, boardIndex);
            stmt.setString(3, content);
            stmt.setInt(4, depth);

            // ���� ��� �Է�
            result = stmt.executeUpdate();
        } finally {
            // db ����
            closeDb();
        }
        return result;
    }

    /**
     * commentIndex�� �Ű������� �ϴ� ��� ���� �޼ҵ�
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. ���� 12:51:46
     *
     * @param board_index
     * @return
     * @throws SQLException
     */
    public Integer delete(int commentIndex) throws SQLException {
        // ���� ���� ���� ��ȯ ����
        int result = 0;

        try {
            // ���� �Է� �� ȣ��
            stmt = con.prepareStatement(DB.SQL_BOARD_DELETE);
            stmt.setInt(1, commentIndex);

            // ���� ��� �Է�
            result = stmt.executeUpdate();
        } finally {
            // db ����
            closeDb();
        }

        return result;
    }

    /**
     * ����, commentIndex�� �Ű������� �ϴ� ��� ���� �޼ҵ�
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. ���� 12:52:51
     *
     * @param content
     * @param commentIndex
     * @return
     * @throws SQLException
     */
    public Integer update(String content, int commentIndex) throws SQLException {
        // ���� ���� ���� �� ���� ���� ��ȯ ����
        int result = 0;

        try {
            // ���� �Է� �� ȣ��
            stmt = con.prepareStatement(DB.SQL_BOARD_UPDATE);
            stmt.setString(1, content);
            stmt.setInt(2, commentIndex);

            // ���� ��� �Է�
            result = stmt.executeUpdate();
        } finally {
            // db ����
            closeDb();
        }

        return result;
    }
}