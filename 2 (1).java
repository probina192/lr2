import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) {
        Pattern patternNum = Pattern.compile("[0-9]");
        Pattern patternSymLittle = Pattern.compile("[a-z]");
        Pattern patternSymBig = Pattern.compile("[A-Z]");
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9_]");
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("Пароль: ");
            String string = scan.nextLine();
            if (string.length() < 8){
                System.out.println("Пароль ненадежен. Повторите ввод 1");
                continue;
            }
            Matcher m = pattern.matcher(string);
            if (m.find()){
                System.out.println("Пароль ненадежен. Повторите ввод 2");
                continue;
            }
            m = patternNum.matcher(string);
            if (!m.find()){
                System.out.println("Пароль ненадежен. Повторите ввод 3");
                continue;
            }
            m = patternSymLittle.matcher(string);
            if (!m.find()){
                System.out.println("Пароль ненадежен. Повторите ввод 4");
                continue;
            }
            m = patternSymBig.matcher(string);
            if (!m.find()){
                System.out.println("Пароль ненадежен. Повторите ввод 5");
                continue;
            }

            System.out.println("Пароль надежен");
            return;
        }
    }
}