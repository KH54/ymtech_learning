package com.ymtech.board.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ymtech.board.dao.IUserDao;
import com.ymtech.board.vo.User;

/**
 * User Crud
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 15. 오전 11:21:21
 *
 */
public class UserDao extends GenericDao<User, String> implements IUserDao {

    /**
     * 모든 유저를 출력하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 15. 오전 11:21:32
     *
     */
    public List<User> selectAll() {

        try {
            // 상속받은 Generic의 selectAll 메소드의 결과 값을 반환
            return super.selectAll(DB.SQL_USER_SELECT, (rs) -> {
                try {
                    // User에 ResultSet을 매개변수로 하는 생성자의 반환 값을 매개변수로
                    return new User(rs);
                } catch (SQLException ignore) {
                    System.out.println("User selectAll SQL Error");
                }
                return null;
            });
        } catch (SQLException e) {
            System.out.println("User selectAll SQL Error");
            return null;
        }
    }

    /**
     * 입력받은 한 유저만 출력하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 15. 오전 11:21:45
     *
     */
    public User select(User user) {

        try {
            // 상속받은 Generic의 select 메소드의 결과 값을 반환
            return super.select(user.getUserId(), DB.SQL_USER_SELECT_ID, (rs) -> {
                try {
                    // User에 ResultSet을 매개변수로 하는 생성자의 반환 값을 매개변수로
                    return new User(rs);
                } catch (SQLException ignore) {
                    return null;
                }
            });
        } catch (SQLException e) {
            System.out.println("User select SQL Error");
            return null;
        }
    }

    /**
     * 유저를 추가하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 15. 오후 1:24:18
     *
     */
    public Integer insert(User user) {
        // 사용자 입력 값을 저장하기 위한 list
        List<String> list = new ArrayList<String>();

        list.add(user.getUserId());
        list.add(user.getUserPwd());
        list.add(user.getUserNick());

        try {
            // 상속받은 Generic의 insert 메소드의 결과 값을 반환
            return super.insert(DB.SQL_USER_INSERT, list);
        } catch (SQLException e) {
            System.out.println("User insert SQL error");
        }
        return null;
    }

    /**
     * 유저 삭제 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 15. 오후 1:24:32
     *
     */
    public Integer delete(User user) {

        try {
            // 상속받은 Generic의 delete 메소드의 결과 값을 반환
            return super.delete(DB.SQL_USER_DELETE, user.getUserId());
        } catch (SQLException e) {
            System.out.println("User delete SQL error");
        }
        return null;
    }

    /**
     * 유저 수정 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 15. 오후 1:24:46
     *
     */
    public Integer update(User user) {
        // 사용자 입력 값을 저장하기 위한 list
        List<String> list = new ArrayList<>();

        list.add(user.getUserPwd());
        list.add(user.getUserNick());
        list.add(user.getUserId());

        try {
            // 상속받은 Generic의 update 메소드의 결과 값을 반환
            return super.update(DB.SQL_USER_UPDATE, list);
        } catch (SQLException e) {
            System.out.println("User update SQL error");
        }
        return null;
    }

}