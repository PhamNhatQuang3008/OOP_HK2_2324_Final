// src/BookManager.java
public class BookManager {
    private static BookManager instance;
    private MyList bookList;

    private BookManager() {
        this.bookList = new MyLinkedList();
    }

    public static BookManager getInstance() {
        if (instance == null) {
            instance = new BookManager();
        }
        return instance;
    }

    public MyList getBookList() {
        return bookList;
    }

    public void insertAtStart(Book book) {
        bookList.insertAtStart(book);
    }

    public void insertAtEnd(Book book) {
        bookList.insertAtEnd(book);
    }

    public void insertAPosition(Book book, int index) {
        bookList.insertAtPosition(book, index);
    }

    public void remove(int index) {
        bookList.remove(index);
    }

    public Book bookAt(int index) {
        return (Book) bookList.getNodeByIndex(index).data;
    }

    public Book highestPriceBook() {
        if (bookList.size() == 0) return null;
        Book highest = (Book) bookList.getNodeByIndex(0).data;
        for (int i = 1; i < bookList.size(); i++) {
            Book current = (Book) bookList.getNodeByIndex(i).data;
            if (current.getPrice() > highest.getPrice()) {
                highest = current;
            }
        }
        return highest;
    }

    public Book lowestPriceBook() {
        if (bookList.size() == 0) return null;
        Book lowest = (Book) bookList.getNodeByIndex(0).data;
        for (int i = 1; i < bookList.size(); i++) {
            Book current = (Book) bookList.getNodeByIndex(i).data;
            if (current.getPrice() < lowest.getPrice()) {
                lowest = current;
            }
        }
        return lowest;
    }

    public Book highestNumberOfPagesBook() {
        if (bookList.size() == 0) return null;
        Book highest = (Book) bookList.getNodeByIndex(0).data;
        for (int i = 1; i < bookList.size(); i++) {
            Book current = (Book) bookList.getNodeByIndex(i).data;
            if (current.getPages() > highest.getPages()) {
                highest = current;
            }
        }
        return highest;
    }

    public Book lowestNumberOfPagesBook() {
        if (bookList.size() == 0) return null;
        Book lowest = (Book) bookList.getNodeByIndex(0).data;
        for (int i = 1; i < bookList.size(); i++) {
            Book current = (Book) bookList.getNodeByIndex(i).data;
            if (current.getPages() < lowest.getPages()) {
                lowest = current;
            }
        }
        return lowest;
    }

    public MyList filterBooksOfPublisher(String publisher) {
        MyList filteredList = new MyLinkedList();
        for (int i = 0; i < bookList.size(); i++) {
            Book current = (Book) bookList.getNodeByIndex(i).data;
            if (current.getPublisher().equals(publisher)) {
                filteredList.insertAtEnd(current);
            }
        }
        return filteredList;
    }

    public MyList filterBooksOfGenre(String genre) {
        MyList filteredList = new MyLinkedList();
        for (int i = 0; i < bookList.size(); i++) {
            Book current = (Book) bookList.getNodeByIndex(i).data;
            if (current.getGenre().equals(genre)) {
                filteredList.insertAtEnd(current);
            }
        }
        return filteredList;
    }

    public MyList filterBooksOfAuthor(String author) {
        MyList filteredList = new MyLinkedList();
        for (int i = 0; i < bookList.size(); i++) {
            Book current = (Book) bookList.getNodeByIndex(i).data;
            if (current.getAuthor().equals(author)) {
                filteredList.insertAtEnd(current);
            }
        }
        return filteredList;
    }
}