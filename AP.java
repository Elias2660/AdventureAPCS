public class AP extends Teacher {
    private String name;
    private String department;

    public AP(String name, int HP, String department) {
        super(name, HP);
        this.department = department;
    }

    @Override
    public String giveTest(Student s) {
        s.changeGrade(-8 * s.getLevel());
        this.changeHP(-1);
        ;
        return String.format("AP \u001B[31m%s\u001B[0m has given student \u001B[35m%s\u001B[0m a test. %s",
                this.getName(), s.getName(), s.getName(), pityStats(s, 2 * s.getLevel(), 3 * s.getLevel()));
    }

    @Override
    public String giveEC(Student s) {
        s.changeGrade(2 * s.getLevel());
        this.changeHP(-1);

        return String.format("AP \u001B[31m%s\u001B[0m has given student \u001B[35m%s\u001B[0m a test. %s",
                this.getName(), s.getName(), s.getName(), pityStats(s, 2 * s.getLevel(), 3 * s.getLevel()));
    }

    @Override
    public String giveHomework(Student s) {
        s.changeGrade(-4 * s.getLevel());
        s.changeSanity(-1);
        this.changeHP(-1);
        ;

        return String.format("AP \u001B[31m%s\u001B[0m has given student \u001B[35m%s\u001B[0m a test. %s",
                this.getName(), s.getName(), s.getName(), pityStats(s, 2 * s.getLevel(), 3 * s.getLevel()));
    }

    public String stats() {
        return String.format(" AP  %s \n  Room: %d \n HP: %d \n", name, department, this.getHP());
    }

    @Override
    public int getOption() {
        return 3;
    }

}