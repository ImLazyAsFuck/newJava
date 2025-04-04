public class Car{
    private String engine;
    private int seats;
    private String color;

    public String getEngine(){
        return engine;
    }

    public void setEngine(String engine){
        this.engine = engine;
    }

    public int getSeats(){
        return seats;
    }

    public void setSeats(int seats){
        this.seats = seats;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    @Override
    public String toString(){
        return "Car{" +
                "engine='" + engine + '\'' +
                ", seats=" + seats +
                ", color='" + color + '\'' +
                '}';
    }
}
