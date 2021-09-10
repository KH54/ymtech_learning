package com.ymtech.board;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ymtech.board.service.BoardService;
import com.ymtech.board.service.CommentService;
import com.ymtech.board.service.UserService;

/**
 * 게시판 조작
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 10. 오후 4:11:06
 *
 */
public class Main {

    /**
     * User, Board, Comment의 테이블에서 실행할 작업을 선택
     *
     * @author "KyungHun Park"
     * @since 2021. 9. 10. 오후 4:11:38
     *
     * @param args
     */
    public static void main(String[] args) {

        // User, Board, Comment의 작업을 실행할 객체
        UserService userS = new UserService();
        BoardService boardS = new BoardService();
        CommentService commentS = new CommentService();

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
                // User 테이블의 작업
                case 1:

                    System.out.println("수행할 작업을 선택하세요");
                    System.out.println("1.INSERT  2.SELECT 3.SELECT_ALL 4.DELETE  5.UPDATE 6.BACK");

                    control = controlCRUD.nextInt();

                    switch (control) {
                    // User 추가
                    case 1:
                        userS.insert();
                        break;
                    // 선택한 User 정보 출력
                    case 2:
                        userS.select();
                        break;
                    // 모든 User 정보 출력
                    case 3:
                        userS.selectAll();
                        break;
                    // 선택한 User 삭제
                    case 4:
                        userS.delete();
                        break;
                    // 선택한 User 정보 수정
                    case 5:
                        userS.update();
                        break;
                    // 뒤로가기
                    case 6:
                        break;
                    }
                    break; // User 테이블 작업 종료

                // Board 테이블 작업
                case 2:
                    System.out.println("수행할 작업을 선택하세요");
                    System.out.println("1.INSERT  2.SELECT 3.SELECT_ALL 4.DELETE  5.UPDATE");

                    control = controlCRUD.nextInt();

                    switch (control) {
                    // 게시글 작성
                    case 1:
                        boardS.insert();
                        break;
                    // 선택한 게시글 출력
                    case 2:
                        boardS.select();
                        break;
                    // 모든 게시글 출력
                    case 3:
                        boardS.selectAll();
                        break;
                    // 선택한 게시글 삭제
                    case 4:
                        boardS.delete();
                        break;
                    // 선택한 게시글 수정
                    case 5:
                        boardS.update();
                        break;
                    }
                    break; // Board 테이블 작업 종료

                // Comment 테이블 작업
                case 3:
                    System.out.println("수행할 작업을 선택하세요");
                    System.out.println("1.INSERT  2.SELECT  3.DELETE  4.UPDATE");

                    control = controlCRUD.nextInt();

                    switch (control) {
                    // 댓글 작성
                    case 1:
                        commentS.insert();
                        break;
                    // 모든 댓글 출력
                    case 2:
                        commentS.select();
                        break;
                    // 선택한 댓글 삭제
                    case 3:
                        commentS.delete();
                        break;
                    // 선택한 댓글 수정
                    case 4:
                        commentS.update();
                        break;
                    }
                    break; // Comment 테이블 작업 종료

                // 시스템 종료
                case 4:
                    System.out.println("System Exit");
                    controlCRUD.close();
                    System.exit(0);

                    // 1~4가 아닌 다른 숫자를 입력한 경우
                default:
                    System.out.println("선택지에 있는 숫자만 입력해주세요");
                    break;
                }

            } catch (InputMismatchException ie) { // int형 타입이 아닌 값이 입력되었을 때 로그를 출력한 후 재입력 요청
                System.out.println("숫자만 입력해주세요");

                // enter를 기준으로 값을 리턴하는 nextLine() 메소드. 입력된 값을 초기화 시켜준다.
                controlCRUD.nextLine();

                continue; // 재입력 요청

            } catch (Exception e) {
                System.out.println("DB 연결에 실패했습니다.");
                System.exit(0);
            }
            // 작업을 한번 실행한 뒤 초기화
            controlCRUD.nextLine();
        }
    }

}
