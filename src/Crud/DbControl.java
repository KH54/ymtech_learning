package Crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 * 
 * @author "KyungHun Park"
 * @since 2021. 9. 3.
 *
 *        ���̺� ���������� CRUD�ϴ� Class
 */
public class DbControl {

    // log ����� ���� logger ����
    private static Logger logger = Logger.getLogger(DbControl.class);

    // DB ������ ���� �ּ�, ID, PW, Driver ��ġ, �ܺο��� ������ �� ���� private, ������ �� ���� final�� ����
    private final static String DB_URL = "jdbc:mysql://127.0.0.1:3306/ymtechfirst";
    private final static String DB_ID = "root";
    private final static String DB_PW = "eownddlf1704!";
    private final static String DB_DRIVER = "org.mariadb.jdbc.Driver";

    // ����� �Է��� �ޱ� ���� Scanner, �Է°��� �����ϱ� ���� ID, PW, �ܺο��� ������ �� ���� private
    private static String id;
    private static String password;
    private static Scanner inputInfo = new Scanner(System.in);

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 3.
     *
     *        TABLE�� ID�� PW ����
     */
    public void insert() {

        // Driver �ε�
        loadDriver();

        // DB ���� ����, SQL���� ������ ��ü
        try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); 
                PreparedStatement stmt = con.prepareStatement("INSERT INTO info(id, password) VALUES(?,?)");) //
        {

            // ����ڿ��� �߰��� ID�� PW �Է� ����
            System.out.print("�߰��� ID �Է� : ");
            id = inputInfo.next();
            System.out.print("�߰��� PASSWORD �Է� : ");
            password = inputInfo.next();

            // smtm�� ?(����ǥ) �Ű������� �Է¹��� id,pw ����
            stmt.setString(1, id);
            stmt.setString(2, password);

            // ����� stmt�� DB table ����
            stmt.executeUpdate();
            System.out.printf("ID : %s�� �߰��Ǿ����ϴ�.", id);

        } catch (SQLNonTransientConnectionException ce) { // DB�� ������ ���� ���� ��� �α� ��� �� �ý��� ����
            logger.error("\n System exit", ce);
            System.exit(0);
        } catch (SQLException e) { // �ߺ��� ID ���� �Է��� ��� �ٽ� insert() �޼ҵ� ȣ���Ͽ� ���Է�
            logger.info("\n ���̵� �ߺ��Ǿ����ϴ�. �ٽ� �Է����ּ���", e);
            insert();
        } finally {
            inputInfo.nextLine(); // ���� �۾��� �����ϱ� ���� inputInfo�� �ʱ�ȭ
        }
    }

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 3.
     *
     *        TABLE�� ����� ID���� ��ġ�ϴ� ID, PASSWORD ����
     */
    public void delete() {

        // Driver �ε�
        loadDriver();

        System.out.print("������ ID �Է� : ");
        id = inputInfo.next();

        // DB ���� ����, SQL���� ������ ��ü, �Է¹��� ���ڵ尡 TABLE�� �ִ��� Ȯ���ϱ� ���� ������ ��û
        try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); 
                PreparedStatement stmt = con.prepareStatement("DELETE FROM info WHERE id = ?"); 
                ResultSet rs = stmt.executeQuery("SELECT * FROM info WHERE id ='" + id + "'");) {

            // ����ڿ��� �Է� ���� ID�� ��ġ�ϴ� ID, PW ����
            if (rs.next()) {
                /* ����� DB�� ���̺� ���ڵ尡 �ִ� ��� ���� */

                // smtm�� ?(����ǥ) �Ű������� �Է¹��� id ����
                stmt.setString(1, id);

                // ����� ������ Table ������Ʈ
                stmt.executeUpdate();
                System.out.println("���� �Ϸ�");
            } else {
                System.out.println("������ ID�� �����ϴ�. ���� ȭ������ ���ư��ϴ�."); /* ����� DB�� ���̺� ���ڵ尡 ���� ��� */

            }

        } catch (SQLNonTransientConnectionException ce) { // DB�� ������ ���� ���� ��� �α� ��� �� �ý��� ����
            logger.error("\n �ý��� ����", ce);
            System.exit(0);

        } catch (Exception e) { // �̽��� ���� �߻� �� �α� ��� �� �ý��� ����
            logger.error("\n �ý��� ����", e);
            System.exit(0);
        } finally {
            inputInfo.nextLine(); // ���� �۾��� �����ϱ� ���� inputInfo�� �ʱ�ȭ
        }
    }

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 8. 23.
     *
     *        TABLE�� ����� ID�� PW�� ����
     */
    public void update() {

        // Driver �ε�
        loadDriver();

        // DB ���� ����, ������ ��ɾ�
        try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); 
                PreparedStatement stmt = con.prepareStatement("UPDATE info SET password = ? WHERE id = ?");) {

            // ����ڿ��� ������Ʈ �� ID�� �Է¹޾� PW�� ����
            System.out.print("������Ʈ�� ID �Է� : ");
            id = inputInfo.next();
            System.out.print("ID�� ���ο� PASSWORD �Է� : ");
            password = inputInfo.next();

            // smtm�� ?(����ǥ) �Ű������� �Է¹��� id,pw ����
            stmt.setString(1, password);
            stmt.setString(2, id);

            /* ������Ʈ�� ���ڵ��� ���� 0�̸� ��ġ�ϴ� ID�� ���� ������Ʈ���� ���� ��, �� ���̻� Update ������ ���� */
            if (stmt.executeUpdate() != 0) {
                System.out.println("������Ʈ �Ϸ�Ǿ����ϴ�.");
            } else {
                System.out.println("��ġ�ϴ� ID�� �����ϴ�. ���� ȭ������ ���ư��ϴ�.");
            }

        } catch (SQLNonTransientConnectionException ce) { // DB�� ������ ���� ���� ��� �α� ��� �� �ý��� ����
            logger.error("\n �ý��� ����", ce);
            System.exit(0);

        } catch (Exception e) { // �̽��� ���� �߻� �� �α� ��� �� �ý��� ����
            logger.error("\n �ý��� ����", e);
            System.exit(0);
        } finally {
            inputInfo.nextLine(); // ���� �۾��� �����ϱ� ���� inputInfo�� �ʱ�ȭ
        }
    }

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 3.
     * 
     *        TABLE�� ����� ���ڵ带 Console�� ���
     */
    public void read() {

        // Driver �ε�
        loadDriver();
        // DB ���� ����, ������ ��ɾ�, DB�� TABLE�� ��� ������ ��û �� rs�� ����
        try (Connection con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW); 
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM  info"); 
                ResultSet rs = stmt.executeQuery();) {

            System.out.println("");

            if (rs.next()) {
                /* table�� ���ڵ尡 ����Ǿ������� ���� */

                // rs�� ������ �ѹ� next() �Ǿ��� ������ ���� ó������ �����ش�.
                rs.beforeFirst();

                // TABLE�� ����� id�� pw�� ���
                while (rs.next()) {
                    // DB�� ���ڵ���� ���ڿ��� ����Ѵ�.
                    System.out.println(String.format("ID: %s, PW: %s", rs.getString("id"), rs.getString("password")));
                }
            } else { // rs�� ������� ���
                System.out.println("TABLE�� ����ֽ��ϴ�.");
            }
            // �� �ٲ�
            System.out.println("");

        } catch (SQLNonTransientConnectionException ce) { // DB�� ������ ���� ���� ��� �α� ��� �� �ý��� ����
            logger.error("\n DB�� ������ �� �����ϴ�. �ý��� ����", ce);
            System.exit(0);
        } catch (Exception e) { // �̽��� ���� �߻� �� �α� ��� �� �ý��� ����
            logger.error("\n �ý��� ����", e);
            System.exit(0);
        }
    }

    /**
     * 
     * @author "KyungHun Park"
     * @since 2021. 9. 3.
     *
     *        ����̹� �ε� �޼ҵ�
     */
    static void loadDriver() {
        try {
            Class.forName(DB_DRIVER); // �����ͺ��̽� ����̹� �ε�
        } catch (Exception e) { // ����̹��� �ε� ���� ���� ��� �α׸� ����� �� �ý��� ����
            logger.error(" %s,����̹��� ã�� �� �����ϴ�. �ý��� ����", e);
            System.exit(0);
        }
    }

}