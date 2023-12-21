public class AP extends Teacher {
    private String name;
    private String department;

    public AP(String name, int HP, String department) {
        super(name, HP);
        this.department = department;
    }

    @Override
    public String giveTest(Student s) {
        s.changeGrade(-4 * s.getLevel());
        this.changeHP(-1);
        ;
        return "Your HP is " + this.getHP();
    }

    @Override
    public String giveEC(Student s) {
        s.changeGrade(-2 * s.getLevel());
        this.changeHP(-1);

        return "Your HP is " + this.getHP();
    }

    @Override
    public String giveHomework(Student s) {
        s.changeGrade(-2 * s.getLevel());
        s.changeSanity(-1);
        this.changeHP(-1);
        ;

        return String.format("AP %s has given %s homework. Your sanity is now %d and grade is now %d",
                this.getName(), s.getName(), s.getMentalSanity(), s.getGrade());
    }

    public String stats() {
        return String.format(" AP  %s \n  Room: %d \n HP: %d \n", name, department, this.getHP());
    }

    @Override
    public int getOption() {
        return 4;
    }

}