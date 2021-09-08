package com.ymtech.board;

public class Board {
    // �Խñ� �ۼ� ���� ID - FK
    private String userId;
    // �Խñ� ����
    private String title;
    // �Խñ� ����
    private String content;
    // �Խñ� �ۼ� �ð�
    private String createTime;
    // �Խñ� ���� �ð�
    private String updateTime;
    // �Խñ� ��ȣ
    private int boardIndex;
    // ��ȸ��
    private int viewCount;

    public Board() {

    }

    public Board(String userId, String title, String content, String createTime, String updateTime,int boardIndex, int viewCount) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.boardIndex = boardIndex;
        this.viewCount = viewCount;
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
     * title��(��) �����ɴϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * title��(��) �����մϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * content��(��) �����ɴϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * content��(��) �����մϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * createTime��(��) �����ɴϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 8. ���� 7:22:37
     * @return createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * createTime��(��) �����մϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 8. ���� 7:22:37
     * @param createTime
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * updateTime��(��) �����ɴϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 8. ���� 7:22:37
     * @return updateTime
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * updateTime��(��) �����մϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 8. ���� 7:22:37
     * @param updateTime
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * boardIndex��(��) �����ɴϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @return boardIndex
     */
    public int getBoardIndex() {
        return boardIndex;
    }

    /**
     * boardIndex��(��) �����մϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @param boardIndex
     */
    public void setBoardIndex(int boardIndex) {
        this.boardIndex = boardIndex;
    }

    /**
     * viewCount��(��) �����ɴϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @return viewCount
     */
    public int getViewCount() {
        return viewCount;
    }

    /**
     * viewCount��(��) �����մϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @param viewCount
     */
    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Board [userId=");
        builder.append(userId);
        builder.append(", title=");
        builder.append(title);
        builder.append(", content=");
        builder.append(content);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append(", updateTime=");
        builder.append(updateTime);
        builder.append(", boardIndex=");
        builder.append(boardIndex);
        builder.append(", viewCount=");
        builder.append(viewCount);
        builder.append("]");
        return builder.toString();
    }

}