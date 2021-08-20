package educate_task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

class FirstMission {

    final static String DB_URL = "jdbc:mysql://127.0.0.1:3306/ymtechfirst";
    final static String DB_ID = "root";
    final static String DB_PW = "eownddlf1704!";

    /**
     * 
     * @author user
     * @since 2021. 8. 19.
     * 
     *        ymtechfirst DB의 table에 접근하여 사용자에게 입력 받은 값으로 CRUD 수행
     */
    public static void insert() {

        Scanner sc_insert = new Scanner(System.in);
        String id, password; // 입력 받을 id, password
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // DB 연결 정보
        try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); 
                PreparedStatement stmt = con.prepareStatement("INSERT INTO info(id, password) VALUES(?,?)");)

        {
            // 사용자에게 추가할 ID와 PW 입력 받음
            System.out.println("추가할 ID 입력 : ");
            id = sc_insert.next();
            System.out.println("추가할 PASSWORD 입력 : ");
            password = sc_insert.next();

            stmt.setString(1, id);
            stmt.setString(2, password);

            stmt.executeUpdate();
            System.out.println(id + "가 추가되었습니다.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete() {
        Scanner sc_delete = new Scanner(System.in);
        String id = null; // 입력 받을 id

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // DB 연결 정보
        try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); 
                PreparedStatement stmt = con.prepareStatement("DELETE FROM info WHERE id = ?");) {
            System.out.println("삭제할 ID 입력 : ");

            // 사용자에게 ID 입력 받아 일치하는 ID, PW 삭제
            id = sc_delete.next();
            stmt.setString(1, id);

            stmt.executeUpdate();
            System.out.println(id + "가 삭제되었습니다.");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("삭제할 ID " + id + "가 없습니다.");
        }
    }

    public static void update() {
        Scanner sc_update = new Scanner(System.in);
        String id, password; // 입력 받을 id, password

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // DB 연결 정보
        try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); 
                PreparedStatement stmt = con.prepareStatement("UPDATE info SET password = ? WHERE id = ?");) {

            // 사용자에게 업데이트 할 ID를 입력받아 PW를 변경
            System.out.println("업데이트할 ID 입력 : ");
            id = sc_update.next();
            System.out.println("ID의 새로운 PASSWORD 입력 : ");
            password = sc_update.next();

            stmt.setString(1, password);
            stmt.setString(2, id);

            stmt.executeUpdate();
            if (stmt.executeUpdate() != 0) { // 일치하는 id가 있는지 check
                System.out.println("업데이트 완료되었습니다.");
            } else {
                System.out.println("업데이트에 실패하였습니다. ID를 확인하세요");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void read() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // DB 연결 정보
        try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); 
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM  info"); ResultSet rs = stmt.executeQuery();) {
            
            System.out.println("");
            // TABLE의 저장된 값을 출력
            while (rs.next()) {
                System.out.println(String.format("ID: %s, PW: %s", rs.getString("id"), rs.getString("password")));
            }
            System.out.println("");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int control = 0;                // 작업을 수행하기 위해 사용자에게 입력 받은 수를 저장하는 변수

        // 어떤 작업을 할것인지 선택
        while (control != 5) {
            System.out.println("DB에서 수행할 작업을 고르세요");
            System.out.println("1 : insert, 2 : delete, 3 : update, 4 : read, 5 : quit");
            control = sc.nextInt();
            switch (control) {
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
            }
        }
    }
}