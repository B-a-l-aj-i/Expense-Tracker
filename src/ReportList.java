import java.util.ArrayList;
import java.util.HashMap;

public class ReportList {
    ArrayList<ExpenseObj> reportList;


    HashMap<String,Float> finalMap=new HashMap<>();

    ReportList(ArrayList<ExpenseObj> arrayList){
        this.reportList=arrayList;
    }

    public HashMap<String, Float> getReportList() {
        for (ExpenseObj el:reportList){
            finalMap.merge(el.category, el.price, Float::sum);
        }
        return finalMap;
    }



}
