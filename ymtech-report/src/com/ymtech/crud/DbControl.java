package com.ymtech.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 * 테이블에 직접적으로 CRUD하는 Class
 * 
 * @author "KyungHun Park"
 * @since 2021. 9. 3.
 */
public class DbControl {
    // log 출력을 위한 logger 생성
    private static Logger logger = Logger.getLogger(DbControl.class);

    // DB 연결을 위한 주소, ID, PW, Driver 위치, 외부에서 접근할 수 없게 private, 변경할 수 없게 final로 설정
    private final static String DB_URL = "jdbc:mysql://127.0.0.1:3306/ymtechfirst";
    private final static String DB_ID = "root";
    private final static String DB_PW = "eownddlf1704!";
    private final static String DB_DRIVER = "org.mariadb.jdbc.Driver";

    // 사용자 입력을 받기 위한 Scanner, 입력값을 저장하기 위한 ID, PW, 외부에서 접근할 수 없게 private
    private static String id;
    private static String password;
    private static Scanner inputInfo = new Scanner(System.in);

    /**
     * TABLE에 ID와 PW 저장
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 3.
     */
    public void insert() {
        // Driver 로드
        loadDriver();

        // DB 연결 정보, SQL문을 전송할 객체
        try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); PreparedStatement stmt = con.prepareStatement("INSERT INTO info(id, password) VALUES(?,?)");) {

            // 사용자에게 추가할 ID와 PW 입력 받음
            System.out.print("추가할 ID 입력 : ");
            id = inputInfo.next();
            System.out.print("추가할 PASSWORD 입력 : ");
            password = inputInfo.next();

            // smtm의 ?(물음표) 매개변수에 입력받은 id,pw 지정
            stmt.setString(1, id);
            stmt.setString(2, password);

            // 변경된 stmt를 DB table 갱신
            stmt.executeUpdate();
            System.out.printf("ID : %s가 추가되었습니다.", id);

        } catch (SQLNonTransientConnectionException ce) { // DB와 연결이 되지 않은 경우 로그 출력 후 시스템 종료
            logger.error("\n System exit", ce);
            System.exit(0);
        } catch (SQLException e) { // 중복된 ID 값을 입력한 경우 다시 insert() 메소드 호출하여 재입력
            logger.info("\n 아이디가 중복되었습니다. 다시 입력해주세요", e);
            insert();
        } finally {
            inputInfo.nextLine(); // 다음 작업을 수행하기 위해 inputInfo를 초기화
        }
    }

    /**
     * TABLE에 저장된 ID값과 일치하는 ID, PASSWORD 삭제
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 3.
     */
    public void delete() {

        // Driver 로드
        loadDriver();
        System.out.print("삭제할 ID 입력 : ");
        id = inputInfo.next();

        // DB 연결 정보, SQL문을 전송할 객체, 입력받은 레코드가 TABLE에 있는지 확인하기 위해 정보를 요청
        try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); PreparedStatement stmt = con.prepareStatement("DELETE FROM info WHERE id = ?"); ResultSet rs = stmt.executeQuery("SELECT * FROM info WHERE id ='" + id + "'");) {

            // 사용자에게 입력 받은 ID와 일치하는 ID, PW 삭제
            if (rs.next()) {
                /* 연결된 DB의 테이블에 레코드가 있는 경우 실행 */

                // smtm의 ?(물음표) 매개변수에 입력받은 id 지정
                stmt.setString(1, id);

                // 변경된 정보를 Table 업데이트
                stmt.executeUpdate();
                System.out.println("삭제 완료");
            } else {
                System.out.println("삭제할 ID가 없습니다. 선택 화면으로 돌아갑니다."); /* 연결된 DB의 테이블에 레코드가 없는 경우 */
            }
        } catch (SQLNonTransientConnectionException ce) { // DB와 연결이 되지 않은 경우 로그 출력 후 시스템 종료
            logger.error("\n 시스템 종료", ce);
            System.exit(0);
        } catch (Exception e) { // 이슈로 예외 발생 시 로그 출력 후 시스템 종료
            logger.error("\n 시스템 종료", e);
            System.exit(0);
        } finally {
            inputInfo.nextLine(); // 다음 작업을 수행하기 위해 inputInfo를 초기화
        }
    }

    /**
     * TABLE에 저장된 ID의 PW를 변경
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 3.
     * 
     */
    public void update() {
        // Driver 로드
        loadDriver();

        // DB 연결 정보, 실행할 명령어
        try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); PreparedStatement stmt = con.prepareStatement("UPDATE info SET password = ? WHERE id = ?");) {

            // 사용자에게 업데이트 할 ID를 입력받아 PW를 변경
            System.out.print("업데이트할 ID 입력 : ");
            id = inputInfo.next();
            System.out.print("ID의 새로운 PASSWORD 입력 : ");
            password = inputInfo.next();

            // smtm의 ?(물음표) 매개변수에 입력받은 id,pw 지정
            stmt.setString(1, password);
            stmt.setString(2, id);

            /* 업데이트된 레코드의 수가 0이면 일치하는 ID가 없어 업데이트되지 않은 것, 한 개이상 Update 됐으면 실행 */
            if (stmt.executeUpdate() != 0) {
                System.out.println("업데이트 완료되었습니다.");
            } else {
                System.out.println("일치하는 ID가 없습니다. 선택 화면으로 돌아갑니다.");
            }
        } catch (SQLNonTransientConnectionException ce) { // DB와 연결이 되지 않은 경우 로그 출력 후 시스템 종료
            logger.error("\n 시스템 종료", ce);
            System.exit(0);

        } catch (Exception e) { // 이슈로 예외 발생 시 로그 출력 후 시스템 종료
            logger.error("\n 시스템 종료", e);
            System.exit(0);
        } finally {
            inputInfo.nextLine(); // 다음 작업을 수행하기 위해 inputInfo를 초기화
        }
    }

   /**
    * TABLE에 저장된 레코드를 Console에 출력
    * 
    * @author "KyungHun Park"
    * @since 2021. 9. 3.
    */
   public void read() {
       // Driver 로드
       loadDriver();
       
       // DB 연결 정보, 실행할 명령어, DB의 TABLE에 담긴 정보를 요청 후 rs에 저장
       try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); 
               PreparedStatement stmt = con.prepareStatement("SELECT * FROM  info"); 
               ResultSet rs = stmt.executeQuery();) {
           
           System.out.println("");
           
           if (rs.next()) {
               /* table에 레코드가 저장되어있으면 실행 */
               
               // rs가 위에서 한번 next() 되었기 때문에 제일 처음으로 돌려준다.
               rs.beforeFirst();

               if (rs.next()) {
                   /* table에 레코드가 저장되어있으면 실행 */
                   
                   // rs가 위에서 한번 next() 되었기 때문에 제일 처음으로 돌려준다.
                   rs.beforeFirst();
                   
                   // TABLE에 저장된 id와 pw를 출력
                   while (rs.next()) {
                       // DB의 레코드들을 문자열로 출력한다.
                       System.out.println(String.format("ID: %s, PW: %s", rs.getString("id"), rs.getString("password")));
                   }
               } else { // rs가 비어있을 경우
                   System.out.println("TABLE이 비어있습니다.");
               }
               // 줄 바꿈
               System.out.println("");
           } catch (SQLNonTransientConnectionException ce) { // DB와 연결이 되지 않은 경우 로그 출력 후 시스템 종료
               logger.error("\n DB에 연결할 수 없습니다. 시스템 종료", ce);
               System.exit(0);
           } catch (Exception e) { // 이슈로 예외 발생 시 로그 출력 후 시스템 종료
               logger.error("\n 시스템 종료", e);
               System.exit(0);
           }
       }

    /**
     * 드라이버 로드 메소드
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 3.
     */
    static void loadDriver() {
        try {
            Class.forName(DB_DRIVER); // 데이터베이스 드라이버 로드
        } catch (Exception e) { // 드라이버가 로드 되지 않을 경우 로그를 출력한 뒤 시스템 종료
            logger.error(" %s,드라이버를 찾을 수 없습니다. 시스템 종료", e);
            System.exit(0);
        }
    }
}