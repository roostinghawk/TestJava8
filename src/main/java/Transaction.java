import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {

    private Currency currency;

    private double amount;
}
