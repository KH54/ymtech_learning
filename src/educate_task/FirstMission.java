package educate_task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.log4j.Logger;

import com.sun.jdi.Method;

/**
 * 
 * @author user
 * @since 2021. 8. 23.
 * 
 *        DB의 'info' TABLE에 접근하여 사용자에게 입력 받은 값으로 CRUD 수행
 */
class FirstMission {

    // log
    private static Logger logger = Logger.getLogger(FirstMission.class);

    // DB 연결을 위한 주소, ID, PW, Driver 위치
    private final static String DB_URL = "jdbc:mysql://127.0.0.1:3306/ymtechfirst";
    private final static String DB_ID = "root";
    private final static String DB_PW = "eownddlf1704!";
    private final static String DB_DRIVER = "org.mariadb.jdbc.Driver";

    // 사용자 입력을 받기 위한 Scanner, 입력값을 저장하기 위한 ID, PW
    private static String id;
    private static String password;
    private static Scanner inputInfo = new Scanner(System.in);
    

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 8. 23.
     *
     *        TABLE에 ID와 PW를 저장
     */
    public static void insert() {

        // Driver 로드
        loadDriver();

        // DB 연결 정보
        try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); PreparedStatement stmt = con.prepareStatement("INSERT INTO info(id, password) VALUES(?,?)");) {

            // 사용자에게 추가할 ID와 PW 입력 받음
            System.out.print("추가할 ID 입력 : ");
            id = inputInfo.next();
            System.out.print("추가할 PASSWORD 입력 : ");
            password = inputInfo.next();

            // index를 String 값으로 지정
            stmt.setString(1, id);
            stmt.setString(2, password);

            // 변경된 stmt를 DB table에 저장
            stmt.executeUpdate();
            System.out.println("ID :" + id + "가 추가되었습니다.");
            
        } catch (SQLNonTransientConnectionException ce) { // DB와 연결이 되지 않을 경우 시스템 종료
            logger.error(ce.getMessage() + "\n System exit");
            System.exit(0);
        } catch (SQLException e) { // 중복된 ID 값을 입력한 경우 다시 작업 선택으로 이동
            logger.info(e.getMessage() +"\n 아이디가 중복되었습니다. 다시 입력해주세요");
            insert();
        } finally {
            inputInfo.nextLine();
        }
    }

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 8. 23.
     *
     *        TABLE에 저장된 ID값과 일치하는 ID, PASSWORD 삭제
     */
    public static void delete() {
        
        // Driver 로드
        loadDriver();

        System.out.print("삭제할 ID 입력 : ");
        id = inputInfo.next();

        // DB 연결 정보
        try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); PreparedStatement stmt = con.prepareStatement("DELETE FROM info WHERE id = ?"); ResultSet rs = stmt.executeQuery("SELECT * FROM info WHERE id ='" + id + "'");) {

            // 사용자에게 입력 받은 ID와 일치하는 ID, PW 삭제
            if (rs.next()) {
                /* 연결된 DB의 테이블에 레코드가 있는 경우 실행 */

                // index를 String 값으로 지정
                stmt.setString(1, id);

                // 변경된 stmt를 DB table에 저장
                stmt.executeUpdate();
                System.out.println("삭제 완료");
            } else {
                System.out.println("삭제할 ID가 없습니다. 선택 화면으로 돌아갑니다."); /* 연결된 DB의 테이블에 레코드가 없는 경우 */

            }

        } catch (SQLNonTransientConnectionException ce) { // DB와 연결이 되지 않을 경우 시스템 종료
            logger.error(ce + "\n System exit");
            System.exit(0);
        } catch (Exception e) {
            logger.error(e + "\n System exit");
            System.exit(0);
        } finally {
            inputInfo.nextLine();
        }
    }

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 8. 23.
     *
     *        TABLE에 저장된 ID의 PW를 변경
     */
    public static void update() {

        // Driver 로드
        loadDriver();

        // DB 연결 정보
        try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); PreparedStatement stmt = con.prepareStatement("UPDATE info SET password = ? WHERE id = ?");) {

            // 사용자에게 업데이트 할 ID를 입력받아 PW를 변경
            System.out.print("업데이트할 ID 입력 : ");
            id = inputInfo.next();
            System.out.print("ID의 새로운 PASSWORD 입력 : ");
            password = inputInfo.next();

            // index를 String 값으로 지정
            stmt.setString(1, password);
            stmt.setString(2, id);

            // 변경된 stmt를 DB table에 저장
            if (stmt.executeUpdate() != 0) {
                /* Update된 레코드의 수가 0이면 일치하는 ID가 없어 Update되지 않은 것 한 개이상 Update 됐으면 실행 */
                System.out.println("업데이트 완료되었습니다.");
            } else {
                System.out.println("일치하는 ID가 없습니다. 선택 화면으로 돌아갑니다.");
            }

        } catch (SQLNonTransientConnectionException ce) { // DB와 연결이 되지 않을 경우 다시 작업 선택으로 이동
            logger.error(ce + "\n System exit");
            System.exit(0);
        } catch (Exception e) {
            logger.error(e + "\n System exit");
            System.exit(0);
        } finally {
            inputInfo.nextLine();
        }
    }

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 8. 23.
     * 
     *        TABLE에 저장된 레코드를 Console에 출력
     */
    public static void read() {

        // Driver 로드
        loadDriver();
        // DB 연결 정보
        try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); PreparedStatement stmt = con.prepareStatement("SELECT * FROM  info"); ResultSet rs = stmt.executeQuery();) {

            System.out.println("");

            if (rs.next()) {
                /* table에 레코드가 저장되어있으면 실행 */

                // rs가 위에서 한번 next() 되었기 때문에 제일 처음으로 돌려준다.
                rs.beforeFirst();

                // TABLE에 저장된 id와 pw를 출력
                while (rs.next()) {

                    System.out.println(String.format("ID: %s, PW: %s", rs.getString("id"), rs.getString("password")));
                }
            } else {
                System.out.println("TABLE이 비어있습니다.");
            }

            System.out.println("");

        } catch (SQLNonTransientConnectionException ce) { // DB와 연결이 되지 않을 경우 시스템 종료
            logger.error(ce + "\n System exit");
            System.exit(0);
        } catch (Exception e) {
            logger.error(e + "\n System exit");
            System.exit(0);
        }
    }

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 8. 24.
     *
     *        Driver load method
     */
    static void loadDriver() {
        try {
            Class.forName(DB_DRIVER);
        } catch (Exception e) {
            logger.error(e);
        }
    }
    
    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 8. 23.
     *
     * @param args
     * 
     *             TABLE에서 수행할 작업을 선택
     */
    public static void main(String[] args) {

        int control = 0; // 작업을 수행하기 위해 사용자에게 입력 받은 수를 저장하는 변수

        // break까지 계속 수정이 가능하도록 While문 사용
        while (true) {

            try {
                System.out.println("TABLE에서 수행할 작업을 고르세요");

                System.out.println("1 : insert, 2 : delete, 3 : update, 4 : read, 5 : quit");
                control = inputInfo.nextInt();
                
            } catch (InputMismatchException ie) { // int형 타입이 아닌 값이 입력되었을 때 예외처리
                inputInfo.nextLine(); // enter를 기준으로 값을받아오는 nextLine() 메소드. 입력된 값을 초기화 시켜준다.
                logger.info(ie+"\n숫자를 입력해주세요");
                continue;
            } catch (Exception e) {
                logger.error(e + "\n System exit");
                System.exit(0);
            }

            switch (control) {
            /* 사용자의 입력에 따른 메소드 호출 */
            case 1:
                insert();
                break;

            case 2:
                delete();
                break;

            case 3:
                update();
                break;

            case 4:
                read();
                break;

            case 5:
                System.out.println("시스템 종료");
                System.exit(0);

            default:
                System.out.println("선택지에 있는 숫자만 입력해주세요");
                break;
            }
            inputInfo.nextLine();
        }

    }

}