package kr.co.ymtech.board2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UserService userS = new UserService();
        BoardService boardS = new BoardService();
        CommentService commentS = new CommentService();
//       TODO List<User> users = userdao.selectAll();      
//            Optional<User> opBoardUser = users
//                .stream().filter(user->user.getUserId() == board.getUserId()).findAny();

        // 사용자에게 입력을 받기 위한 Scanner Class 인스턴스 생성
        Scanner controlCRUD = new Scanner(System.in);

        // 작업을 수행하기 위해 사용자에게 입력 받은 수를 저장하는 변수
        int control = 0;
        while (true) {

            try {
                // 수행할 CRUD 선택
                System.out.println("작업을 수행할 TABLE을 선택하세요");
                System.out.println("1.User  2.Board  3.Comment  4.Quit");

                // 사용자에게 작업을 입력받음
                control = controlCRUD.nextInt();

                switch (control) {
                case 1:

                    System.out.println("수행할 작업을 선택하세요");
                    System.out.println("1.INSERT  2.SELECT 3.SELECT_ALL 4.DELETE  5.UPDATE");

                    control = controlCRUD.nextInt();

                    switch (control) {

                    case 1:
                        userS.insert();
                        break;

                    case 2:
                        userS.select();
                        break;

                    case 3:
                        userS.selectAll();
                        break;

                    case 4:
                        userS.delete();
                        break;

                    case 5:
                        userS.update();
                        break;
                    }
                    break;
                case 2:
                    System.out.println("수행할 작업을 선택하세요");
                    System.out.println("1.INSERT  2.SELECT 3.SELECT_ALL 4.DELETE  5.UPDATE");

                    control = controlCRUD.nextInt();

                    switch (control) {
                    case 1:
                        boardS.insert();
                        break;
                    case 2:
                        boardS.select();
                        break;

                    case 3:
                        boardS.selectAll();
                        break;

                    case 4:
                        boardS.delete();
                        break;

                    case 5:
                        boardS.update();
                        break;
                    }
                    break;

                case 3:
                    System.out.println("수행할 작업을 선택하세요");
                    System.out.println("1.INSERT  2.SELECT  3.DELETE  4.UPDATE");

                    control = controlCRUD.nextInt();

                    switch (control) {

                    case 1:
                        commentS.insert();
                        break;

                    case 2:
                        commentS.select();
                        break;

                    case 3:
                        commentS.delete();
                        break;

                    case 4:
                        commentS.update();
                        break;
                    }
                    break;
                case 4:
                    System.out.println("System Exit");
                    controlCRUD.close();
                    System.exit(0);

                default:
                    System.out.println("선택지에 있는 숫자만 입력해주세요");
                    break;
                }

            } catch (InputMismatchException ie) { // int형 타입이 아닌 값이 입력되었을 때 로그를 출력한 후 재입력 요청
                ie.printStackTrace();

                // enter를 기준으로 값을 리턴하는 nextLine() 메소드. 입력된 값을 초기화 시켜준다.
                controlCRUD.nextLine();

                continue; // 재입력 요청

            } catch (Exception e) { // 로그를 출력하고 시스템 종료
                e.printStackTrace();
                System.exit(0);
            }

            /* 사용자의 입력에 따른 메소드 호출 */
            switch (control) {
            case 1: // 추가

            }
            controlCRUD.nextLine(); // 입력받았던 내용 초기화
        }
    }
}
