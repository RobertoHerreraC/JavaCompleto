package POO.library;

public class TeacherMember extends Member{
    public TeacherMember(String name){
        super(name);
    }

    @Override
    public int maxBooksAllowed(){
        return 5;
    }
}
