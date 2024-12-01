// src/App.java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        init();

        testOriginalData();
        testFilterBooksOfAuthor();
        testFilterBooksOfPublisher();
        testFilterBooksOfGenre();
        testGetHighestPriceBook();
        testGetLowestPriceBook();
        testGetHighestNumberOfPagesBook();
        testGetLowestNumberOfPagesBook();
    }

    public static void init() {
        String filePath = "C:\\Users\\Windows\\Downloads\\books.csv";
        readListData(filePath);
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 6) {
                    continue;
                }

                if (dataList.get(0).equals("title")) {
                    continue;
                }

                String title = dataList.get(0);
                String author = dataList.get(1);
                String genre = dataList.get(2);
                int pages = Integer.parseInt(dataList.get(3));
                double price = Double.parseDouble(dataList.get(4));
                String publisher = dataList.get(5);

                Book newBook = new Book.BookBuilder(title)
                        .withAuthor(author)
                        .withGenre(genre)
                        .withPages(pages)
                        .withPrice(price)
                        .withPublisher(publisher)
                        .build();

                BookManager.getInstance().insertAtEnd(newBook);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (String data : splitData) {
                result.add(data);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void testOriginalData() {
        MyList bookList = BookManager.getInstance().getBookList();
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(bookList.getNodeByIndex(i).data);
        }
    }

    public static void testFilterBooksOfAuthor() {
        MyList filteredList = BookManager.getInstance().filterBooksOfAuthor("Author Name");
        for (int i = 0; i < filteredList.size(); i++) {
            System.out.println(filteredList.getNodeByIndex(i).data);
        }
    }

    public static void testFilterBooksOfPublisher() {
        MyList filteredList = BookManager.getInstance().filterBooksOfPublisher("Publisher Name");
        for (int i = 0; i < filteredList.size(); i++) {
            System.out.println(filteredList.getNodeByIndex(i).data);
        }
    }

    public static void testFilterBooksOfGenre() {
        MyList filteredList = BookManager.getInstance().filterBooksOfGenre("Genre Name");
        for (int i = 0; i < filteredList.size(); i++) {
            System.out.println(filteredList.getNodeByIndex(i).data);
        }
    }

    public static void testGetHighestPriceBook() {
        Book highestPriceBook = BookManager.getInstance().highestPriceBook();
        System.out.println(highestPriceBook);
    }

    public static void testGetLowestPriceBook() {
        Book lowestPriceBook = BookManager.getInstance().lowestPriceBook();
        System.out.println(lowestPriceBook);
    }

    public static void testGetHighestNumberOfPagesBook() {
        Book highestPagesBook = BookManager.getInstance().highestNumberOfPagesBook();
        System.out.println(highestPagesBook);
    }

    public static void testGetLowestNumberOfPagesBook() {
        Book lowestPagesBook = BookManager.getInstance().lowestNumberOfPagesBook();
        System.out.println(lowestPagesBook);
    }
}