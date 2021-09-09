package kr.co.ymtech.dao.ible;

import java.util.List;

import com.ymtech.board.vo.User;

/**
 * User Interface
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 9. 오후 9:22:53
 *
 */
public interface IUserDAO {
    /**
     * 유저 추가 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 9:22:59
     *
     * @param user
     * @return
     */
    public Integer insert (User user);
    
    /**
     * 모든 유저 정보 출력 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 9:24:22
     *
     * @return
     */
    public List<User> selectAll();
    
    /**
     * 원하는 유저 정보 출력 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 9:24:30
     *
     * @param user
     * @return
     */
    public String select(User user);
    
    /**
     * 유저 삭제 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 9:24:38
     *
     * @param user
     * @return
     */
    public Integer delete(User user);
    
    /**
     * 유저 정보 수정 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 9:24:44
     *
     * @param user
     * @return
     */
    public Integer update(User user);
}
