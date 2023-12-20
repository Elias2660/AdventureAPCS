public class Driver{
    public static void main(String[] args) {
        Student a = new Student("Tom");
        Student b = new Student("Bill");

        Teacher t = new Teacher("Mr. Smith", 10);
        Teacher t2 = new Teacher("Mr. Jones", 10);

        System.out.println(a.respond(t));
        System.out.println(b.respond(t2));
    }
}