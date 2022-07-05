/**
 * Old Model을 New Model로 변환 후 출력
 * 
 * @author "KyungHun Park"
 * @since 2021. 9. 6.
 * 
 */
public class Car {
    public static void main(String[] args) {
        // model 객체 생성
        OldModel om = new OldModel();
        NewModel nm = new NewModel();
        
        // Old Model의 필드 출력
        System.out.println(om.toString());
        
        // New Model의 필드 출력
        System.out.println(nm.toString());
        
        // Old Model에 New Model 변환
        OldModel castOm = new OldModel(nm);
        NewModel castNm = new NewModel(om);
        
        // 변환한 om 출력
        System.out.println(castOm.toString());
        System.out.println(castNm.toString());
    }
}