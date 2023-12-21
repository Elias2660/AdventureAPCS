import java.util.Scanner;

public class Student extends Member {
    // students will have a name and a grade level
    private int level = 9;
    private int grade = 95;
    private int mentalSanity = 50;

    public Student(String name) {
        super(name);
    }

    // GETTERS

    public int getLevel() {
        return level;
    }

    public int getMentalSanity() {
        return mentalSanity;
    }

    public int getGrade() {
        return grade;
    }

    // SETTERS
    public void changeSanity(int change) {
        mentalSanity += change;
    }

    public void changeGrade(int change) {
        grade += change;
    }
    // METHODS

    // there should be an encounter item! we need to implementent that
    public String encounter(Teacher T) {
        try {
            try (Scanner Input = new Scanner(System.in)) {
                boolean valid = false;
                while (!valid) {
                    System.out.printf("Student %s had encountered %s \n", this.getName(), T.getName());
                    System.out.println("What should they do?");
                    System.out.println("1 to Study");
                    System.out.println("2 to Sleep Early");
                    System.out.println("3 to Ignore");
                    int choice = Input.nextInt();
                    switch (choice) {
                        case 1:
                            valid = !valid;
                            System.out.println(this.study());
                            break;
                        case 2:
                            valid = !valid;
                            System.out.println(this.sleepEarly());
                            break;
                        case 3:
                            valid = !valid;
                            System.out.println(this.ignore());
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                }
                String reaction = T.respond(this);
                return reaction;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

    public String respond(Teacher t) {
        // will call a teacher's method to respond
        try {
            try (Scanner sc = new Scanner(System.in)) {
                Boolean valid = false;
                if (grade <= 65) {
                    return this.getName() + " has failed \n Game over";
                } else if (mentalSanity <= 0) {
                    return this.getName() + "have gone insane \n Game over";
                }
                // for scoping
                String change = "ERROR";
                String response = "ERROR";
                while (!valid) {
                    // giveing choices
                    System.out.printf("Student %s is still in class with %s, with HP %d! \n", this.getName(),
                            t.getName(), t.getHP());
                    System.out.println("What should they do?");
                    System.out.println("1 => Study");
                    System.out.println("2 => Sleep Early");
                    System.out.println("3 => Ignore");

                    int choice = sc.nextInt();
                    sc.nextLine();
                    System.out.println();
                    if (choice == 1) {
                        valid = !valid;
                        System.out.println(this.study());
                        response = t.respond(this);


                    } else if (choice == 2) {
                        valid = !valid;
                        System.out.println(this.sleepEarly());
                        response = t.respond(this);

                    } else if (choice == 3) {
                        System.out.println(this.ignore());
                        response = t.respond(this);

                        valid = !valid;
                    }

                }
                System.out.print(response);
                return response;
                // we have to implement stats somehow but I don't know how
                // return this.stats();
            }
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
