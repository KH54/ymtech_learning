package educate_task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author "KyungHun Park"
 * @since 2021. 8. 20.
 *
 */
public class ThirdMission {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        String[] array = new String[10];

        ListToArray(arrayList, array);
        ArrayToList(arrayList, array);

    }

    // List를 Array로 변경
    public static String[] ListToArray(List<String> arrayList, String[] array) {
        array = arrayList.toArray(new String[0]);

        return array;
    }

    // Array를 List로 변경
    public static List<String> ArrayToList(List<String> arrayList, String[] array) {
        arrayList = Arrays.asList(array);

        return arrayList;
    }
}
