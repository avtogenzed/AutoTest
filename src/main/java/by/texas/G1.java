package by.texas;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class G1 {
    public static void main(String[] args) {
        String text = "$ 100.00";
        System.out.println(x(text, Y.NUMBER));
        System.out.println(z("d121sada > Edit Coverage"));
        System.out.println("Max value = " + maxValue());
        System.out.println("=" + trimSpace(" ds dd ") + "=");
        System.out.println("Random round = " + round());
        ArrayList<String> a = new ArrayList<>();
        a.add("5");
        ArrayList<String> b = new ArrayList<>(a);
        b.add("7");
        ArrayList<String> c = a;
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());

        List<String> beforeList = new ArrayList<>();
        beforeList.add("a");
        beforeList.add("0");
        beforeList.add("");

        List<String> afterList = beforeList
                .stream()
                .filter(s -> !s.isEmpty())
                .filter(s -> !s.equals("0"))
                .collect(Collectors.toList());
        System.out.println(afterList);

        List<String> copyList = new ArrayList<>();
        copyList.add("Hello");
        List<String> newCopyList = copyList;
        copyList.add("7");

        System.out.println("new list = " + newCopyList);

        List<String> cloneList = new ArrayList<>(copyList);
        copyList.add("12");
        System.out.println("clone list = " + cloneList);

        isStringNumber("555.0");

        compareMap();

        random1();

       /* String[] arr = {"A ", "B ", "C "};
        List<String> l = Arrays.asList(arr);
        List<String> dd = l.stream().map(i -> i.replace(" ", "+1")).collect(Collectors.toList());

        dd.forEach(System.out::println);*/
        String[] arr = {"A ", "B ", "C "};
        Object[] f = Arrays.stream(arr).map(i -> i.replace(" ", "+1")).toArray();

        for(Object i:f){
            System.out.println(i);
        }
    }

    private static void compareMap() {
        Map<String, String> firstMap = new HashMap<>();
        firstMap.put("1", "abc1");
        firstMap.put("2", "abc2");
        firstMap.put("3", "abc3");
        firstMap.put("4", "abc4");
        firstMap.put("5", "abc5");
        firstMap.put("7", "abc5");
        Map<String, String> secondMap = new HashMap<>();
        secondMap.put("1", "abc1");
        secondMap.put("2", "abc2");
        secondMap.put("3", "abc3");
        secondMap.put("4", "abc4");
        secondMap.put("5", "abc5");

        firstMap.forEach((key, value) -> {
            secondMap.forEach((k, v) -> {
                if (key.equals(k)) {
                    if(value.equals(v)){
                        //System.out.println(key  + " equals " + k + " ; " + value + " equals " + v);
                    }else {
                        System.out.println("No");
                    }
                } //fix check dropdown
            });
        });
    }

    private static void isStringNumber(String line) {
        if (line.matches("\\d+\\.*\\d*")) {
            line = line.replace(".00", "");
            System.out.println("---> " + line);
        }
        System.out.println("---");
    }

    private static void isDate(String line) {

    }

    public enum Y {
        NOTATION, NUMBER
    }

    private static String x(String line, Y y) {
        String resultLine = "";
        int resultGroup = 0;
        switch (y) {
            case NUMBER:
                resultGroup = 1;
                break;
            case NOTATION:
                resultGroup = 2;
                break;
        }
        Pattern pattern = Pattern.compile("(\\d+[.]\\d+)\\s*([A-Z])*");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            resultLine = matcher.group(resultGroup);
        }
        return resultLine;
    }

    private static boolean z(String line) {
        boolean result = false;
        Pattern pattern = Pattern.compile("\\w+\\s+[>]\\s+" + "Edit Coverage");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            matcher.group();
            result = true;
        }
        return result;
    }

    private static double maxValue() {
        double maxValue = 0;
        for (int i = 0; i < 5; i++) {
            int randomValue = (int) (Math.random() * ((10 - 1) + 1)) + 1;
            System.out.println("Random value = " + randomValue);
            if (randomValue > maxValue) {
                maxValue = randomValue;
            }
        }
        return maxValue;
    }

    private static String trimSpace(String line) {
        String result = "";
        Pattern pattern = Pattern.compile("\\w+\\s+\\w*");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            result = matcher.group();
        }
        return result;
    }

    private static String round() {
        double r = (int) ((Math.random() * 10) + 1);
        String ret = String.format("%.2f", r);
        return ret;
    }

    private static void random1() {
        String[] array = {"No", "Yes"};
        int min = 1;
        int max = array.length - 1;
        int randomValue = (int) ((Math.random() * (max - min)) + min);
        String value = array[randomValue];
        System.out.println(value);
    }
}
