import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Pattern patternNum = Pattern.compile("[^0-9]");
        Pattern patternSym = Pattern.compile("[^0-9/]");

        System.out.print("Дата: ");
        String string =  scan.nextLine();
        int day = 0,
            month = 0,
            year = 0;

        try {
            if (string.length() != 10){
                System.out.println("Введенное выражение не является датой");
                return;
            }
            Matcher m = patternSym.matcher(string);
            if (m.find()){
                System.out.println("Введенное выражение не соответствует заданному формату даты dd/mm/yyyy");
                return;
            }
            m = patternNum.matcher(string.substring(0,2));
            if (m.find()){
                System.out.println("Введенное выражение не соответствует заданному формату даты dd/mm/yyyy");
                return;
            }
            m = patternNum.matcher(string.substring(3,5));
            if (m.find()){
                System.out.println("Введенное выражение не соответствует заданному формату даты dd/mm/yyyy");
                return;
            }
            m = patternNum.matcher(string.substring(6));
            if (m.find()){
                System.out.println("Введенное выражение не соответствует заданному формату даты dd/mm/yyyy");
                return;
            }

            for (int i=0;i<string.length();i++) {

                if (i < 2) {
                    day = day * 10 + string.charAt(i) - '0';
                }
                else if (i>2 && i<5) {
                    month = month*10 +string.charAt(i) - '0';
                }
                else if (i > 5 && i < 10) {
                    year = year*10 + string.charAt(i) - '0';
                }
            }
            if (year <1900 || year > 9999) {
                System.out.println("Выражение не является датой");
                return;
            }
            if (month < 1 || month > 12){
                System.out.println("Выражение не является датой");
                return;
            }

            int maxDayOfMonth;
            switch (month){
                case 2: if ((year-1900)%4 == 0) maxDayOfMonth = 29; else maxDayOfMonth = 28; break;
                case 4: maxDayOfMonth = 30;break;
                case 6: maxDayOfMonth = 30;break;
                case 9: maxDayOfMonth = 30;break;
                case 11: maxDayOfMonth = 30;break;
                default: maxDayOfMonth = 31;break;
            }
            if (day < 1 || day > maxDayOfMonth){
                System.out.println("Выражение не является датой");
                return;
            }

            System.out.println("Выражение является датой");
        }
        catch (Exception e) {
            System.out.print(e);
        }
    }
}