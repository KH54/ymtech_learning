package com.ymtech.board;
public class User {
    // ���� ID
    private String userId;
    // ���� PW
    private String userPw;
    // ���� �г���
    private String userNick;

    public User() {
        
    }
    public User(String userId, String userPw, String userNick) {
        this.userId = userId;
        this.userPw = userPw;
        this.userNick = userNick;
    }
    
    /**
     * userId��(��) �����ɴϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * userId��(��) �����մϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * userPw��(��) �����ɴϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @return userPw
     */
    public String getUserPw() {
        return userPw;
    }

    /**
     * userPw��(��) �����մϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @param userPw
     */
    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    /**
     * userNick��(��) �����ɴϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @return userNick
     */
    public String getUserNick() {
        return userNick;
    }

    /**
     * userNick��(��) �����մϴ�.
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