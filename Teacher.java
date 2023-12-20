public class Teacher extends Member{
    private String name;
    private int HP;
    private double avgGrade;

    public Teacher(String name, int HP) {
        super(name);
        this.HP = HP;
    }

    // getters
    public String getName() {
        return this.getName();
    }

    public String respond(Student s) {

        // will get call a students's response method to continiously respond
        int choice = (int) (Math.random() * 3);
        if (HP == 0) {
            System.out.println("School Year is over!");
            System.out.println("You have Survived");
            return s.stats();
        }
        if (choice == 0) {
            return this.giveTest(s);
        } else if (choice == 1) {
            return this.giveEC(s);
        } else {
            return this.giveHomework(s);
        }
    }

    // special actions
    public String giveTest(Student s) {
        // deal some damage to the student
        s.changeGrade(-2 * s.getLevel());
        s.changeSanity(-3 * s.getLevel());
        HP--;
        System.out.printf("Teacher has given you a test. You have lost %d points and grade is now %d",
                2 * s.getLevel(), s.getGrade());
        return "Your Hp is" + HP;

    }

    public String giveEC(Student s) {
        s.changeGrade(1);
        s.changeSanity(15 - s.getLevel());

        HP--;
        return "Your Hp is" + HP;

    }

    public String giveHomework(Student s) {
        s.changeGrade(-s.getLevel());
        s.changeSanity(-1);
        HP--;
        System.out.printf("Teacher has given you homework. Your sanity is nwo %d and grade is now %d",
                s.getMentalSanity(), s.getGrade());
        return "Your Hp is" + HP;
    }

    public String stats() {
        return String.format(" Teacher Name: %s \n  Room: %d \n HP: %d \n", name, avgGrade, HP);
    }
}
