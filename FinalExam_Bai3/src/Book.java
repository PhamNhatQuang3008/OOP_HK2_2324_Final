// src/Book.java
public class Book {
    private String title;
    private String author;
    private String genre;
    private int pages;
    private double price;
    private String publisher;

    // Getters for the required fields
    public double getPrice() {
        return price;
    }

    public int getPages() {
        return pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }
    public static class BookBuilder {
        private String title;
        private String author;
        private String genre;
        private int pages;
        private double price;
        private String publisher;


        public BookBuilder(String title) {
            this.title = title;
        }

        public BookBuilder withAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder withGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public BookBuilder withPages(int pages) {
            this.pages = pages;
            return this;
        }

        public BookBuilder withPrice(double price) {
            this.price = price;
            return this;
        }

        public BookBuilder withPublisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Book build() {
            Book book = new Book();
            book.title = this.title;
            book.author = this.author;
            book.genre = this.genre;
            book.pages = this.pages;
            book.price = this.price;
            book.publisher = this.publisher;
            return book;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}