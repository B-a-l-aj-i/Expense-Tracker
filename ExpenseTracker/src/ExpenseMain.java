import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ExpenseMain {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
//
        ExpenseList el=new ExpenseList();


        try{
            el.add();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        boolean is_exit=false;

        while (!is_exit){
            System.out.println("***************************");
            System.out.println("1.add Expense");
            System.out.println("2.remove expense");
            System.out.println("3.view Expense");
            System.out.println("4.Generate Report");
            System.out.println("5.exit");
            System.out.println("***************************");


            int choice= sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    el.addExpense();
                    System.out.println("-------Expense added--------");
                    break;
                case 2:
                    el.removeExpense();
//                    System.out.println("Expense removed");
                    break;
                case 3:
                    el.viewExpense();
                    System.out.println("-----------------Expenses list------------------");
                    break;
                case 4:
                    el.generateReport();
                    System.out.println("-------Report generated--------");
                    break;
                case 5:
                    is_exit=true;
                    System.out.println("exit");
                    break;
                default:
                    System.out.println("--------enter valid choice-------");
            }
        }

    }
}