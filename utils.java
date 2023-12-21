import java.util.Scanner;

public class utils {

    public static String respondS(Student s, Teacher t, Scanner input, int number) {
        // will call a teacher's method to respond
        try {
            Boolean valid = false;
            if (s.getGrade() <= 65) {
                return s.getName() + " has failed \n Game over";
            } else if (s.getMentalSanity() <= 0) {
                return s.getName() + "have gone insane \n Game over";
            }
            // for scoping
            String response = "ERROR";
            while (!valid) {
                // giveing choices
                utils.givePrompt(number, s, t);
                utils.printOptions();
                int choice = input.nextInt();
                System.out.println();
                if (choice == 1) {
                    valid = !valid;
                    System.out.println(s.study());
                } else if (choice == 2) {
                    valid = !valid;
                    System.out.println(s.sleepEarly());

                } else if (choice == 3) {
                    System.out.println(s.ignore());
                    valid = !valid;
                }
            }
            System.out.print(respondT(s, t, input, number + 1));
            return response;
            // we have to implement stats somehow but I don't know how
            // return this.stats();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String respondT(Student s, Teacher t, Scanner input, int number) {

        // will get call a students's response method to continiously respond
        int choice = (int) (Math.random() * t.getOption()) + 1;
        String response;
        if (t.getHP() == 0) {
            return "School Year is over! \n" + "You have Survived";
            // return s.stats();
        }
        // next step would be to make sure to implement this correctly
        if (choice == 0) {
            response = t.giveTest(s);
        } else if (choice == 1) {
            response = t.giveEC(s);
        } else {
            response = t.giveHomework(s);
        }
        System.out.println(response);
        System.out.println(respondS(s, t, input, number));
        return "";
    }

    public static void printOptions() {
        // green
        System.out.print("\u001b[32m");
        System.out.println("1 to Study");

        // cyan
        System.out.print("\u001b[36m");
        System.out.println("2 to Sleep Early");

        // purple
        System.out.print("\u001b[35m");
        System.out.println("3 to Ignore");

        // reset
        System.out.print("\u001b[0m");
    }

    public static void givePrompt(int number, Student s, Teacher t) {
        if (number == 0) {
            System.out.printf("Student %s had encountered %s \n", s.getName(), t.getName());
        } else {
            System.out.printf("Student %s is still in class with %s, with HP %d! \n", s.getName(),
                    t.getName(), t.getHP());
        }
    }
}
