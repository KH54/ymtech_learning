package com.ymtech.board.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Generic type을 받아오는 Class
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 15. 오후 5:03:41
 *
 * @param <T>
 * @param <E>
 */
public class GenericDao<T, E> {

    /**
     * User, Board, Comment의 selectAll 메소드를 Generic Type으로 받아 처리
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 15. 오후 4:56:15
     *
     * @param sql             : 쿼리문
     * @param convertFunction : 함수형 인터페이스
     * @return result : 결과를 리스트에 담아 반환
     * @throws SQLException
     */
    public List<T> selectAll(String sql, Function<ResultSet, T> convertFunction) throws SQLException {
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
     * @param convertFunction : 함수형 인터페이스
     * @return
     * @throws SQLException
     */
    public T select(String sql, E pk, Function<ResultSet, T> convertFunction) throws SQLException {
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
        }
        return newInstance;
    }

    /**
     * User, Board, Comment의 insert 메소드를 Generic Type으로 받아 처리
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 15. 오후 5:16:36
     *
     * @param sql  : 쿼리문
     * @param list : 와일드카드에 입력할 PK와 추가할 정보
     * @return
     * @throws SQLException
     */
    public Integer insert(String sql, List<? extends Object> list) throws SQLException {
        // 순차적으로 와일드카드에 입력하기 위한 변수
        int step = 1;
        
        // DB 연결 및 쿼리문 호출
        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); 
                PreparedStatement stmt = con.prepareStatement(sql);) {

            // 매개변수로 받은 list에 저장된 값들을 하나씩 꺼내서 와일드카드에 입력
            for (Object obj : list) {
                stmt.setObject(step, obj);
                step++;
            }
            // insert 결과 반환
            return stmt.executeUpdate();
        }
    }

    /**
     * User, Board, Comment의 update 메소드를 Generic Type으로 받아 처리
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 15. 오후 5:16:47
     *
     * @param sql  : 쿼리문
     * @param list : 와일드카드에 입력할 PK와 수정할 정보
     * @return
     * @throws SQLException
     */
    public Integer update(String sql, List<? extends Object> list) throws SQLException {
        // 순차적으로 와일드카드에 입력하기 위한 변수
        int step = 1;
        
        // DB 연결 및 쿼리문 호출
        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); 
                PreparedStatement stmt = con.prepareStatement(sql);) {

            // 매개변수로 받은 list에 저장된 값들을 하나씩 꺼내서 와일드카드에 입력
            for (Object obj : list) {
                stmt.setObject(step, obj);
                step++;
            }
            // update 결과 반환
            return stmt.executeUpdate();
        }
    }

    /**
     * User, Board, Comment의 delete 메소드를 Generic Type으로 받아 처리
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 15. 오후 5:16:56
     *
     * @param sql : 쿼리문
     * @param pk               : 와일드카드에 입력할 PK
     * @return
     * @throws SQLException
     */
    public Integer delete(String sql, E pk) throws SQLException {

        // DB 연결 및 쿼리문 호출
        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); 
                PreparedStatement stmt = con.prepareStatement(sql);) {

            // 매개변수로 받은 PK를 와일드카드에 입력
            stmt.setObject(1, pk);
            
            // delete 결과 반환
            return stmt.executeUpdate();
        }
    }

}
