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
        return String.format("Teacher %s has given student \u001B[35m%s\u001B[0m a test. \u001B[35m%s\u001B[0m have lost %d points and grade is now %d",
                this.getName(), s.getName(), s.getName(), 2 * s.getLevel(), s.getGrade());

    }

    public String giveEC(Student s) {
        s.changeGrade(1);
        s.changeSanity(15 - s.getLevel());
        HP--;
        return String.format("Teacher %s has given \u001B[35m%s\u001B[0m extra credit. \u001B[35m%s\u001B[0m's sanity is now %d and grade is now %d",
                this.getName(), s.getName(), s.getName(), s.getMentalSanity(), s.getGrade());

    }
    public String giveHomework(Student s) {
        s.changeGrade(-s.getLevel());
        s.changeSanity(-1);
        HP--;
        return String.format("Teacher %s has given \u001B[35m%s\u001B[0m homework. \u001B[35m%s\u001B[0m's sanity is now %d and grade is now %d \n Teacher HP is now %d",
                this.getName(), s.getName(),s.getName(), s.getMentalSanity(), s.getGrade(), this.getHP());
    }
    public String stats() {
        return String.format(" Teacher  %s \n  Room: %d \n HP: %d \n", this.getName(), avgGrade, HP);
    }
}
