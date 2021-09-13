package com.ymtech.board;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ymtech.board.service.BoardService;
import com.ymtech.board.service.CommentService;
import com.ymtech.board.service.UserService;
import com.ymtech.board.vo.Board;
import com.ymtech.board.vo.Comment;
import com.ymtech.board.vo.User;

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

        User user = new User();
        Board board = new Board();
        Comment comment = new Comment();

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
                        // 사용자에게 새로 만들 유저의 정보를 입력 받음
                        System.out.println("ID, PW, 별명순으로 입력");

                        // id, pwd, nick
                        user.setUserId(controlCRUD.next());
                        user.setUserPwd(controlCRUD.next());
                        user.setUserNick(controlCRUD.next());

                        // 작업 결과
                        if (userS.insert(user) == 1) {
                            System.out.println("유저 추가 완료");
                        } else {
                            System.out.println("유저 추가 실패");
                        }
                        break;

                    // 선택한 User 정보 출력
                    case 2:
                        // 사용자에게 출력할 유저의 id를 입력 받음
                        System.out.println("ID입력");

                        // id
                        user.setUserId(controlCRUD.next());

                        // 작업 결과
                        if (userS.select(user) != null) {
                            System.out.println(userS.select(user));
                        } else {
                            System.out.println("요청한 유저를 찾을 수 없습니다.");
                        }
                        break;

                    // 모든 User 정보 출력
                    case 3:
                        userS.selectAll();
                        break;

                    // 선택한 User 삭제
                    case 4:
                        // 삭제할 유저의 id를 사용자에게 입력 받음
                        System.out.println("ID 입력");

                        // 입력 받은 유저의 id를 전달
                        user.setUserId(controlCRUD.next());

                        // 작업 결과
                        if (userS.delete(user) == 1) {
                            System.out.println("유저 정보 삭제 완료");
                        } else {
                            System.out.println("삭제할 유저를 찾을 수 없습니다.");
                        }
                        break;

                    // 선택한 User 정보 수정
                    case 5:

                        // 수정할 유저의 id를 입력 받고, pw와 별명을 수정
                        System.out.println("ID, PW, 별명순으로 입력");

                        // id, pw, nick
                        user.setUserId(controlCRUD.next());
                        user.setUserPwd(controlCRUD.next());
                        user.setUserNick(controlCRUD.next());

                        // 작업 결과
                        if (userS.update(user) == 1) {
                            System.out.println("유저 정보 변경 완료");
                        }
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
                        // 사용자에게 새로 만들 게시글의 정보를 입력 받음
                        System.out.println("ID, 제목, 내용순으로 입력");

                        controlCRUD.nextLine();

                        // 게시글 생성 유저 id, title, content
                        board.setUserId(controlCRUD.nextLine());
                        board.setTitle(controlCRUD.nextLine());
                        board.setContent(controlCRUD.nextLine());

                        // 작업 결과
                        if (boardS.insert(board) == 1) {
                            System.out.println("게시글 작성 성공");
                        }
                        break;

                    // 선택한 게시글 출력
                    case 2:

                        // 사용자에게 출력할 게시글의 index를 입력받음
                        System.out.println("검색할 게시물의 index 입력");
                        board.setBoardIndex(controlCRUD.nextInt());

                        // 작업 결과
                        if (boardS.select(board) != null) {
                            System.out.println(boardS.select(board));
                        } else {
                            System.out.println("입력한 게시글을 찾을 수 없습니다.");
                        }
                        break;

                    // 모든 게시글 출력
                    case 3:
                        boardS.selectAll();
                        break;
                    // 선택한 게시글 삭제

                    case 4:

                        // 삭제할 게시글의 index를 사용자에게 입력 받음
                        System.out.println("게시글 번호 입력");

                        // 입력 받은 게시글 index를 전달
                        board.setBoardIndex(controlCRUD.nextInt());

                        // 작업 결과
                        if (boardS.delete(board) == 1) {
                            System.out.println("삭제 완료");
                        } else {
                            System.out.println("삭제할 게시글이 없습니다.");
                        }
                        break;

                    // 선택한 게시글 수정
                    case 5:

                        // 수정할 게시글의 index를 입력 받고, 제목과 내용을 변경
                        System.out.println("게시글 번호, 제목, 내용순으로 입력");

                        // 게시글 index, title, content
                        board.setBoardIndex(controlCRUD.nextInt());
                        controlCRUD.nextLine();
                        board.setTitle(controlCRUD.nextLine());
                        board.setContent(controlCRUD.nextLine());

                        // 작업 결과
                        if (boardS.update(board) == 1) {
                            System.out.println("게시글 수정 완료");
                        } else {
                            System.out.println("게시글 수정 실패");
                        }
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

                        // 댓글을 입력할 수 있는 게시글 출력
                        boardS.selectAll();

                        // 사용자에게 새로 만들 댓글의 정보를 입력 받음

                        System.out.println("ID, 댓글을 입력할 게시물 번호, 내용, 답글을 입력할 댓글(없으면 0)");

                        // 사용자 id, 게시물 index, content, 답글 번호
                        comment.setUserId(controlCRUD.next());
                        comment.setBoardIndex(controlCRUD.nextInt());
                        controlCRUD.nextLine();
                        comment.setContent(controlCRUD.nextLine());
                        comment.setParentIndex(controlCRUD.nextInt());

                        // 작업 결과
                        if (commentS.insert(comment) == 1) {
                            System.out.println("댓글 추가 성공");
                        }
                        break;

                    // 모든 댓글 출력
                    case 2:
                        commentS.select();
                        break;

                    // 선택한 댓글 삭제
                    case 3:

                        // 삭제할 댓글의 index를 사용자에게 입력 받음
                        System.out.println("삭제할 댓글 번호 입력");
                        comment.setCommentIndex(controlCRUD.nextInt());

                        // 작업 결과
                        if (commentS.delete(comment) == 1) {
                            System.out.println("댓글 삭제 성공");
                        } else {
                            System.out.println("삭제할 댓글을 찾을 수 없습니다.");
                        }
                        break;

                    // 선택한 댓글 수정
                    case 4:

                        // 수정할 댓글의 번호를 사용자에게 입력 받음
                        System.out.println("댓글 번호, 내용 입력");

                        // 댓글 번호, 수정할 댓글 내용
                        comment.setCommentIndex(controlCRUD.nextInt());
                        controlCRUD.nextLine();
                        comment.setContent(controlCRUD.nextLine());

                        // 작업 결과
                        if (commentS.update(comment) == 1) {
                            System.out.println("댓글 수정 성공");
                        } else {
                            System.out.println("수정할 댓글을 찾을 수 없습니다.");
                        }
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
