public class AP extends Member{
    private String department;
    private int HP;
    private String name;

    public AP(String name, int HP, String department){
        super(name);
        this.department = department;
    }

    public String giveDepartmentFinal(Student s){
        s.changeGrade(- 4 * s.getLevel());
        HP--;
        return "Your Hp is" + HP;
    }

    public String failStudent(Student s){

    }

}

    // public String responds(Student s){
    //             // will get call a students's response method to continiously respond
    //     int choice = (int) (Math.random() * 3);
    //     if (HP == 0) {
    //         System.out.println("School Year is over!");
    //         System.out.println("You have Survived");
    //         return s.stats();
    //     }
    //     if (choice == 0) {
    //         return this.giveDepartmentFinal(s);
    //     } else if (choice == 1) {
    //         return this.failStudent(s);
    //     } else {
    //         return this.giveHomework(s);
    //     }
    // }

    // }
