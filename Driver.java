import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Student a = new Student("Tom");
        Student b = new Student("Bill");

        Teacher t = new Teacher("Mr. Smith", 10);
        Teacher t2 = new Teacher("Mr. Jones", 10);

        // AP c = new AP("Mr. Thomas", 95, "Technology");
        // AP d = new AP("Mr. Walsh", 95, "Math");

        System.out.println(utils.respondS(a, t, input, 0));
        System.out.println(utils.respondS(b, t2, input, 0));

        // System.out.println(utils.respondS(a, c, input, 0));
        // System.out.println(utils.respondS(d, d, input, 0));

        input.close();
    }
}