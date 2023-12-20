abstract class Member implements StuyInterface {
    private String name;
    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getStats() {
        return String.format("Name: %s", name);
    }

}
