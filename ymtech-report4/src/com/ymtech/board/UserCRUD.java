package com.ymtech.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ���� ���� CRUD Class
 * 
 * @author "KyungHun Park"
 * @since 2021. 9. 8.
 *
 */
public class UserCRUD {

    // DB Connection �� ������ ��û ����
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;

    // ����ڿ��� ���� �Է� ���� Scanner
    private Scanner inputInfo = new Scanner(System.in);

    /**
     * 
     * ����̹� �ε� �� UserCRUD ��ü�� ������ �� Connection
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 8.
     *
     */
    public UserCRUD() {

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
     * @since 2021. 9. 8.
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
     * ����� User���� ������ ��� ���
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 8.
     *
     * @return
     * @throws SQLException
     */
    public List<User> selectAll() throws SQLException {

        // ��� ������ ������ ���� list
        ArrayList<User> userList = new ArrayList<User>();
        // ���� ������ ������ ���� ��ü
        User userInfo;

        try {
            // USER�� ��� ������ �ҷ��� SELECT Query
            stmt = con.prepareStatement(DB.SQL_USER_SELECT);
            rs = stmt.executeQuery();

            // ������ ����� ���� �Է�
            while (rs.next()) {

                // ���� ������ ������ �Է�
                userInfo = new User(rs.getString("user_id"), rs.getString("password"), rs.getString("nickname"));
                // ���� ������ ������ list�� �Է�
                userList.add(userInfo);
            }
        } finally {
            // db ����
            closeDb();
        }
        // ��� ������ ���� ��ȯ
        return userList;
    }

    /**
     * ���ϴ� ID�� ������ ���
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 8.
     *
     * @param userId
     * @return
     * @throws SQLException
     */
    public User select(String userId) throws SQLException {
        // ���� ������ ���� ��ü
        User userInfo = null;

        try {
            // �Է¹��� user�� ������ �ҷ��� ����
            stmt = con.prepareStatement(DB.SQL_USER_SELECT_ID);
            stmt.setString(1, userId);
            rs = stmt.executeQuery();

            // �ҷ��� ������ ������ userInfo�� �Է�
            while (rs.next()) {
                userInfo = new User(rs.getString("user_id"), rs.getString("password"), rs.getString("nickname"));
            }
        } finally {
            // db ����
            closeDb();
        }
        // �Ű������� ���� ������ ������ ��ȯ
        return userInfo;
    }

    /**
     * ������ �߰��ϴ� �޼ҵ�
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 8.
     *
     * @param user
     * @return ������ �����ϸ� 1, �����ϸ� 0�� ��ȯ
     * @throws SQLException
     */
    public Integer insert() throws SQLException {
        // ���� ����� ������ ���� �����ϸ� 1, �����ϸ� 0
        int result = 0;

        // �߰��� ���� ������ ���� ��ü
        User userInsert = new User();

        // ���� ���� �Է�
        System.out.print("���̵��Է� : ");
        userInsert.setUserId(inputInfo.next());

        System.out.print("��й�ȣ �Է� : ");
        userInsert.setUserPw(inputInfo.next());

        System.out.print("�г��� �Է� : ");
        userInsert.setUserNick(inputInfo.next());

        try {
            // insert ����
            stmt = con.prepareStatement(DB.SQL_USER_INSERT);

            // �Է¹��� ���� ������ �Է�
            stmt.setString(1, userInsert.getUserId());
            stmt.setString(2, userInsert.getUserPw());
            stmt.setString(3, userInsert.getUserNick());

            // ���� ���� ����
            result = stmt.executeUpdate();
        } finally {
            // db ����
            closeDb();
        }
        return result;
    }

    /**
     * ������ ID�� �Է� �޾� ��й�ȣ�� ��ġ�ϸ� �����ϴ� �޼ҵ�
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 8.
     *
     * @param userId ������ id
     * @return �����ϸ� 1, �����ϸ� 0 ��ȯ
     * @throws SQLException
     */
    public Integer delete(String userId) throws SQLException {
        // ���� ����� ������ ���� �����ϸ� 1, �����ϸ� 0
        int result = 0;

        // ���� ���� ��ü ����
        User userDelete = new User();

        // ������ id�� ��й�ȣ �䱸
        System.out.print("������ ���̵��� ��й�ȣ �Է� : ");
        userDelete.setUserPw(inputInfo.next());

        try {
            // delete ����
            stmt = con.prepareStatement(DB.SQL_USER_DELETE);
            // DB�� id�� ��й�ȣ ��û
            rs = stmt.executeQuery("SELECT password FROM user WHERE user_id ='" + userId + "'");

            // id�� ��ġ�ϸ�
            if (rs.next()) {
                // id�� ��й�ȣ�� ��ġ���� Ȯ��
                if (rs.getString(1).contentEquals(userDelete.getUserPw())) {

                    // ������ id ���� �Է�
                    stmt.setString(1, userDelete.getUserId());
                    // ���� ����
                    stmt.executeUpdate();
                    // ���� ���� ����
                    result = stmt.executeUpdate();
                } else {
                    // id�� ���������� ��й�ȣ�� ��ġ���� �ʴ� ���
                    System.out.println("��й�ȣ�� ���� �ʽ��ϴ�.");
                }
            } else {
                // id�� �������� �ʴ� ���
                System.out.println("�ش��ϴ� ���̵� �����ϴ�.");
            }
        } finally {
            // db ����
            closeDb();
        }
        return result;
    }

    /**
     * ������ ������ �����ϴ� �޼ҵ�
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 8.
     *
     * @param userId
     * @return ������ ����ŭ +1, ������ ���� ���(�Ǵ� ����) 0
     * @throws SQLException
     */
    public Integer update(String userId) throws SQLException {
        // ���� ����� ������ ���� �����ϸ� 1�̻�, ���� �Ǵ� ������ ���� ��� 0
        int result = 0;
        
        //���� ������Ʈ ��ü ����
        User userUpdate = new User();
        
        // ������ ID�� ��й�ȣ ��û
        System.out.println("������Ʈ �� ���̵��� ��й�ȣ �Է� : ");
        userUpdate.setUserPw(inputInfo.next());

        try {
            // update ����
            stmt = con.prepareStatement(DB.SQL_USER_UPDATE);
            // DB�� ������Ʈ�� ������ ��й�ȣ ��û
            rs = stmt.executeQuery("SELECT password FROM user WHERE user_id ='" + userUpdate.getUserId() + "'");
            
            // ������ id�� �ִ� ���
            if (rs.next()) {
                // id�� ��й�ȣ�� ��ġ���� Ȯ��
                if (rs.getString(1).contentEquals(userUpdate.getUserPw())) {

                    // ����ڿ��� ������ ������ ��û
                    System.out.println("������ ��й�ȣ �Է�");
                    userUpdate.setUserPw(inputInfo.next());
                    System.out.println("������ ���� �Է�");
                    userUpdate.setUserNick(inputInfo.next());

                    // ������ �Է¹��� ������ ���� �Է�
                    stmt.setString(1, userUpdate.getUserPw());
                    stmt.setString(2, userUpdate.getUserNick());
                    stmt.setString(3, userUpdate.getUserId());

                    // ���� ����
                    result = stmt.executeUpdate();

                } else {
                    // id�� �����ϰ� pw�� ��ġ���� �ʴ� ���
                    System.out.println("��й�ȣ�� ���� �ʽ��ϴ�.");
                }
            } else {
                // id�� �������� �ʴ� ���
                System.out.println("�ش��ϴ� ���̵� �����ϴ�.");
            }
        } finally {
            // db ����
            closeDb();
        }
        return result;
    }
}
