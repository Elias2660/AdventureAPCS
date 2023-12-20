import java.util.Scanner;

public class Student extends Member {
    // students will have a name and a grade level
    private int level = 9;
    private int grade = 95;
    private int mentalSanity = 50;

    public Student(String name) {
        super(name);
    }

    // getters

    public int getLevel() {
        return level;
    }

    public int getMentalSanity() {
        return mentalSanity;
    }

    public int getGrade() {
        return grade;
    }

    // setters
    public void changeSanity(int change) {
        mentalSanity += change;
    }

    public void changeGrade(int change) {
        grade += change;
    }

    // methods
    @Override
    public String stats() {
        return String.format("Student Name: %s \n Level: %d \n Grade: %d \n Mental Sanity: %d \n", this.getName(),
                level, grade,
                mentalSanity);
    }

    public String respond(Teacher t) {
        // will call a teacher's method to respond
        try {
            Scanner sc = new Scanner(System.in);
            Boolean valid = false;
            if (grade <= 65) {
                System.out.println("You have failed the class");
                System.out.println("Game over");
                System.exit(0);
            } else if (mentalSanity <= 0) {
                System.out.println("You have gone insane");
                System.out.println("Game over");
                System.exit(0);
            }
            while (!valid) {
                // giveing choices
                System.out.println("What would you like to do?");
                System.out.println("1 => Study");
                System.out.println("2 => Sleep Early");
                System.out.println("3 => Ignore");
                int choice = sc.nextInt();
                if (choice == 1) {
                    valid = !valid;
                    return this.study() + "\n" + t.respond(this);
                } else if (choice == 2) {
                    valid = !valid;
                    return this.sleepEarly() + "\n" + t.respond(this);
                } else if (choice == 3) {
                    valid = !valid;
                    return this.ignore() + "\n" + t.respond(this);
                }
                t.respond(this);
                sc.close();
            }
            return this.stats();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

    public String study() {
        grade += 3;
        mentalSanity -= level;
        System.out.printf("You have studied! your grade is now %d and your mental sanity is now %d \n", grade, level);
        return "\n Student chose to study";
    }

    public String sleepEarly() {
        mentalSanity += 3;
        grade -= level;
        System.out.printf("You have slept early! your grade is now %d and your mental sanity is now %d \n", grade,
                level);
        return "\n Student chose to sleep early";

    }

    public String ignore() {
        grade -= 5;
        System.out.printf("You have studied! your grade is now %d and your mental sanity is still %d \n", grade, level);
        return "\n Student chose to ignore";
    }

}
