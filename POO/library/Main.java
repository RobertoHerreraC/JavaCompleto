package POO.library;

public class Main {
    static void main() {
        Book book1 = new Book("Clean code", "Robert Martin");

        Member student = new StudentMember("Roberto");
        Member teacher = new TeacherMember("Samuel");

        LibraryService library = new LibraryService();

        library.borrowBook(book1, student);
    }
}
