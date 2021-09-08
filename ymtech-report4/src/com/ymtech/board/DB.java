package com.ymtech.board;

/**
 * DB�� ������ �ۼ����� ���� Class
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 9. ���� 8:54:10
 *
 */
public class DB {

    // DB ������ ���� ����
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/board";
    public static final String ID = "root";
    public static final String PW = "eownddlf1704!";
    public static final String DRIVER = "org.mariadb.jdbc.Driver";

    // ���� CRUD�� ����
    public static final String SQL_USER_INSERT = "INSERT INTO user(user_id, password, nickname) values(?,?,?)";
    public static final String SQL_USER_DELETE = "DELETE FROM user WHERE user_id = ?";
    public static final String SQL_USER_UPDATE = "UPDATE user SET password = ?, nickname = ? WHERE user_id = ?";
    public static final String SQL_USER_SELECT = "SELECT * FROM user";
    public static final String SQL_USER_SELECT_ID = "SELECT * FROM user ORDER BY user_id = ?";

    // �Խñ� CRUD�� ����
    public static final String SQL_BOARD_INSERT = "INSERT INTO board(user_id, title, content) values(?,?,?)";
    public static final String SQL_BOARD_DELETE = "DELETE FROM board WHERE board_index = ?";
    public static final String SQL_BOARD_UPDATE = "UPDATE board SET title = ?, content = ? WHERE board_index = ?";
    public static final String SQL_BOARD_SELECT = "SELECT * FROM board ORDER BY board_index = ?";
    public static final String SQL_BOARD_SELECT_ALL = "SELECT * FROM board";
    public static final String SQL_BOARD_VIEW_COUNT = "UPDATE board SET view_count = view_count + 1 WHERE user_id";

    // ��� CRUD�� ����
    public static final String SQL_COMMENT_INSERT = "INSERT INTO comment(user_id, board_index, content, depth) values(?,?,?,?);";
    public static final String SQL_COMMENT_DELETE = "DELETE FROM comment WHERE comment_index =?";
    public static final String SQL_COMMENT_UPDATE = "UPDATE comment SET content = ? WHERE comment_index = ?";
    public static final String SQL_COMMENT_SELECT = "SELECT * FROM comment";

}