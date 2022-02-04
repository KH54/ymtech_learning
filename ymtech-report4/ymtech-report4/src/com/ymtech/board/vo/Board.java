package com.ymtech.board.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 유저 필드, getter/setter
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 10. 오전 8:47:14
 *
 */
public class Board {
    // 게시글 작성 유저 ID -- FK
    private String userId;
    // 게시글 제목
    private String title;
    // 게시글 내용
    private String content;
    // 게시글 작성 시간
    private String createTime;
    // 게시글 수정 시간
    private String updateTime;
    // 게시글 번호 -- PK
    private int boardIndex;
    // 조회수
    private int viewCount;

    // 기본 생성자
    public Board() {

    }

    // 생성자 오버로딩
    public Board(String userId, String title, String content, String createTime, String updateTime, int boardIndex, int viewCount) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.boardIndex = boardIndex;
        this.viewCount = viewCount;
    }

    public Board(ResultSet rs) throws SQLException {
        this.userId = rs.getString("user_id");
        this.title = rs.getString("title");
        this.content = rs.getString("content");
        this.createTime = rs.getString("create_time");
        this.updateTime = rs.getString("update_time");
        this.boardIndex = rs.getInt("board_index");
        this.viewCount = rs.getInt("view_count");

    }

    /**
     * userId을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 2:28:54
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * userId을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 2:28:54
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * title을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 2:28:54
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * title을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 2:28:54
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * content을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 2:28:54
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * content을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 2:28:54
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * createTime을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 2:28:54
     * @return createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * createTime을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 2:28:54
     * @param createTime
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * updateTime을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 2:28:54
     * @return updateTime
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * updateTime을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 2:28:54
     * @param updateTime
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * boardIndex을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 2:28:54
     * @return boardIndex
     */
    public int getBoardIndex() {
        return boardIndex;
    }

    /**
     * boardIndex을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 2:28:54
     * @param boardIndex
     */
    public void setBoardIndex(int boardIndex) {
        this.boardIndex = boardIndex;
    }

    /**
     * viewCount을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 2:28:54
     * @return viewCount
     */
    public int getViewCount() {
        return viewCount;
    }

    /**
     * viewCount을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 2:28:54
     * @param viewCount
     */
    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * 필드 값 출력
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 7:44:12
     *
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("작성자=");
        builder.append(userId);
        builder.append(", 제목=");
        builder.append(title);
        builder.append(", 내용=");
        builder.append(content);
        builder.append(", 게시물 번호=");
        builder.append(boardIndex);
        builder.append(", 조회수=");
        builder.append(viewCount);
        builder.append(", 작성 시간=");
        builder.append(createTime);
        builder.append(", 수정 시간=");
        builder.append(updateTime);
        builder.append("\n");
        return builder.toString();
    }
}