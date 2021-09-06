package com.ymtech.crud;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 *        DB의 'info' TABLE에 접근하여 사용자에게 입력 받은 값으로 CRUD 수행
 * 
 * @author "KyungHun Park"
 * @since 2021. 9. 03.
 * 
 */
public class Crud {
    public static void main(String[] args) {

        // DbControl Class 인스턴스 생성
        DbControl dc = new DbControl();

        // log 출력을 위한 logger 생성
        Logger logger = Logger.getLogger(Crud.class);

        // 사용자에게 입력을 받기 위한 Scanner Class 인스턴스 생성
        Scanner controlCRUD = new Scanner(System.in);

        // 작업을 수행하기 위해 사용자에게 입력 받은 수를 저장하는 변수
        int control = 0;

        // break까지 계속 수정이 가능하도록 While문 사용
        while (true) {

            try {
                // 수행할 CRUD 선택
                System.out.println("TABLE에서 수행할 작업을 고르세요");
                System.out.println("1 : insert, 2 : delete, 3 : update, 4 : read, 5 : quit");

                // 사용자에게 작업을 입력받음
                control = controlCRUD.nextInt();

            } catch (InputMismatchException ie) { // int형 타입이 아닌 값이 입력되었을 때 로그를 출력한 후 재입력 요청

                // enter를 기준으로 값을 리턴하는 nextLine() 메소드. 입력된 값을 초기화 시켜준다.
                controlCRUD.nextLine();
                logger.info("\n 숫자를 입력해주세요") ;
                continue; // 재입력 요청

            } catch (Exception e) { // 로그를 출력하고 시스템 종료
                logger.error("\n 시스템 종료", e);
                System.exit(0);
            }

            /* 사용자의 입력에 따른 메소드 호출 */
            switch (control) {
            case 1: // 추가
                dc.insert();
                break;

            case 2: // 삭제
                dc.delete();
                break;

            case 3: // 변경
                dc.update();
                break;

            case 4: // 읽기
                dc.read();
                break;

            case 5: // 시스템 종료
                System.out.println("시스템 종료");
                controlCRUD.close(); // scanner 종료
                System.exit(0);

            default: // 1~5가 아닌 다른 숫자를 입력한 경우
                System.out.println("선택지에 있는 숫자만 입력해주세요");
                break;
            }
            controlCRUD.nextLine(); // 입력받았던 내용 초기화
        }

    }
}