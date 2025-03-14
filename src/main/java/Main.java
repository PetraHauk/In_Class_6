import Dao.LibraryDao;
import Entities.*;
import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InClass6");
        EntityManager em = emf.createEntityManager();
        LibraryDao libraryDao = new LibraryDao(em);

        try {
            Author author = new Author("Suzanne Collins");
            Author author2 = new Author("Arthur Conan Doyle");
            libraryDao.addAuthor(author);
            libraryDao.addAuthor(author2);

            EBook book = new EBook("The Hunger Games", author, 1.1, "PDF");
            libraryDao.addBook(book);

            PrintedBook book2 = new PrintedBook("Sherlock Holmes", author2, 5.2, 200);
            libraryDao.addBook(book2);

            Student student = new Student("John Doe");
            libraryDao.addStudent(student);

            Biography biography = new Biography(author, "Suzanne Collins is an American television" +
                    " writer and author. She is known as the author of The New York Times best-selling series The " +
                    "Underland Chronicles and The Hunger Games trilogy.");
            libraryDao.addBiography(biography);

            libraryDao.borrowBook(student, book);

            System.out.println("Author, Book, Biography, Student added and Book borrowed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
