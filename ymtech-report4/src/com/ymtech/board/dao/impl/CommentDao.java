package com.ymtech.board.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ymtech.board.dao.ICommentDao;
import com.ymtech.board.vo.Comment;

/**
 * Comment의 crud
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 9. 오후 10:15:33
 *
 */
public class CommentDao implements ICommentDao {

    /**
     * 모든 댓글을 출력하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:15:49
     *
     */
    public List<Comment> select() {

        // 모든 댓글의 정보를 담을 list
        ArrayList<Comment> commentList = new ArrayList<Comment>();
        // 게시글의 정보를 담을 commentInfo
        Comment commentInfo;

        // DB 연결 및 쿼리 호출 실행
        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); PreparedStatement stmt = con.prepareStatement(DB.SQL_COMMENT_SELECT); ResultSet rs = stmt.executeQuery();) {

            // 쿼리문의 결과를 출력하여 저장
            while (rs.next()) {
                commentInfo = new Comment(rs);
                commentList.add(commentInfo);
            }

            // 예외 발생 시 종료
        } catch (SQLException e) {
            System.out.println("Comment select SQL Error");
        } catch (Exception e) {
            System.out.println("Comment select error");
            System.exit(0);
        }
        return commentList;
    }

    /**
     * 댓글 작성 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:17:22
     *
     */
    public Integer insert(Comment comment) {
        // insert 성공 여부를 확인할 변수
        int result = 0;

        // DB 연결 및 쿼리 호출
        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); PreparedStatement stmt = con.prepareStatement(DB.SQL_COMMENT_INSERT);) {

            // 쿼리문에 정보 입력
            stmt.setString(1, comment.getUserId());
            stmt.setInt(2, comment.getBoardIndex());
            stmt.setString(3, comment.getContent());
            stmt.setInt(4, comment.getParentIndex());

            // 쿼리 실행
            result = stmt.executeUpdate();

            // 예외 발생시 종료
        } catch (SQLException e) {
            System.out.println("댓글을 입력할 게시물을 찾을 수 없습니다.");
        }
        return result;
    }

    /**
     * 댓글 삭제 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:18:21
     *
     */
    public Integer delete(Comment comment) {
        // delete 성공 여부를 확인할 변수
        int result = 0;

        // DB 연결 및 쿼리 호출
        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); PreparedStatement stmt = con.prepareStatement(DB.SQL_COMMENT_DELETE);) {

            // 쿼리에 정보 입력
            stmt.setInt(1, comment.getCommentIndex());

            // 쿼리 실행
            result = stmt.executeUpdate();

            // 예외 발생시 종료
        } catch (SQLException e) {
            System.out.println("Comment delete SQL Error");
        } catch (Exception e) {
            System.out.println("comment delete Error");
            System.exit(0);
        }

        return result;
    }

    /**
     * 댓글 수정 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:19:20
     *
     */
    public Integer update(Comment comment) {
        // update 성공 여부를 확인할 변수
        int result = 0;

        // DB 연결 및 쿼리 호출 및 실행
        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); 
                PreparedStatement stmt = con.prepareStatement(DB.SQL_COMMENT_UPDATE); 
              ) {

            // 쿼리문에 정보 입력
            stmt.setString(1, comment.getContent());
            stmt.setInt(2, comment.getCommentIndex());

            // 쿼리 실행
            result = stmt.executeUpdate();

            // 예외 발생시 종료
        } catch (SQLException e) {
            System.out.println("Comment update SQL Error");
        } catch (Exception e) {
            System.out.println("Comment update Error");
            System.exit(0);
        }
        return result;
    }
}