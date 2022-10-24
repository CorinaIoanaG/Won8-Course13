import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        QuoteService quoteService = new QuoteService(readQuotesFromFile());
        Scanner scanner = new Scanner(System.in);
        List<Quote> quotes;
        System.out.println(quoteService.getAllQuotes().get(3));
        System.out.println("Enter the author");
        String author = scanner.nextLine();
        quotes = quoteService.getQuotesForAuthor(author);
        for (Quote quote : quotes) {
            System.out.println(quote.getId() + " " + quote.getQuote());
        }
        System.out.println("Authors: " + quoteService.getAuthors());
        quoteService.setFavourite(33);
        quoteService.setFavourite(170);
        quoteService.setFavourite(5300);
        quotes = quoteService.getFavourites();
        System.out.println("Favourites quotes: ");
        for (Quote quote : quotes) {
            System.out.println(quote.getQuote());
        }
        System.out.println("Random quote: " + quoteService.getRandomQuote());
    }

    private static List<Quote> readQuotesFromFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/File/quotes.txt"));
        String line;
        int id = 0;
        List<Quote> quotes = new ArrayList<>();
        String[] quote;
        while ((line = bufferedReader.readLine()) != null) {
            quote = splitLine(line);
            quotes.add(new Quote(++id, quote[0], quote[1], false));

        }
        return quotes;
    }

    private static String[] splitLine(String line) {
        String[] result = line.split("~");
        return result;
    }

}