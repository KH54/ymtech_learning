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
     *        ymtechfirst DB�� table�� �����Ͽ� ����ڿ��� �Է� ���� ������ CRUD ����
     */
    public static void insert() {

        Scanner sc_insert = new Scanner(System.in);
        String id, password; // �Է� ���� id, password
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // DB ���� ����
        try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); 
                PreparedStatement stmt = con.prepareStatement("INSERT INTO info(id, password) VALUES(?,?)");)

        {
            // ����ڿ��� �߰��� ID�� PW �Է� ����
            System.out.println("�߰��� ID �Է� : ");
            id = sc_insert.next();
            System.out.println("�߰��� PASSWORD �Է� : ");
            password = sc_insert.next();

            stmt.setString(1, id);
            stmt.setString(2, password);

            stmt.executeUpdate();
            System.out.println(id + "�� �߰��Ǿ����ϴ�.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete() {
        Scanner sc_delete = new Scanner(System.in);
        String id = null; // �Է� ���� id

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // DB ���� ����
        try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); 
                PreparedStatement stmt = con.prepareStatement("DELETE FROM info WHERE id = ?");) {
            System.out.println("������ ID �Է� : ");

            // ����ڿ��� ID �Է� �޾� ��ġ�ϴ� ID, PW ����
            id = sc_delete.next();
            stmt.setString(1, id);

            stmt.executeUpdate();
            System.out.println(id + "�� �����Ǿ����ϴ�.");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("������ ID " + id + "�� �����ϴ�.");
        }
    }

    public static void update() {
        Scanner sc_update = new Scanner(System.in);
        String id, password; // �Է� ���� id, password

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // DB ���� ����
        try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); 
                PreparedStatement stmt = con.prepareStatement("UPDATE info SET password = ? WHERE id = ?");) {

            // ����ڿ��� ������Ʈ �� ID�� �Է¹޾� PW�� ����
            System.out.println("������Ʈ�� ID �Է� : ");
            id = sc_update.next();
            System.out.println("ID�� ���ο� PASSWORD �Է� : ");
            password = sc_update.next();

            stmt.setString(1, password);
            stmt.setString(2, id);

            stmt.executeUpdate();
            if (stmt.executeUpdate() != 0) { // ��ġ�ϴ� id�� �ִ��� check
                System.out.println("������Ʈ �Ϸ�Ǿ����ϴ�.");
            } else {
                System.out.println("������Ʈ�� �����Ͽ����ϴ�. ID�� Ȯ���ϼ���");
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
        // DB ���� ����
        try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); 
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM  info"); ResultSet rs = stmt.executeQuery();) {
            
            System.out.println("");
            // TABLE�� ����� ���� ���
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
        int control = 0;                // �۾��� �����ϱ� ���� ����ڿ��� �Է� ���� ���� �����ϴ� ����

        // � �۾��� �Ұ����� ����
        while (control != 5) {
            System.out.println("DB���� ������ �۾��� ������");
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