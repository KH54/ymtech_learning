package com.ymtech.board;
public class User {
    // 유저 ID
    private String userId;
    // 유저 PW
    private String userPw;
    // 유저 닉네임
    private String userNick;

    public User() {
        
    }
    public User(String userId, String userPw, String userNick) {
        this.userId = userId;
        this.userPw = userPw;
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
    public String getUserPw() {
        return userPw;
    }

    /**
     * userPw을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @param userPw
     */
    public void setUserPw(String userPw) {
        this.userPw = userPw;
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
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [userId=");
        builder.append(userId);
        builder.append(", userPw=");
        builder.append(userPw);
        builder.append(", userNick=");
        builder.append(userNick);
        builder.append("]");
        return builder.toString();
    }

}