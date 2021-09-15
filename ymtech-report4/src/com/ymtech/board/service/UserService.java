package com.ymtech.board.service;

import java.util.List;

import com.ymtech.board.dao.IUserDao;
import com.ymtech.board.dao.impl.UserDao;
import com.ymtech.board.dao.impl.UserDao2;
import com.ymtech.board.vo.User;

/**
 * user의 모든 기능을 사용자에게 입력받는 Class
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 9. 오후 10:23:14
 *
 */
public class UserService {

    // User interface
    private IUserDao userDao;
    private IUserDao userDao2;

    // User 객체 생성
//    private User user = new User();

    // 쿼리 작업을 위한 사용자 입력 값

    // interface 초기화
    public UserService() {
        this.userDao = new UserDao();
        this.userDao2 = new UserDao2();
    }

    /**
     * 유저 생성
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:45:14
     *
     * @return
     */
    public int insert(User user) {

        // 성공 또는 실패 시

        return userDao.insert(user) == 1 ? 1 : -1;
    }

    /**
     * 원하는 유저 출력
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:47:16
     *
     */
    public User select(User user) {

        User user2;
        user2 = userDao.select(user);
        
        

        return user2;
    }

    /**
     * 모든 유저 출력
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:48:17
     *
     */
    public void selectAll() {

        List<User> list = userDao.selectAll();

        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 유저 삭제
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:49:08
     *
     * @return
     */
    public int delete(User user) {

        // 성공 또는 실패 시

        return userDao.delete(user) == 1 ? 1 : -1;
    }

    /**
     * 유저 정보 수정
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:49:56
     *
     * @return
     */
    public int update(User user) {
        // 성공 또는 실패 시
        return userDao.update(user) > 0 ? 1 : -1;
    }

    // <-- UserDao2 -->

    /**
     * 유저 생성
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 13. 오후 2:18:14
     *
     * @param user
     * @return
     */
    public int insertDao2(User user) {

        // 성공 또는 실패 시

        return userDao2.insert(user) == 1 ? 1 : -1;
    }

    /**
     * 원하는 유저 출력
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 13. 오후 2:18:06
     *
     * @param user
     * @return
     */
//    public String selectDao2(User user) {
//
//        String list = userDao2.select(user);
//
//        return userDao2.select(user) != null ? list : null;
//    }

    /**
     * 모든 유저 출력
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 13. 오후 2:17:59
     *
     */
    public void selectAllDao2() {

        List<User> list = userDao2.selectAll();

        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 유저 삭제
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 13. 오후 2:17:53
     *
     * @param user
     * @return
     */
    public int deleteDao2(User user) {

        // 성공 또는 실패 시

        return userDao2.delete(user) == 1 ? 1 : -1;
    }

    /**
     * 유저 정보 수정
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 13. 오후 2:17:45
     *
     * @param user
     * @return
     */
    public int updateDao2(User user) {
        // 성공 또는 실패 시
        return userDao2.update(user) > 0 ? 1 : -1;
    }
}
