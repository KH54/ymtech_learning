package com.ymtech.board;

public class Comment {
    // ��� �ۼ� ���� ID -- FK
    private String userId;
    // ��� ����
    private String content;
    // ��� �ۼ� �ð�
    private String createTime;
    // ��� ���� �ð�
    private String updateTime;
    // �Խñ� ��ȣ -- FK
    private int boardIndex;
    // ��� ��ȣ
    private int commentIndex;
    // �θ� ��� ��ȣ
    private int parentIndex;
    // ���� ����
    private int depth;
    // ��� ����
    private int order;

    public Comment() {

    }

    public Comment(String userId, String content, String createTime, String updateTime, int boardIndex, int commentIndex, int parentIndex, int depth, int order) {
        this.userId = userId;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.boardIndex = boardIndex;
        this.commentIndex = commentIndex;
        this.parentIndex = parentIndex;
        this.depth = depth;
        this.order = order;
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
     * @since 2021. 9. 7.
     * @return createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * createTime��(��) �����մϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @param createTime
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * updateTime��(��) �����ɴϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @return updateTime
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * updateTime��(��) �����մϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
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
     * commentIndex��(��) �����ɴϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @return commentIndex
     */
    public int getCommentIndex() {
        return commentIndex;
    }

    /**
     * commentIndex��(��) �����մϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @param commentIndex
     */
    public void setCommentIndex(int commentIndex) {
        this.commentIndex = commentIndex;
    }

    /**
     * parentIndex��(��) �����ɴϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @return parentIndex
     */
    public int getParentIndex() {
        return parentIndex;
    }

    /**
     * parentIndex��(��) �����մϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @param parentIndex
     */
    public void setParentIndex(int parentIndex) {
        this.parentIndex = parentIndex;
    }

    /**
     * depth��(��) �����ɴϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @return depth
     */
    public int getDepth() {
        return depth;
    }

    /**
     * depth��(��) �����մϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @param depth
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * order��(��) �����ɴϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @return order
     */
    public int getOrder() {
        return order;
    }

    /**
     * order��(��) �����մϴ�.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @param order
     */
    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Comment [userId=");
        builder.append(userId);
        builder.append(", content=");
        builder.append(content);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append(", updateTime=");
        builder.append(updateTime);
        builder.append(", boardIndex=");
        builder.append(boardIndex);
        builder.append(", commentIndex=");
        builder.append(commentIndex);
        builder.append(", parentIndex=");
        builder.append(parentIndex);
        builder.append(", depth=");
        builder.append(depth);
        builder.append(", order=");
        builder.append(order);
        builder.append("]");
        return builder.toString();
    }

}