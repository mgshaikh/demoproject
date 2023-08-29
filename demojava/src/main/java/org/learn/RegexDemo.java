package org.learn;

import java.util.regex.Pattern;
import java.nio.file.Files;
import java.util.List;
import java.util.regex.Matcher;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.io.IOException;


public class RegexDemo {

    public static void main(String[] args) {

        // String str = "01This is 88 a test 9string100";

        // // regex to extract all numbers from the string
        // String regex = "\\d+";

        // Pattern pattern = Pattern.compile(regex);
        // Matcher matcher = pattern.matcher(str);

        // // extract the numbers from the string and store it in a List
        // List<String> numbers = matcher.results()
        //         .map(matchResult -> matchResult.group())
        //         .toList();

        // // print the numbers
        // numbers.forEach(System.out::println);

        extractPhoneNumbers();

    }

    // static method to validate a given email using regex
    public static boolean validateEmail(String email) {
        String regex = "^([a-zA-Z0-9+_.-])+@([a-zA-Z0-9.-])+\\.([a-zA-Z]{2,3})$";
        return Pattern.matches(regex, email);
    }

    /*
     * method to read the file imptfile.txt
     * extract the phone numbers present in the file in any phone format
     */

    public static void extractPhoneNumbers() {
        // read the file imptfile.txt

        try {
            String str = Files.lines(Path.of("imptfile.txt"))
                    .collect(Collectors.joining("\n"));
            // regex to search for phone numbers in the below formats
        //  xxx-xxx-xxxx
        //  xxx xxx xxxx
        //  xxxxxxxxxx
        //  (xxx) xxx-xxxx

            String regex = "(\\d{3}[- .]?){2}\\d{4}|\\(\\d{3}\\) \\d{3}-\\d{4}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(str);

            // extract the numbers from the string and store it in a List
            List<String> numbers = matcher.results()
                    .map(matchResult -> matchResult.group())
                    .toList();

            // print the phone numbers
            numbers.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }
    }

    // method to validate a date string in any format
    // return 1 if the date is in format dd/mm/yyyy
    // return 2 if the date is in format mm/dd/yyyy
    // return 3 if the date is in format yyyy/mm/dd
    // return 0 if the date is invalid
    
    public static int validateDate(String date) {
        String regex = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.]\\d{4}$";
        String regex2 = "^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.]\\d{4}$";
        String regex3 = "^\\d{4}[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$";
        if (Pattern.matches(regex, date)) {
            return 1;
        }
        else if (Pattern.matches(regex2, date)) {
            return 2;
        }
        else if (Pattern.matches(regex3, date)) {
            return 3;
        }
        else {
            return 0;
        }
    }
    


}
