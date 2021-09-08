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
 * 유저 정보 CRUD Class
 * 
 * @author "KyungHun Park"
 * @since 2021. 9. 8.
 *
 */
public class UserCRUD {

    // DB Connection 및 데이터 요청 정보
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;

    // 사용자에게 값을 입력 받을 Scanner
    private Scanner inputInfo = new Scanner(System.in);

    /**
     * 
     * 드라이버 로드 및 UserCRUD 객체가 생성될 때 Connection
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 8.
     *
     */
    public UserCRUD() {

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
     * @since 2021. 9. 8.
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
     * 저장된 User들의 정보를 모두 출력
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 8.
     *
     * @return
     * @throws SQLException
     */
    public List<User> selectAll() throws SQLException {

        // 모든 유저의 정보를 담을 list
        ArrayList<User> userList = new ArrayList<User>();
        // 개인 유저의 정보를 담을 객체
        User userInfo;

        try {
            // USER의 모든 정보를 불러올 SELECT Query
            stmt = con.prepareStatement(DB.SQL_USER_SELECT);
            rs = stmt.executeQuery();

            // 쿼리에 저장된 값을 입력
            while (rs.next()) {

                // 개인 유저의 정보를 입력
                userInfo = new User(rs.getString("user_id"), rs.getString("password"), rs.getString("nickname"));
                // 개인 유저의 정보를 list에 입력
                userList.add(userInfo);
            }
        } finally {
            // db 종료
            closeDb();
        }
        // 모든 유저의 정보 반환
        return userList;
    }

    /**
     * 원하는 ID의 정보를 출력
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 8.
     *
     * @param userId
     * @return
     * @throws SQLException
     */
    public User select(String userId) throws SQLException {
        // 유저 정보를 담을 객체
        User userInfo = null;

        try {
            // 입력받은 user의 정보를 불러올 쿼리
            stmt = con.prepareStatement(DB.SQL_USER_SELECT_ID);
            stmt.setString(1, userId);
            rs = stmt.executeQuery();

            // 불러온 유저의 정보를 userInfo에 입력
            while (rs.next()) {
                userInfo = new User(rs.getString("user_id"), rs.getString("password"), rs.getString("nickname"));
            }
        } finally {
            // db 종료
            closeDb();
        }
        // 매개변수로 받은 유저의 정보를 반환
        return userInfo;
    }

    /**
     * 유저를 추가하는 메소드
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 8.
     *
     * @param user
     * @return 생성에 성공하면 1, 실패하면 0을 반환
     * @throws SQLException
     */
    public Integer insert() throws SQLException {
        // 실행 결과를 저장할 변수 성공하면 1, 실패하면 0
        int result = 0;

        // 추가할 유저 정보를 담을 객체
        User userInsert = new User();

        // 유저 정보 입력
        System.out.print("아이디입력 : ");
        userInsert.setUserId(inputInfo.next());

        System.out.print("비밀번호 입력 : ");
        userInsert.setUserPw(inputInfo.next());

        System.out.print("닉네임 입력 : ");
        userInsert.setUserNick(inputInfo.next());

        try {
            // insert 쿼리
            stmt = con.prepareStatement(DB.SQL_USER_INSERT);

            // 입력받은 정보 쿼리에 입력
            stmt.setString(1, userInsert.getUserId());
            stmt.setString(2, userInsert.getUserPw());
            stmt.setString(3, userInsert.getUserNick());

            // 성공 실패 여부
            result = stmt.executeUpdate();
        } finally {
            // db 종료
            closeDb();
        }
        return result;
    }

    /**
     * 삭제할 ID를 입력 받아 비밀번호와 일치하면 삭제하는 메소드
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 8.
     *
     * @param userId 삭제할 id
     * @return 성공하면 1, 실패하면 0 반환
     * @throws SQLException
     */
    public Integer delete(String userId) throws SQLException {
        // 실행 결과를 저장할 변수 성공하면 1, 실패하면 0
        int result = 0;

        // 유저 삭제 객체 생성
        User userDelete = new User();

        // 삭제할 id의 비밀번호 요구
        System.out.print("삭제할 아이디의 비밀번호 입력 : ");
        userDelete.setUserPw(inputInfo.next());

        try {
            // delete 쿼리
            stmt = con.prepareStatement(DB.SQL_USER_DELETE);
            // DB에 id의 비밀번호 요청
            rs = stmt.executeQuery("SELECT password FROM user WHERE user_id ='" + userId + "'");

            // id가 일치하면
            if (rs.next()) {
                // id의 비밀번호가 일치한지 확인
                if (rs.getString(1).contentEquals(userDelete.getUserPw())) {

                    // 쿼리에 id 정보 입력
                    stmt.setString(1, userDelete.getUserId());
                    // 삭제 실행
                    stmt.executeUpdate();
                    // 성공 실패 여부
                    result = stmt.executeUpdate();
                } else {
                    // id는 존재하지만 비밀번호가 일치하지 않는 경우
                    System.out.println("비밀번호가 맞지 않습니다.");
                }
            } else {
                // id가 존재하지 않는 경우
                System.out.println("해당하는 아이디가 없습니다.");
            }
        } finally {
            // db 종료
            closeDb();
        }
        return result;
    }

    /**
     * 유저의 정보를 변경하는 메소드
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 8.
     *
     * @param userId
     * @return 변경한 수만큼 +1, 변경이 없는 경우(또는 실패) 0
     * @throws SQLException
     */
    public Integer update(String userId) throws SQLException {
        // 실행 결과를 저장할 변수 성공하면 1이상, 실패 또는 변경이 없는 경우 0
        int result = 0;
        
        //유저 업데이트 객체 생성
        User userUpdate = new User();
        
        // 삭제할 ID의 비밀번호 요청
        System.out.println("업데이트 할 아이디의 비밀번호 입력 : ");
        userUpdate.setUserPw(inputInfo.next());

        try {
            // update 쿼리
            stmt = con.prepareStatement(DB.SQL_USER_UPDATE);
            // DB에 업데이트할 유저의 비밀번호 요청
            rs = stmt.executeQuery("SELECT password FROM user WHERE user_id ='" + userUpdate.getUserId() + "'");
            
            // 변경할 id가 있는 경우
            if (rs.next()) {
                // id와 비밀번호가 일치한지 확인
                if (rs.getString(1).contentEquals(userUpdate.getUserPw())) {

                    // 사용자에게 변경할 데이터 요청
                    System.out.println("변경할 비밀번호 입력");
                    userUpdate.setUserPw(inputInfo.next());
                    System.out.println("변경할 별명 입력");
                    userUpdate.setUserNick(inputInfo.next());

                    // 쿼리에 입력받은 변경할 정보 입력
                    stmt.setString(1, userUpdate.getUserPw());
                    stmt.setString(2, userUpdate.getUserNick());
                    stmt.setString(3, userUpdate.getUserId());

                    // 쿼리 실행
                    result = stmt.executeUpdate();

                } else {
                    // id는 존재하고 pw가 일치하지 않는 경우
                    System.out.println("비밀번호가 맞지 않습니다.");
                }
            } else {
                // id가 존재하지 않는 경우
                System.out.println("해당하는 아이디가 없습니다.");
            }
        } finally {
            // db 종료
            closeDb();
        }
        return result;
    }
}
