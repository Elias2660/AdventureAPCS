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

    //setters
    public void changeHP(int change) {
        HP += change;
    }

    public String respond(Student s) {

        // will get call a students's response method to continiously respond
        int choice = (int) (Math.random() * 3) + 1;
        String response;
        if (HP == 0) {
            System.out.println("School Year is over!");
            System.out.println("You have Survived");
            return s.stats();
        }
        //next step would be to make sure to implement this correctly
        if (choice == 0) {
            response =  this.giveTest(s);
        } else if (choice == 1) {
            response =  this.giveEC(s);
        } else {
            response =  this.giveHomework(s);
        }
        return response + s.respond(this);
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
        System.out.printf("Teacher %s has given %s homework. Your sanity is nwo %d and grade is now %d \n",
                this.getName(), s.getName(), s.getMentalSanity(), s.getGrade());
        return "Your Hp is" + HP;
    }

    public String stats() {
        return String.format(" Teacher  %s \n  Room: %d \n HP: %d \n", name, avgGrade, HP);
    }
}
