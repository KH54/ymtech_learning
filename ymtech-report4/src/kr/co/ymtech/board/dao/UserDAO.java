package kr.co.ymtech.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ymtech.board.vo.User;

import kr.co.ymtech.board.dao.ible.IUserDAO;
/**
 * User의 crud
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 9. 오후 9:39:03
 *
 */
public class UserDAO implements IUserDAO {

    /**
     * 모든 유저 정보를 출력하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:03:59
     *
     */
    public List<User> selectAll() {

        // 모든 유저의 정보를 담을 list
        ArrayList<User> userList = new ArrayList<User>();
        // 유저 정보를 담을 userInfo
        User userInfo;

        // DB 연결 및 쿼리 호출 실행
        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); 
                PreparedStatement stmt = con.prepareStatement(DB.SQL_USER_SELECT); 
                ResultSet rs = stmt.executeQuery();) {
            
            // 쿼리문의 결과를 출력하여 저장
            while (rs.next()) {
                userInfo = new User(rs.getString("user_id"), rs.getString("password"), rs.getString("nickname"));
                userList.add(userInfo);
            }
            // 예외 발생시 종료
        } catch(Exception e) {
            System.out.println("User selectAll Error");
            System.exit(0);
        }
        return userList;
    }

    /**
     * 원하는 유저의 정보를 출력하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:06:18
     *
     */
    public String select(User user) {
        
        // 선택한 유저의 정보를 담을 객체
        User userInfo = null;
        // 담은 정보를 String으로 저장
        String Info = null;
        
        // DB 연결 및 쿼리 호출
        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); 
                PreparedStatement stmt = con.prepareStatement(DB.SQL_USER_SELECT_ID); ) {

            // 입력받은 ID를 쿼리에 입력
            stmt.setString(1, user.getUserId());
            // 쿼리 실행
            ResultSet rs = stmt.executeQuery();
     
            // 쿼리문으로 호출한 게시물의 정보를 저장
            while (rs.next()) {
                userInfo = new User(rs.getString("user_id"), rs.getString("password"), rs.getString("nickname"));
                Info = userInfo.toString();
            }

        }  // 예외 발생 시 종료
         catch (Exception e) {
           System.out.println("User select Error");
        } 
        return Info;
    }

    /**
     * 유저 추가 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:08:37
     *
     */
    public Integer insert(User user) {
        // insert 성공 여부를 확인할 변수
        int result = 0;

        // DB 연결 및 쿼리 호출
        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); 
                PreparedStatement stmt = con.prepareStatement(DB.SQL_USER_INSERT);) {

            // 쿼리문에 정보 입력
            stmt.setString(1, user.getUserId());
            stmt.setString(2, user.getUserPwd());
            stmt.setString(3, user.getUserNick());
            
            // 쿼리 실행
            result = stmt.executeUpdate();
            
            // 중복된 ID 값을 입력한 경우
        } catch (SQLException se) { 
           System.out.println("중복된 id가 있습니다. 다시 입력해주세요");
            // 다른 예외 발생시 종료
        }  catch( Exception e) {
            System.out.println("User insert Error");
            System.exit(0);
        }
        return result;
    }

    /**
     * 유저 삭제 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:11:41
     *
     */
    public Integer delete(User user) {

        // delete 성공 여부를 확인할 변수
        int result = 0;

        // DB 연결 및 쿼리 호출
        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); 
                PreparedStatement stmt = con.prepareStatement(DB.SQL_USER_DELETE);) {

            // 쿼리문에 정보 입력
            stmt.setString(1, user.getUserId());
            
            // 쿼리 실행
            result = stmt.executeUpdate();

            // 예외 발생 시 종료
        } catch (Exception e) { 
            System.out.println("User delete Error");
            System.exit(0);
        }
        return result;
    }

    /**
     * 유저 정보 수정 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:13:43
     *
     */
    public Integer update(User user) {
        // update 성공 여부를 확인할 변수
        int result = 0;

        // DB 연결 및 쿼리 호출
        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); 
                PreparedStatement stmt = con.prepareStatement(DB.SQL_USER_UPDATE); ) {

            // 쿼리문에 정보 입력
            stmt.setString(1, user.getUserPwd());
            stmt.setString(2, user.getUserNick());
            stmt.setString(3, user.getUserId());

            // 쿼리 실행
            result = stmt.executeUpdate();

            // 예외 발생 시 종료
        } catch (Exception e) { 
          System.out.println("User update Error");
            System.exit(0);
        }
        return result;
    }

}
