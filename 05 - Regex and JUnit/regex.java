/*Problem 1
 * import java.util.Scanner;
public class regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        if (username.matches(regex)) {
            System.out.println("Valid username");
        } else {
            System.out.println("Invalid username");
        }
        scanner.close();
    }
}*/
/* Problem 2
 * import java.util.Scanner;
public class regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a license plate number: ");
        String plate = scanner.nextLine();
        String regex = "^[A-Z]{2}[0-9]{4}$";
        if (plate.matches(regex)) {
            System.out.println("Valid license plate");
        } else {
            System.out.println("Invalid license plate");
        }
        scanner.close();
    }
}*/

/*
 * PRoblem 3
 * import java.util.Scanner;
public class regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a hex color code: ");
        String colorCode = scanner.nextLine();
        String regex = "^#[0-9A-Fa-f]{6}$";
        if (colorCode.matches(regex)) {
            System.out.println("Valid hex color code");
        } else {
            System.out.println("Invalid hex color code");
        }
        scanner.close();
    }
}*/

/*Problem 4
 * import java.util.regex.*;
import java.util.Scanner;
public class regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text containing email addresses:");
        String text = scanner.nextLine();
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Extracted email addresses:");
        boolean found = false;
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }
        if (!found) {
            System.out.println("No email addresses found.");
        }
        scanner.close();
    }
}*/

/*Problem 5
 * import java.util.regex.*;
import java.util.Scanner;
public class regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();
        String regex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sentence);
        System.out.println("Capitalized words:");
        boolean found = false;
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }
        if (!found) {
            System.out.println("No capitalized words found.");
        }
        scanner.close();
    }
}*/

/*
 * Problem 6
 * import java.util.regex.*;
import java.util.Scanner;
public class regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text containing dates:");
        String text = scanner.nextLine();
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Extracted dates:");
        boolean found = false;
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }
        if (!found) {
            System.out.println("No dates found.");
        }
        scanner.close();
    }
}*/

/*
 * PRoblem 7
 * import java.util.regex.*;
import java.util.Scanner;
public class regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text containing links:");
        String text = scanner.nextLine();
        String regex = "\\bhttps?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Extracted links:");
        boolean found = false;
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }
        if (!found) {
            System.out.println("No links found.");
        }
        scanner.close();
    }
}*/

/*
 * Problem 8
 * import java.util.Scanner;
public class regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence with multiple spaces:");
        String input = scanner.nextLine();
        String result = input.replaceAll("\\s+", " ");
        System.out.println("After replacing multiple spaces:");
        System.out.println(result);
        scanner.close();
    }
}*/

/*
 * Problem 9
 * import java.util.Scanner;
public class regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();
        String[] badWords = { "damn", "stupid" };
        for (String word : badWords) {
            sentence = sentence.replaceAll("(?i)\\b" + word + "\\b", "****");
        }
        System.out.println("Censored sentence:");
        System.out.println(sentence);
        scanner.close();
    }
}*/

/*
 * Problem 10
 * import java.util.Scanner;
public class regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an IP address: ");
        String ip = scanner.nextLine();
        String regex = "^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}"
                     + "(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$";
        if (ip.matches(regex)) {
            System.out.println("Valid IPv4 address");
        } else {
            System.out.println("Invalid IPv4 address");
        }
        scanner.close();
    }
}*/

/*
 * Problem 11
 * import java.util.Scanner;
public class regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a credit card number: ");
        String cardNumber = scanner.nextLine();
        String visaRegex = "^4\\d{15}$";
        String masterRegex = "^5\\d{15}$";
        if (cardNumber.matches(visaRegex)) {
            System.out.println("Valid Visa card");
        } else if (cardNumber.matches(masterRegex)) {
            System.out.println("Valid MasterCard");
        } else {
            System.out.println("Invalid credit card number");
        }
        scanner.close();
    }
}*/

/*
 *Problem 12 
 *import java.util.Scanner;
import java.util.regex.*;
public class regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String text = scanner.nextLine();
        String regex = "\\b(JavaScript|Java|Python|Go|C\\+\\+|C#|Ruby|Swift|Kotlin|Rust)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Extracted programming languages:");
        boolean found = false;
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }
        if (!found) {
            System.out.println("No programming languages found.");
        }
        scanner.close();
    }
}*/

/*
 * Problem 13
 * import java.util.Scanner;
import java.util.regex.*;
public class regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text containing currency values:");
        String text = scanner.nextLine();
        String regex = "\\$?\\d+\\.\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Extracted currency values:");
        boolean found = false;
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }
        if (!found) {
            System.out.println("No currency values found.");
        }
        scanner.close();
    }
}*/

/*PRoblem 14
 * import java.util.Scanner;
import java.util.regex.*;
import java.util.HashSet;
public class regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String text = scanner.nextLine();
        String regex = "\\b(\\w+)\\b\\s+\\1\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        HashSet<String> repeatedWords = new HashSet<>();
        while (matcher.find()) {
            repeatedWords.add(matcher.group(1));
        }
        if (repeatedWords.isEmpty()) {
            System.out.println("No repeating words found.");
        } else {
            System.out.println("Repeating words:");
            for (String word : repeatedWords) {
                System.out.println(word);
            }
        }
        scanner.close();
    }
}*/

/*Problem 15
 * import java.util.Scanner;
import java.util.regex.*;
public class regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence containing SSN:");
        String text = scanner.nextLine();
        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        boolean found = false;
        while (matcher.find()) {
            System.out.println("\"" + matcher.group() + "\" is valid");
            found = true;
        }
        if (!found) {
            System.out.println("No valid SSN found");
        }
        scanner.close();
    }
}*/

/*Problem 16
 * import java.util.Scanner;
import java.util.regex.*;
public class regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String regex = "\\b[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        scanner.close();
    }
}*/

/*Problem 17
 * import java.util.Scanner;
import java.util.regex.*;
public class regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String regex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        scanner.close();
    }
}*/

/*Problem 18import java.util.Scanner;
import java.util.regex.*;
public class regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        scanner.close();
    }
}*/
