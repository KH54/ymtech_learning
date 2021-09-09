package kr.co.ymtech.board2.vo;
/**
 * 유저 필드, getter/setter
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 9. 오전 8:55:19
 *
 */
public class User {
    // 유저 ID -- PK
    private String userId;
    // 유저 PW
    private String userPwd;
    // 유저 닉네임
    private String userNick;

    // 기본 생성자
    public User() {
       
    }
    
    // 생성자 오버로딩
    public User(String userId, String userPwd, String userNick) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userNick = userNick;
    }
    
    /**
     * userId을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * userId을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * userPw을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @return userPw
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * userPw을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @param userPw
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    /**
     * userNick을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @return userNick
     */
    public String getUserNick() {
        return userNick;
    }

    /**
     * userNick을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @param userNick
     */
    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }
    
    /**
     * 모든 필드 출력
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오전 8:57:43
     *
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [userId=");
        builder.append(userId);
        builder.append(", userPw=");
        builder.append(userPwd);
        builder.append(", userNick=");
        builder.append(userNick);
        builder.append("]");
        return builder.toString();
    }

}