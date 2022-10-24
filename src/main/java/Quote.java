import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class Quote {
    private int id;
    private String author;
    private String quote;
    protected boolean favourite;
}
