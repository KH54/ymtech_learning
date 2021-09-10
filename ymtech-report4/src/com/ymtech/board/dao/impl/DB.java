package com.ymtech.board.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DB 연결 및 연결 정보, 쿼리
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 9. 오전 11:36:51
 *
 */
public class DB {

    // DB 연결 정보
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/board";
    public static final String ID = "root";
    public static final String PWD = "eownddlf1704!";
    public static final String DRIVER = "org.mariadb.jdbc.Driver";

    // 유저 쿼리
    public static final String SQL_USER_INSERT = "INSERT INTO user(user_id, password, nickname) values(?,?,?)";
    public static final String SQL_USER_DELETE = "DELETE FROM user WHERE user_id = ?";
    public static final String SQL_USER_UPDATE = "UPDATE user SET password = ?, nickname = ? WHERE user_id = ?";
    public static final String SQL_USER_SELECT = "SELECT * FROM user";
    public static final String SQL_USER_SELECT_ID = "SELECT * FROM  `user` WHERE `user_id` = ?"; 
    public static final String SQL_USER_SELECT_PW = "SELECT password FROM user WHERE user_id =?";
 

    // 게시글 쿼리
    public static final String SQL_BOARD_INSERT = "INSERT INTO board(user_id, title, content) values(?,?,?)";
    public static final String SQL_BOARD_DELETE = "DELETE FROM board WHERE board_index = ?";
    public static final String SQL_BOARD_UPDATE = "UPDATE board SET title = ?, content = ? WHERE board_index = ?";
    public static final String SQL_BOARD_SELECT = "SELECT * FROM board WHERE board_index = ?";
    public static final String SQL_BOARD_SELECT_ALL = "SELECT * FROM board";
    public static final String SQL_BOARD_VIEW_COUNT = "UPDATE board SET view_count = view_count + 1 WHERE board_index =?";

    // 댓글 쿼리
    public static final String SQL_COMMENT_INSERT = "INSERT INTO comment(user_id, board_index, content, parent_index) values(?,?,?,?)";
    public static final String SQL_COMMENT_DELETE = "DELETE FROM comment WHERE comment_index =?";
    public static final String SQL_COMMENT_UPDATE = "UPDATE comment SET content = ? WHERE comment_index = ?";
    public static final String SQL_COMMENT_SELECT = "SELECT * FROM comment";

    /**
     * DB 연결
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 9:40:14
     *
     * @return
     */
    public Connection connectDB() {
        
        Connection connection = null;

        
        try {
            connection = DriverManager.getConnection(URL, ID, PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return connection;
    }
    
    /**
     * DB 연결 해제
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 9:40:19
     *
     * @param resultSet
     * @param statement
     * @param connection
     */
    public void closeDB(ResultSet resultSet, PreparedStatement statement, Connection connection) {
        try {
            // 자원이 있다면 해제
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
        }
    }
}