package POO.library;

public class StudentMember  extends Member{
    public StudentMember(String name){
        super(name);
    }

    @Override
    public int maxBooksAllowed(){
        return 3;
    }
}
