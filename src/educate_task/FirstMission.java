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
 *        DB�� 'info' TABLE�� �����Ͽ� ����ڿ��� �Է� ���� ������ CRUD ����
 */
class FirstMission {

    // log
    private static Logger logger = Logger.getLogger(FirstMission.class);

    // DB ������ ���� �ּ�, ID, PW, Driver ��ġ
    private final static String DB_URL = "jdbc:mysql://127.0.0.1:3306/ymtechfirst";
    private final static String DB_ID = "root";
    private final static String DB_PW = "eownddlf1704!";
    private final static String DB_DRIVER = "org.mariadb.jdbc.Driver";

    // ����� �Է��� �ޱ� ���� Scanner, �Է°��� �����ϱ� ���� ID, PW
    private static String id;
    private static String password;
    private static Scanner inputInfo = new Scanner(System.in);
    

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 8. 23.
     *
     *        TABLE�� ID�� PW�� ����
     */
    public static void insert() {

        // Driver �ε�
        loadDriver();

        // DB ���� ����
        try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); PreparedStatement stmt = con.prepareStatement("INSERT INTO info(id, password) VALUES(?,?)");) {

            // ����ڿ��� �߰��� ID�� PW �Է� ����
            System.out.print("�߰��� ID �Է� : ");
            id = inputInfo.next();
            System.out.print("�߰��� PASSWORD �Է� : ");
            password = inputInfo.next();

            // index�� String ������ ����
            stmt.setString(1, id);
            stmt.setString(2, password);

            // ����� stmt�� DB table�� ����
            stmt.executeUpdate();
            System.out.println("ID :" + id + "�� �߰��Ǿ����ϴ�.");
            
        } catch (SQLNonTransientConnectionException ce) { // DB�� ������ ���� ���� ��� �ý��� ����
            logger.error(ce.getMessage() + "\n System exit");
            System.exit(0);
        } catch (SQLException e) { // �ߺ��� ID ���� �Է��� ��� �ٽ� �۾� �������� �̵�
            logger.info(e.getMessage() +"\n ���̵� �ߺ��Ǿ����ϴ�. �ٽ� �Է����ּ���");
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
     *        TABLE�� ����� ID���� ��ġ�ϴ� ID, PASSWORD ����
     */
    public static void delete() {
        
        // Driver �ε�
        loadDriver();

        System.out.print("������ ID �Է� : ");
        id = inputInfo.next();

        // DB ���� ����
        try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); PreparedStatement stmt = con.prepareStatement("DELETE FROM info WHERE id = ?"); ResultSet rs = stmt.executeQuery("SELECT * FROM info WHERE id ='" + id + "'");) {

            // ����ڿ��� �Է� ���� ID�� ��ġ�ϴ� ID, PW ����
            if (rs.next()) {
                /* ����� DB�� ���̺� ���ڵ尡 �ִ� ��� ���� */

                // index�� String ������ ����
                stmt.setString(1, id);

                // ����� stmt�� DB table�� ����
                stmt.executeUpdate();
                System.out.println("���� �Ϸ�");
            } else {
                System.out.println("������ ID�� �����ϴ�. ���� ȭ������ ���ư��ϴ�."); /* ����� DB�� ���̺� ���ڵ尡 ���� ��� */

            }

        } catch (SQLNonTransientConnectionException ce) { // DB�� ������ ���� ���� ��� �ý��� ����
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
     *        TABLE�� ����� ID�� PW�� ����
     */
    public static void update() {

        // Driver �ε�
        loadDriver();

        // DB ���� ����
        try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); PreparedStatement stmt = con.prepareStatement("UPDATE info SET password = ? WHERE id = ?");) {

            // ����ڿ��� ������Ʈ �� ID�� �Է¹޾� PW�� ����
            System.out.print("������Ʈ�� ID �Է� : ");
            id = inputInfo.next();
            System.out.print("ID�� ���ο� PASSWORD �Է� : ");
            password = inputInfo.next();

            // index�� String ������ ����
            stmt.setString(1, password);
            stmt.setString(2, id);

            // ����� stmt�� DB table�� ����
            if (stmt.executeUpdate() != 0) {
                /* Update�� ���ڵ��� ���� 0�̸� ��ġ�ϴ� ID�� ���� Update���� ���� �� �� ���̻� Update ������ ���� */
                System.out.println("������Ʈ �Ϸ�Ǿ����ϴ�.");
            } else {
                System.out.println("��ġ�ϴ� ID�� �����ϴ�. ���� ȭ������ ���ư��ϴ�.");
            }

        } catch (SQLNonTransientConnectionException ce) { // DB�� ������ ���� ���� ��� �ٽ� �۾� �������� �̵�
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
     *        TABLE�� ����� ���ڵ带 Console�� ���
     */
    public static void read() {

        // Driver �ε�
        loadDriver();
        // DB ���� ����
        try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); PreparedStatement stmt = con.prepareStatement("SELECT * FROM  info"); ResultSet rs = stmt.executeQuery();) {

            System.out.println("");

            if (rs.next()) {
                /* table�� ���ڵ尡 ����Ǿ������� ���� */

                // rs�� ������ �ѹ� next() �Ǿ��� ������ ���� ó������ �����ش�.
                rs.beforeFirst();

                // TABLE�� ����� id�� pw�� ���
                while (rs.next()) {

                    System.out.println(String.format("ID: %s, PW: %s", rs.getString("id"), rs.getString("password")));
                }
            } else {
                System.out.println("TABLE�� ����ֽ��ϴ�.");
            }

            System.out.println("");

        } catch (SQLNonTransientConnectionException ce) { // DB�� ������ ���� ���� ��� �ý��� ����
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
     *             TABLE���� ������ �۾��� ����
     */
    public static void main(String[] args) {

        int control = 0; // �۾��� �����ϱ� ���� ����ڿ��� �Է� ���� ���� �����ϴ� ����

        // break���� ��� ������ �����ϵ��� While�� ���
        while (true) {

            try {
                System.out.println("TABLE���� ������ �۾��� ������");

                System.out.println("1 : insert, 2 : delete, 3 : update, 4 : read, 5 : quit");
                control = inputInfo.nextInt();
                
            } catch (InputMismatchException ie) { // int�� Ÿ���� �ƴ� ���� �ԷµǾ��� �� ����ó��
                inputInfo.nextLine(); // enter�� �������� �����޾ƿ��� nextLine() �޼ҵ�. �Էµ� ���� �ʱ�ȭ �����ش�.
                logger.info(ie+"\n���ڸ� �Է����ּ���");
                continue;
            } catch (Exception e) {
                logger.error(e + "\n System exit");
                System.exit(0);
            }

            switch (control) {
            /* ������� �Է¿� ���� �޼ҵ� ȣ�� */
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
                System.out.println("�ý��� ����");
                System.exit(0);

            default:
                System.out.println("�������� �ִ� ���ڸ� �Է����ּ���");
                break;
            }
            inputInfo.nextLine();
        }

    }

}