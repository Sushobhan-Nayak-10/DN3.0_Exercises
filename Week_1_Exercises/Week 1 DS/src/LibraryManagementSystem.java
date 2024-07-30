import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Book class
class Book implements Comparable<Book> {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + "]";
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareToIgnoreCase(other.title);
    }
}

// Library class with search methods
class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Linear search to find books by title
    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary search to find books by title (assuming the list is sorted)
    public Book binarySearchByTitle(String title) {
        Collections.sort(books);
        int left = 0, right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);
            int cmp = midBook.title.compareToIgnoreCase(title);

            if (cmp == 0) {
                return midBook;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books to the library
        library.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book(3, "1984", "George Orwell"));
        library.addBook(new Book(4, "Pride and Prejudice", "Jane Austen"));
        library.addBook(new Book(5, "The Catcher in the Rye", "J.D. Salinger"));

        // Perform linear search
        System.out.println("Linear Search:");
        Book foundBook = library.linearSearchByTitle("1984");
        System.out.println(foundBook != null ? "Book found: " + foundBook : "Book not found.");

        // Perform binary search
        System.out.println("\nBinary Search:");
        foundBook = library.binarySearchByTitle("1984");
        System.out.println(foundBook != null ? "Book found: " + foundBook : "Book not found.");
    }
}
