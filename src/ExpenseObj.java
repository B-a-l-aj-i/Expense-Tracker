import java.time.LocalDate;
import java.util.Date;

public class ExpenseObj {
    String desc;
    String category;
    float price;
    Date date;
    LocalDate localDate;

    public ExpenseObj(String desc, String category, float price, Date date) {
        this.desc = desc;
        this.category = category;
        this.price = price;
        this.date = date;
    }


}
