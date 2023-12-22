import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Student a = new Student("Tom");
        Student b = new Student("Bill");
        Student c = new Student("Jack");
        Student d = new Student("Elias");

        Teacher t = new Teacher("Mr. Smith", 10);
        Teacher t2 = new Teacher("Mr. Jones", 10);

        AP a1 = new AP("Mr. Thomas", 95, "Technology");
        AP a2 = new AP("Mr. Walsh", 95, "Math");

        System.out.println(utils.respondS(a, t, input, 0));
        System.out.println(utils.respondS(b, t2, input, 0));

        System.out.println(utils.respondS(c, a1, input, 0));
        System.out.println(utils.respondS(d, a2, input, 0));

        input.close();
    }
}