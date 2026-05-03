package _1_POO.library;

public class TeacherMember extends Member{
    public TeacherMember(String name){
        super(name);
    }

    @Override
    public int maxBooksAllowed(){
        return 5;
    }
}
