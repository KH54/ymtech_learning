package com.ymtech.board;

public class Board {
    // 게시글 작성 유저 ID - FK
    private String userId;
    // 게시글 제목
    private String title;
    // 게시글 내용
    private String content;
    // 게시글 작성 시간
    private String createTime;
    // 게시글 수정 시간
    private String updateTime;
    // 게시글 번호
    private int boardIndex;
    // 조회수
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
     * title을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * title을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * content을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * content을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * createTime을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 8. 오후 7:22:37
     * @return createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * createTime을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 8. 오후 7:22:37
     * @param createTime
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * updateTime을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 8. 오후 7:22:37
     * @return updateTime
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * updateTime을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 8. 오후 7:22:37
     * @param updateTime
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * boardIndex을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @return boardIndex
     */
    public int getBoardIndex() {
        return boardIndex;
    }

    /**
     * boardIndex을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @param boardIndex
     */
    public void setBoardIndex(int boardIndex) {
        this.boardIndex = boardIndex;
    }

    /**
     * viewCount을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 7.
     * @return viewCount
     */
    public int getViewCount() {
        return viewCount;
    }

    /**
     * viewCount을(를) 설정합니다.
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