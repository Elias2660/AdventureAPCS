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
        String f = String.format("Student \u001B[35m%s\u001B[0m has \u001B[45mstudied\u001B[0m!\n%s", this.getName(), this.stats());
        return f;
    }

    public String sleepEarly() {
        mentalSanity += 3;
        grade -= level;
        return String.format("Student %s slept early! their grade is now %d and their mental sanity is now %d \n",
                this.getName(), grade,
                mentalSanity);

    }

    public String ignore() {
        grade -= 5;
        mentalSanity++;
        String f = String.format("Student \u001B[35m%s\u001B[0m has decided to \u001B[45mignore\u001B[0m!\n%s", this.getName(), this.stats());
        return f;
    }

    @Override
    public String stats() {
        return String.format("Student %s has a grade of %d and a mental sanity of %d\n", this.getName(), grade,
                mentalSanity);
    }



    public String refresh() {
        grade = 95 + 2 * level;
        mentalSanity = 50 + level;
        level++;
        String f = String.format("Student \u001B[35m%s\u001B[0m has \\u001B[45mrefreshed\\u001B[0m!\n%s", this.getName(), this.stats());
        return f;
    }
}
