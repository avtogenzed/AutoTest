package by.texas;

import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        Map map = new HashMap<>();
        map.put("a", "art");
        map.put("b", "abv");

        String result = (String) map.get("a");
        System.out.println(result);

        list.add("1 abc");
        list.add("1-abc");
        list.add("1_abc");
        list.add("1abc");

        WebElement element;

//        System.out.println();
        Collections.sort(list, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (String l : list) {
            System.out.println(l);
        }
        System.out.println(Helper.stringGeneration());
        find("find 5 from   5");
    }

    private static void find(String text) {
        String regex = ".+\\s+\\d+\\s+.+\\s+\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.toMatchResult());
        }
    }
}

