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

    public String respond(Teacher t) {
        // will call a teacher's method to respond
        try {
            Scanner sc = new Scanner(System.in);
            Boolean valid = false;
            if (grade <= 65) {
                sc.close();
                return this.getName() + " has failed \n Game over";
            } else if (mentalSanity <= 0) {
                sc.close();
                return this.getName() + "have gone insane \n Game over";
            }
            //for scoping
            String change = "ERROR";
            String response = "ERROR";
            while (!valid) {
                // giveing choices
                System.out.printf("Student %s is in a class with %s! \n", this.getName(), t.getName());
                System.out.println("What should they do?");
                System.out.println("1 => Study");
                System.out.println("2 => Sleep Early");
                System.out.println("3 => Ignore");

                int choice = sc.nextInt();
                sc.close();
                System.out.println();
                if (choice == 1) {
                    valid = !valid;
                    change = this.study();

                } else if (choice == 2) {
                    valid = !valid;
                    change = this.sleepEarly();
                } else if (choice == 3) {
                    change = this.ignore();
                    valid = !valid;
                }
                response = t.respond(this);

            }
            return change + response;
            // we have to implement stats somehow but I don't know how
            // return this.stats();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

    public String study() {
        grade += 3;
        mentalSanity -= level;
        return String.format("Student %s have studied! their grade is now %d and their mental sanity is now %d \n",
                this.getName(), grade, level);
    }

    public String sleepEarly() {
        mentalSanity += 3;
        grade -= level;
        return String.format("Student %s slept early! their grade is now %d and their mental sanity is now %d \n",
                this.getName(), grade,
                level);

    }

    public String ignore() {
        grade -= 5;

        return String.format(
                "Student %s decided to ignore everything! their grade is now %d and their mental sanity is still %d \n",
                this.getName(), grade, level);
    }

    @Override
    public String stats() {
        return String.format("Student Name: %s \n Level: %d \n Grade: %d \n Mental Sanity: %d \n", this.getName(),
                level, grade,
                mentalSanity);
    }

}
