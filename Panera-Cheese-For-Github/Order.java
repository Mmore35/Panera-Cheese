package paneracheese;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {//class will handle orders

    private String des;
    private String Customer;
    private LocalDateTime OrderTime;

    public Order(String des, String Name) {//basic con for Order class
        this.des = des;
        this.Customer = Name;
        this.OrderTime = LocalDateTime.now();
    }

    @Override
    public String toString() {//Override needed to properly format
        DateTimeFormatter DTF = DateTimeFormatter.ofPattern("HH:MM:SS");
        return String.format("%-15s%-15s%-15s", this.Customer, this.des, this.OrderTime.format(DTF));
    }

    public String GetName() {//to Get Name of order holder
        return Customer;
    }
    
    public String GetFood() {
        return des;
    }

}
