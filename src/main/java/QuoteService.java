import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

@Getter
@AllArgsConstructor

public class QuoteService {
    private List<Quote> quotes;

    public List<String> getAllQuotes() {
        List<String> result = new ArrayList<>();
        if (quotes != null) {
            for (Quote quote : quotes) {
                result.add(quote.getQuote());
            }
        }
        return result;
    }

    public List<Quote> getQuotesForAuthor(String author) {
        List<Quote> result = new ArrayList<>();
        if (quotes != null && author != null) {
            for (Quote quote : quotes) {
                if (quote.getAuthor().equals(author)) {
                    result.add(new Quote(quote.getId(), quote.getAuthor(), quote.getQuote(), quote.isFavourite()));
                }
            }
        }
        return result;
    }

    public List<String> getAuthors() {
        List<String> result = new ArrayList<>();
        if (quotes != null) {
            for (Quote quote : quotes) {
                if (result.indexOf(quote.getAuthor()) < 0)
                    result.add(quote.getAuthor());
            }
        }
        return result;
    }

    public void setFavourite(int id) {
        if (quotes != null && !quotes.get(id - 1).isFavourite()) {
            quotes.get(id - 1).favourite = true;
        }
    }

    public List<Quote> getFavourites() {
        List<Quote> result = new ArrayList<>();
        if (quotes != null) {
            for (Quote quote : quotes) {
                if (quote.isFavourite()) {
                    result.add(new Quote(quote.getId(), quote.getAuthor(), quote.getQuote(), quote.isFavourite()));
                }
            }
        }
        return result;
    }

    public String getRandomQuote() {
        if (quotes == null) {
            return null;
        }
        Random random = new Random();
        int random1 = random.nextInt(quotes.size() - 1);
        return quotes.get(random1).getQuote();
    }
}
