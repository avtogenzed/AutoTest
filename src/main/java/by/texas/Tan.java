package by.texas;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Tan {
    public static void main(String[] args) {
        String date = "Dec-10-2020";
        LocalDate myDate = LocalDate.of(2018, Month.APRIL, 12);
        System.out.println(myDate.isBefore(stringToDate(date)));

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        System.out.println("---> " + isListContainsElement(list, "2"));
    }

    private static LocalDate stringToDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy").withLocale(Locale.US);
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }

    /*private static boolean isListContainsElement(List<String> list, String element) {
        Object object = list.stream().filter(item -> element.equals(item)).findAny().orElse(null);
        return object != null;
    }*/

    private static boolean isListContainsElement(List<String> list, String element) {
        return list.stream().allMatch(element::equals);
    }
}
