package paneracheese;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class OrderedList {
    private int i=0;
    private int j=0;
    private Queue<Order> MyQ = new LinkedList<>();

    public void PlaceOrder() {//Used to create orders
        Scanner in = new Scanner(System.in).useDelimiter("\\n");
        System.out.printf("What could you possibly want?\n");
        String Food = in.next();

        System.out.println("What do you call youself?");
        String Call = in.next();

        MyQ.add(new Order(Food, Call));
    }

    public void GiveInfo() {//will print info of all orders
        if (MyQ.isEmpty()) {
            System.out.println("Why did you try to get info, god you are stupid. There is nothing.");
        } else {
            System.out.printf("%-15s%-15s%-15s\n", "Name", "Order", "Time");
        }
        System.out.println("---------------------------------------------");
        MyQ.forEach((r) -> {
            System.out.println(r.toString());
        });
    }

    public void ServeOrder() {//will kill oldest order and print resalts

        if (MyQ.isEmpty()) {
            System.out.println("You Buffoon");
        } else {
            System.out.println("Now Serving " + MyQ.poll().GetName());
            System.out.printf("%-15s%-15s%-15s\n", "Name", "Order", "Time");
            System.out.println("---------------------------------------------");
            MyQ.forEach((r) -> {
                System.out.println(r.toString());
            });
        }
    }

    public void CancelOrder() {//asks a name and looks for the order to kill.
        Scanner in = new Scanner(System.in);
        System.out.println("Tell name of person");
        String nam = in.nextLine();
        i = 0;//used to compare
        j = 0;
        MyQ.forEach((r) -> {
            if (r.GetName().equalsIgnoreCase(nam)) {
                i++;
            }
        });//tests if multiple people of the same name.
        if (i >= 2) {
            System.out.println("There are multiple orders with that name. What food did this one have: ");
            String foo = in.nextLine();
            MyQ.removeIf((Order r) -> r.GetName().equalsIgnoreCase(nam) && r.GetFood().equalsIgnoreCase(foo));
            System.out.println(nam + "'s order has been killed!");
            j = 1;
        }//kills order based on food
        int UHOH = MyQ.size();
        if (j == 0) {
            MyQ.removeIf((Order r) -> r.GetName().equalsIgnoreCase(nam));
        int STINKY = MyQ.size();
        if (STINKY == UHOH - 1) {
            System.out.println(nam + "'s order has been killed!");
        } else if (UHOH == STINKY) {
            System.out.println("No one named that, Imbecile");
        }
        }//skips if the first part didnt pass.
    }

}
