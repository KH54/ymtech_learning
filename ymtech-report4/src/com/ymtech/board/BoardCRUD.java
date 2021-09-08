package com.ymtech.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * �Խ��� CRUD
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 9. ���� 12:41:55
 *
 */
public class BoardCRUD {

    // DB Connection �� ������ ��û ����
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;

    /**
     * BoardCRUD ��ü�� ������ �� ����̹� �ε� �� Connection
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 8. ���� 5:17:38
     *
     */
    public BoardCRUD() {
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
     * ��� �Խñ��� ����ϴ� �޼ҵ�
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 8. ���� 5:19:14
     *
     * @return
     * @throws SQLException
     */
    public List<Board> selectAll() throws SQLException {

        // ��� �Խñ� ������ ���� list
        ArrayList<Board> boardList = new ArrayList<Board>();
        // �Խñ� ������ ���� ��ü
        Board boardInfo;

        try {
            // Board�� ��� ������ �ҷ��� SELECT ����
            stmt = con.prepareStatement(DB.SQL_BOARD_SELECT);
            rs = stmt.executeQuery();

            // ������ ����� ���� �Է�
            while (rs.next()) {
                boardInfo = new Board(rs.getString("user_id"), rs.getString("title"), rs.getString("content"), rs.getString("create_time"), rs.getString("update_time"), rs.getInt("board_index"), rs.getInt("view_count"));
                boardList.add(boardInfo);
            }

        } finally {
            // db ����
            closeDb();
        }
        // ��� �Խñ� ���� ��ȯ
        return boardList;
    }

    /**
     * ������ �Խñ��� ����ϴ� �޼ҵ�
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. ���� 12:42:26
     *
     * @param boardIndex
     * @return
     * @throws SQLException
     */
    public Board select(int boardIndex) throws SQLException {

        // �Խñ� ������ ���� ��ü
        Board boardInfo = null;

        try {
            // ��ȸ�� ����
            stmt = con.prepareStatement(DB.SQL_BOARD_VIEW_COUNT);
            stmt.setInt(1, boardIndex);
            stmt.executeUpdate();
            stmt.close();

            // ���� ����
            stmt = con.prepareStatement(DB.SQL_BOARD_SELECT);
            stmt.setInt(1, boardIndex);

            // �ش��ϴ� �Խù��� ���� ��û
            while (rs.next()) {
                boardInfo = new Board(rs.getString("user_id"), rs.getString("title"), rs.getString("content"), rs.getString("create_time"), rs.getString("update_time"), rs.getInt("board_index"), rs.getInt("view_count"));
            }
        } finally {
            // db ����
            closeDb();
        }
        return boardInfo;
    }

    /**
     * ���� ������ ����, ������ �Ű������� �ϴ� �Խñ� �Է� �޼ҵ�
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. ���� 12:44:07
     *
     * @param user_id
     * @param title
     * @param content
     * @return
     * @throws SQLException
     */
    public Integer insert(String user_id, String title, String content) throws SQLException {
        // �Է¿� �����ߴ��� Ȯ���ϱ� ���� ����
        int result = 0;

        try {
            // ���� ȣ�� �� �Է�
            stmt = con.prepareStatement(DB.SQL_BOARD_INSERT);
            stmt.setString(1, user_id);
            stmt.setString(2, title);
            stmt.setString(3, content);

            // �Է� ���� ����
            result = stmt.executeUpdate();
        } finally {
            // db ����
            closeDb();
        }
        return result;
    }

    /**
     * boardIndex�� �Ű������� �ϴ� �Խñ� ���� �޼ҵ�
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. ���� 12:45:18
     *
     * @param board_index
     * @return
     * @throws SQLException
     */
    public Integer delete(int board_index) throws SQLException {
        // ���� ���� ���θ� Ȯ���ϱ� ���� ����
        int result = 0;

        try {
            // ���� ȣ�� �� �Է�
            stmt = con.prepareStatement(DB.SQL_BOARD_DELETE);
            stmt.setInt(1, board_index);

            // ���� ���� ����
            result = stmt.executeUpdate();
        } finally {
            // db ����
            closeDb();
        }

        return result;
    }

    /**
     * ����, ����, boardIndex�� �Ű������� �ϴ� �Խñ� ���� �޼ҵ�
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. ���� 12:46:16
     *
     * @param title
     * @param content
     * @param boardIndex
     * @return
     * @throws SQLException
     */
    public Integer update(String title, String content, int boardIndex) throws SQLException {

        // ���� ���� ���� �� ������ ����
        int result = 0;

        try {
            // ���� ȣ�� �� �Է�
            stmt = con.prepareStatement(DB.SQL_BOARD_UPDATE);
            stmt.setString(1, title);
            stmt.setString(2, content);
            stmt.setInt(3, boardIndex);

            // ���� ���� �� ���� ����
            result = stmt.executeUpdate();
        } finally {
            // db ����
            closeDb();
        }

        return result;
    }
}