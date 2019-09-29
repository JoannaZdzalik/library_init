package inputValidations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {

    public static boolean validateISBN(String typedISBN) {
        Pattern passwordPattern = Pattern.compile("[0-9]{13}");
        Matcher matcher = passwordPattern.matcher(typedISBN);

        return matcher.matches();
    }

    public static boolean validatePages(String typedPages) {
        Pattern passwordPattern = Pattern.compile("[0-9]{1,}");
        Matcher matcher = passwordPattern.matcher(typedPages);

        return matcher.matches();
    }


}
