package POO.library;

public abstract class Member {
    private final String name;
    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int maxBooksAllowed();
}
