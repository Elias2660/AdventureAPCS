import java.util.Scanner;

public class Student extends Member {
    // students will have a name and a grade level
    private int level = 9;
    private int grade = 95;
    private int mentalSanity = 50;

    public Student(String name) {
        super(name);
    }
    //getters
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

    public String refresh() {
        grade = 95 + 2*level;
        mentalSanity = 50 + level;
        level++;
        return String.format("Student %s has refreshed! their grade is now %d and their mental sanity is now %d \n",
                this.getName(), grade, level);
    }
}
