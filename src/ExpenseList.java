import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
public class ExpenseList {
    Scanner sc = new Scanner(System.in);

    ArrayList<ExpenseObj> arrayList = new ArrayList<>();


    public void add() throws Exception {
        String dateStr = "01";
        Date date = new SimpleDateFormat("dd-MM-yy").parse(dateStr + "-01-" + "2024");
        arrayList.add(new ExpenseObj("Groceries", "Household", 9000f, date)); // ₹9000
        arrayList.add(new ExpenseObj("Utilities", "Bills", 5000f, date));    // ₹5000
        arrayList.add(new ExpenseObj("Rent/Mortgage", "Housing", 25000f, date)); // ₹25000
        arrayList.add(new ExpenseObj("Transportation", "Travel", 7000f, date));  // ₹7000
        arrayList.add(new ExpenseObj("Entertainment", "Leisure", 4000f, date));  // ₹4000
        arrayList.add(new ExpenseObj("Education", "School", 15000f, date));      // ₹15000
        arrayList.add(new ExpenseObj("Healthcare", "Medical", 3000f, date));     // ₹3000
        arrayList.add(new ExpenseObj("Savings", "Investment", 10000f, date));    // ₹10000
        arrayList.add(new ExpenseObj("Miscellaneous", "Other", 2500f, date));
    }


    public void addExpense() {
//        System.out.print("enter month (MM) : ");
//        String month= "-"+sc.nextLine()+"-";
        System.out.print("description : ");
        String desc = sc.nextLine();
        System.out.print("price : ");
        float price = sc.nextFloat();
        sc.nextLine();
        System.out.print("category : ");
        String category = sc.nextLine();
        System.out.print("date(dd) : ");
        String dateStr = sc.next();
        sc.nextLine();

        try {
            Date date = new SimpleDateFormat("dd-MM-yy").parse(dateStr + "-01-" + "2024");
            arrayList.add(new ExpenseObj(desc, category, price, date));
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            System.out.println("enter date in correct format");
        }

    }

    public void removeExpense() {

        System.out.print("enter description to remove (String) : ");
        String desc = sc.next();
        boolean isfound = false;
        for (ExpenseObj el : arrayList) {
            if (el.desc.equalsIgnoreCase(desc)) {
                isfound = true;
            }
        }
        if (isfound) {

            arrayList.removeIf(d -> d.desc.equalsIgnoreCase(desc));
            System.out.println("removed : " + desc);
        } else {
            System.out.println(desc + " not found");
        }


    }

//    public void generateReport() {
//        ReportList reportList = new ReportList(arrayList);
//
//        HashMap<String, Float> map = reportList.getReportList();
//
//        System.out.println("---Available categories---");
//        int i = 1;
//        for (String x : map.keySet()) {
//            System.out.println(i + ". " + x);
//            i++;
//        }
//        System.out.println(i + ". All");
//
//        System.out.print("Enter Category (String): ");
//        String category = sc.nextLine();
//
//        if (category.equalsIgnoreCase("All")) {
//
//            float total = 0;
//
//            for (String x : map.keySet()) {
//                System.out.println(x + " : " + map.get(x));
//                total += map.get(x);
//            }
//
//            System.out.println("----------------");
//            System.out.println("Total : " + total);
//            System.out.println("----------------");
//        } else {
//            System.out.println("--------------");
//            System.out.println(category + " : " + map.get(category));
//            System.out.println("---------------");
//
//        }
//
//
//    }

    public void generateReport() {
        ReportList reportList = new ReportList(arrayList);
        HashMap<String, Float> map = reportList.getReportList();

        // Display available categories
        System.out.println("---Available categories---");
        int i = 1;
        for (String x : map.keySet()) {
            System.out.println(i + ". " + x);
            i++;
        }
        System.out.println(i + ". All");

        System.out.print("Enter Category (String): ");
        String category = sc.nextLine();

        if (category.equalsIgnoreCase("All")) {
            // File where the report will be stored
            String fileName = "c:/java/report.txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
//                writer.write("---Available categories---\n");
                System.out.println("---Available categories---");

                float total = 0;

                for (String x : map.keySet()) {
                    writer.write(x + ":" + map.get(x) + "\n");
                    System.out.println(x + " : " + map.get(x));
                    total += map.get(x);
                }

//                writer.write("----------------\n");
//                writer.write("Total:" + total + "\n");
//                writer.write("----------------\n");

                System.out.println("----------------");
                System.out.println("Total : " + total);
                System.out.println("----------------");

//                System.out.println("Report saved to " + fileName);

            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }

        } else {
            System.out.println("--------------");
            System.out.println(category + " : " + map.get(category));
            System.out.println("---------------");
        }
    }



    public void viewExpense() {
        for (ExpenseObj d : arrayList) {
            System.out.println("description:" + d.desc + "," + " category:" + d.category + "," + " price:" + d.price + "," + " date:" + d.date.toString().substring(0, 10
            ));
        }
    }
}
