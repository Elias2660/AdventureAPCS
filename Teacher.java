public class Teacher extends Member {
    private String name;
    private int HP;
    private double avgGrade;

    public Teacher(String name, int HP) {
        super(name);
        this.HP = HP;
    }

    //getters
    public int getHP() {
        return HP;
    }

    public int getOption() {
        return 3;
    }

    //setters
    public void changeHP(int change) {
        HP += change;
    }

    // special actions
    public String giveTest(Student s) {
        // deal some damage to the student
        s.changeGrade(-2 * s.getLevel());
        s.changeSanity(-3 * s.getLevel());
        HP--;
        return String.format("Teacher %s has given you a test. You have lost %d points and grade is now %d",
                this.getName(), 2 * s.getLevel(), s.getGrade());

    }

    public String giveEC(Student s) {
        s.changeGrade(1);
        s.changeSanity(15 - s.getLevel());
        HP--;
        return String.format("Teacher %s has given %s extra credit. Your sanity is now %d and grade is now %d",
                this.getName(), s.getName(), s.getMentalSanity(), s.getGrade());

    }
    public String giveHomework(Student s) {
        s.changeGrade(-s.getLevel());
        s.changeSanity(-1);
        HP--;
        return String.format("Teacher %s has given %s homework. Your sanity is now %d and grade is now %d \n Teacher HP is now %d",
                this.getName(), s.getName(), s.getMentalSanity(), s.getGrade(), this.getHP());
    }
    public String stats() {
        return String.format(" Teacher  %s \n  Room: %d \n HP: %d \n", this.getName(), avgGrade, HP);
    }
}
