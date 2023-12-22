public class Teacher extends Member {
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
        return String.format("Teacher \u001B[31m%s\u001B[0m has given student \u001B[35m%s\u001B[0m a test. %s",
                this.getName(), s.getName(), s.getName(), pityStats(s, 2 * s.getLevel(), 3 * s.getLevel()));

    }

    public String giveEC(Student s) {
        s.changeGrade(1);
        s.changeSanity(15 - s.getLevel());
        HP--;
        return String.format("Teacher \u001B[31m%s\u001B[0m has given \u001B[35m%s\u001B[0m extra credit. %s",
                this.getName(), s.getName(), pityStats(s, -1, -15 + s.getLevel()));

    }
    public String giveHomework(Student s) {
        s.changeGrade(-s.getLevel());
        s.changeSanity(-1);
        HP--;
        return String.format("Teacher \u001B[31m%s\u001B[0m has given \u001B[35m%s\u001B[0m homework. %s \n Teacher HP is now %d",
                this.getName(), s.getName(), pityStats(s, -s.getLevel(), -1), this.getHP());
    }
    public String stats() {
        return String.format(" Teacher  %s \n  Room: %d \n HP: %d \n", this.getName(), avgGrade, HP);
    }

    public String pityStats(Student s, int points_lost, int sanity_lost) {
        String f = String.format("Student \\u001B[35m%s\\u001B[0m's has lose %d points and %d sanity \n %s", s.getName(), points_lost, sanity_lost, s.getStats());
        return f;
    }
}
