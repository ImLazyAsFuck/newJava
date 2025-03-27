import java.time.LocalDate;
import java.util.Optional;

public class Order{
    private int id;
    private String name;
    private LocalDate createdDate;
    private Optional<LocalDate> deliveryDate;

    public Order(int id, String name, LocalDate createdDate, LocalDate deliveryDate){
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
        this.deliveryDate = Optional.ofNullable(deliveryDate);
    }

    public Order(){
    }

    public LocalDate getCreatedDate(){
        return createdDate;
    }

    public Optional<LocalDate> getDeliveryDate(){
        return deliveryDate;
    }

    public String toDisplayString() {
        return "ID: " + id + " | Tên KH: " + name + " | Ngày đặt: " + createdDate +
                " | Ngày giao: " + deliveryDate.map(LocalDate::toString).orElse("Chưa giao");
    }
}
