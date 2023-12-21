public class AP extends Member {
    private String department;
    private int HP;

    public AP(String name, int HP, String department) {
        super(name);
        this.HP = HP;
        this.department = department;
    }

    public String giveDepartmentFinal(Student s) {
        s.changeGrade(-4 * s.getLevel());
        HP--;
        return "Your HP is " + HP;
    }

    public String failStudent(Student s) {
        s.setGrade(64);
        HP--;
        return "Your HP is " + HP;
    }

    @Override
    public String giveHomework(Student s) {
        s.changeGrade(-2 * s.getLevel());
        s.changeSanity(-1);
        HP--;
        return String.format("AP %s has given %s homework. Your sanity is now %d and grade is now %d",
                this.getName(), s.getName(), s.getMentalSanity(), s.getGrade());
    }

    @Override
    public String respond(Student s) {
        int choice = (int) (Math.random() * 2); // 0 or 1
        String response;

        if (HP == 0) {
            System.out.println("School Year is over!");
            System.out.println("You have Survived");
            return s.stats();
        }

        if (choice == 0) {
            response = this.giveDepartmentFinal(s);
        } else {
            response = this.giveHomework(s);
        }
        return response + s.respond(this);
    }
}
