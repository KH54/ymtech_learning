package kr.co.ymtech.board2;

import java.util.Scanner;

import com.ymtech.board.vo.User;

import kr.co.ymtech.board.dao.UserDAO;

/**
 * user의 모든 기능을 사용자에게 입력받는 Class
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 9. 오후 10:23:14
 *
 */
public class UserService {
    // User의 DAO 호출
    UserDAO userdao = new UserDAO();
    // User 필드와 getter/setter
    User user = new User();

    // 쿼리에 입력할 컬럼을 입력받는 변수
    Scanner controlCRUD = new Scanner(System.in);

    // 입력받은 변수를 저장
    String scanStr = "";
    int scanInt = 0;

    /**
     * 유저 생성
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:45:14
     *
     * @return
     */
    public int insert() {
        // 사용자에게 새로 만들 유저의 정보를 입력 받음
        System.out.println("ID, PW, 별명순으로 입력");
        // id
        scanStr = controlCRUD.next();
        user.setUserId(scanStr);

        // pwd
        scanStr = controlCRUD.next();
        user.setUserPwd(scanStr);

        // nickName
        scanStr = controlCRUD.next();
        user.setUserNick(scanStr);

        // 성공 또는 실패 시
        if (userdao.insert(user) > 0) {
            System.out.println("추가 완료");
            return 1;
        } else {
            System.out.println("추가 실패");
            return -1;
        }
    }

    /**
     * 원하는 유저 출력
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:47:16
     *
     */
    public void select() {
        // 사용자에게 출력할 유저의 id를 입력 받음
        System.out.println("ID입력");

        // id
        scanStr = controlCRUD.next();
        user.setUserId(scanStr);

        // 입력받은 id의 유저 정보 출력
        System.out.println(userdao.select(user));
    }

    /**
     * 모든 유저 출력
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:48:17
     *
     */
    public void selectAll() {
        System.out.println(userdao.selectAll().toString());
    }

    /**
     * 유저 삭제
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:49:08
     *
     * @return
     */
    public int delete() {
        // 삭제할 유저의 id를 사용자에게 입력 받음
        System.out.println("ID 입력");
        scanStr = controlCRUD.next();

        // 입력 받은 유저의 id를 전달
        user.setUserId(scanStr);
        
        // 성공 또는 실패 시
        if (userdao.delete(user) > 0) {
            System.out.println("삭제 완료");
            return 1;
        } else {
            System.out.println("삭제할 ID가 없습니다.");
            return -1;
        }
    }

    /**
     * 유저 정보 수정
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 9. 오후 10:49:56
     *
     * @return
     */
    public int update() {
        // 수정할 유저의 id를 입력 받고, pw와 별명을 수정
        System.out.println("ID, PW, 별명순으로 입력");

        // pwd
        scanStr = controlCRUD.next();
        user.setUserPwd(scanStr);

        // str
        scanStr = controlCRUD.next();
        user.setUserNick(scanStr);

        // id
        scanStr = controlCRUD.next();
        user.setUserId(scanStr);
        
        // 성공 또는 실패 시
        if (userdao.update(user) > 0) {
            System.out.println("업데이트 성공");
            return 1;
        } else {
            System.out.println("업데이트 실패");
            return -1;
        }
    }
}
