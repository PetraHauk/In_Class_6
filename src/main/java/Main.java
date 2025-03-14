import Dao.LibraryDao;
import Entities.Author;
import Entities.Book;
import Entities.EBook;
import Entities.Student;
import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InClass6");
        EntityManager em = emf.createEntityManager();
        LibraryDao libraryDao = new LibraryDao(em);

        try {
            Author author = new Author("Suzanne Collins");
            libraryDao.addAuthor(author);

            EBook book = new EBook("The Hunger Games", author, 1000, "PDF");
            libraryDao.addBook(book);

            Student student = new Student("John Doe");
            libraryDao.addStudent(student);

            libraryDao.borrowBook(student, book);

            System.out.println("Author, Book, Student added and Book borrowed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
