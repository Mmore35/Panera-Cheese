package paneracheese;

import java.util.Scanner;

public class PaneraCheese {

    public static void main(String[] args) {

        OrderedList Mylist = new OrderedList();

        Scanner in = new Scanner(System.in);
        while (true) {//while loop will repeat program forever.

            System.out.printf("What? \n\t1 -Take an order\n\t2 -Serve an order\n\t3 -Kill order\n\t4 -List orders\n");
            int res = in.nextInt();

            switch (res) {//catches all responces from user.
                case 1:
                    Mylist.PlaceOrder();
                    break;
                case 2:
                    Mylist.ServeOrder();
                    break;
                case 3:
                    Mylist.CancelOrder();
                    break;
                case 4:
                    Mylist.GiveInfo();
                    break;
                default:
                    System.out.println("No");
            }
        }

    }

}
