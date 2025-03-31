import java.io.Serializable;

public class Book implements Serializable{
    private int id;
    private String name;
    private String author;
    private String publisher;
    private double price;

    public Book(int id, String name, String author, String publisher, double price){
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    public Book(){
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getPublisher(){
        return publisher;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    @Override
    public String toString(){
        return "ID: " + this.name + "\nName: " + this.name + "\nAuthor: " + this.author + "\nPublisher: " + this.publisher;
    }
}
