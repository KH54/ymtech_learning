package kr.co.ymtech.board2.vo;

/**
 * 유저 필드, getter/setter
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 10. 오전 8:48:43
 *
 */
public class Comment {
    // 댓글 작성 유저 ID -- FK
    private String userId;
    // 댓글 내용
    private String content;
    // 댓글 작성 시간
    private String createTime;
    // 댓글 수정 시간
    private String updateTime;
    // 게시글 번호 -- FK
    private int boardIndex;
    // 댓글 번호  -- PK
    private int commentIndex;
    // 부모 댓글 번호
    private int parentIndex;
    // 대댓글 깊이
    private int depth;
    // 댓글 순서
    private int order;

    // 기본 생성자
    public Comment() {

    }  
    
    // 생성자 오버로딩
    public Comment(String userId, String content, String createTime, String updateTime, int boardIndex, int commentIndex, int parentIndex, int depth, int order) {
        super();
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
     * userId을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 8:44:01
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * userId을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 8:44:01
     * @param userId 
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * content을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 8:44:01
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * content을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 8:44:01
     * @param content 
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * createTime을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 8:44:01
     * @return createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * createTime을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 8:44:01
     * @param createTime 
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * updateTime을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 8:44:01
     * @return updateTime
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * updateTime을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 8:44:01
     * @param updateTime 
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * boardIndex을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 8:44:01
     * @return boardIndex
     */
    public int getBoardIndex() {
        return boardIndex;
    }

    /**
     * boardIndex을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 8:44:01
     * @param boardIndex 
     */
    public void setBoardIndex(int boardIndex) {
        this.boardIndex = boardIndex;
    }

    /**
     * commentIndex을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 8:44:01
     * @return commentIndex
     */
    public int getCommentIndex() {
        return commentIndex;
    }

    /**
     * commentIndex을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 8:44:01
     * @param commentIndex 
     */
    public void setCommentIndex(int commentIndex) {
        this.commentIndex = commentIndex;
    }

    /**
     * parentIndex을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 8:44:01
     * @return parentIndex
     */
    public int getParentIndex() {
        return parentIndex;
    }

    /**
     * parentIndex을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 8:44:01
     * @param parentIndex 
     */
    public void setParentIndex(int parentIndex) {
        this.parentIndex = parentIndex;
    }

    /**
     * depth을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 8:44:01
     * @return depth
     */
    public int getDepth() {
        return depth;
    }

    /**
     * depth을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 8:44:01
     * @param depth 
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * order을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 8:44:01
     * @return order
     */
    public int getOrder() {
        return order;
    }

    /**
     * order을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 8:44:01
     * @param order 
     */
    public void setOrder(int order) {
        this.order = order;
    }

    /**
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 8:44:08
     *
     */
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