package com.ymtech.board.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * Generic type을 받아오는 Class
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 15. 오후 5:03:41
 *
 * @param <T> VO Class
 * @param <K> Primary key
 */
public class GenericDao<T, K> {

    /**
     * User, Board, Comment의 selectAll 메소드를 Generic Type으로 받아 처리
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 15. 오후 4:56:15
     *
     * @param sql             : 쿼리문
     * @param convertFunction : ResultSet을 T로 변환
     * @return result : 결과를 리스트에 담아 반환
     * @throws SQLException
     */
    public List<T> selectAll(String sql, Function<ResultSet, T> convertFunction) {
        // table에 저장된 값들을 읽기 위해 저장하는 리스트
        List<T> result = new ArrayList<>();

        // DB 연결 및 쿼리 실행
        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); 
                PreparedStatement stmt = con.prepareStatement(sql); 
                ResultSet rs = stmt.executeQuery();) {

            // table에 저장된 데이터 확인
            while (rs.next()) {
                // 하나의 레코드를 User 객체에 저장
                T newInstance = convertFunction.apply(rs);
                // 저장된 객체를 리스트에 저장
                result.add(newInstance);
            }
        } catch (SQLException e) {
            System.out.println("GenericDAO selectAll Error");
        }
        return result;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 15. 오후 5:22:11
     *
     * @param sql             : 쿼리문
     * @param pk              : 와일드카드에 입력할 PK
     * @param convertFunction : ResultSet을 T로 변환
     * @return
     * @throws SQLException
     */
    public T select(String sql, K pk, Function<ResultSet, T> convertFunction) {
        // 함수형 인터페이스의 결과값을 받을 Generic type의 인스턴스
        T newInstance = null;

        // DB 연결 및 쿼리문 호출
        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); 
                PreparedStatement stmt = con.prepareStatement(sql);) {

            // 와일드 카드 입력
            stmt.setObject(1, pk);

            // 쿼리 실행
            ResultSet rs = stmt.executeQuery();

            // 입력한 와일드 카드의 결과 값이 있는 경우
            if (rs.next()) {
                // 함수형 인터페이스 rs를 ResultSet에 적용시킨다.
                newInstance = convertFunction.apply(rs);
            }
        } catch (SQLException e) {
           System.out.println("GenericDAO Select Error");
        }
        return newInstance;
    }


    /**
     * User, Board, Comment의 insert 메소드를 Generic Type으로 받아 처리
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 24. 오후 5:37:54
     *
     * @param vo : vo 객체
     * @param sql  : 쿼리문
     * @param stmtFunction : 두개의 인자를 받아 반환값이 없는 작업의 함수형 인터페이스
     * @return
     */
    public Integer insert(T vo, String sql, BiConsumer<PreparedStatement, T> stmtFunction) {

        // DB 연결 및 쿼리문 호출
        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); 
                PreparedStatement stmt = con.prepareStatement(sql);) {

            stmtFunction.accept(stmt, vo);
            // insert 결과 반환
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("GenericDao Insert SQL Error");
        }
        return null;
    }

    /**
     * User, Board, Comment의 update 메소드를 Generic Type으로 받아 처리
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 24. 오후 5:16:47
     *
     * @param vo : vo 객체
     * @param sql  : 쿼리문
     * @param stmtfunction : 두개의 인자를 받아 반환값이 없는 작업의 함수형 인터페이스
     * @return
     * @throws SQLException
     */
    public Integer update(T vo, String sql, BiConsumer<PreparedStatement, T> stmtFunction) {

        // DB 연결 및 쿼리문 호출
        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); 
                PreparedStatement stmt = con.prepareStatement(sql);) {

            stmtFunction.accept(stmt, vo);

            // update 결과 반환
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("GenericDao Update SQL Error");
        }
        return null;
    }

    /**
     * User, Board, Comment의 delete 메소드를 Generic Type으로 받아 처리
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 15. 오후 5:16:56
     *
     * @param sql : 쿼리문
     * @param pk  : 와일드카드에 입력할 PK
     * @return
     * @throws SQLException
     */
    public Integer delete(String sql, K pk) {

        // DB 연결 및 쿼리문 호출
        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); 
                PreparedStatement stmt = con.prepareStatement(sql);) {

            // 매개변수로 받은 PK를 와일드카드에 입력
            stmt.setObject(1, pk);

            // delete 결과 반환
            return stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("GenericDao Delete SQL Error");
        }
        return null;
    }
}
