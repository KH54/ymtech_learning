package educate_task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SecondMission {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>(); // 입력 받을 list
        List<String> answerList = new ArrayList<>();
        
        list.add("a");
        list.add("e");
        list.add("e");
        list.add("i");
        list.add("o");
        list.add("o");
        list.add("u");
        list.add("i");
        list.add("z");
        
        for(String data : list) {
        if(!answerList.contains(data))
            answerList.add(data);
    }
        System.out.println(answerList);

    }
}
