public class CarBuilder{
    private String engine;
    private int seats;
    private String color;
    public CarBuilder setEngine(String engine){
        this.engine = engine;
        return this;
    }

    public CarBuilder setSeats(int seats){
        this.seats = seats;
        return this;
    }

    public CarBuilder setColor(String color){
        this.color = color;
        return this;
    }
    public Car build(){
        Car car = new Car();
        car.setEngine(this.engine);
        car.setSeats(this.seats);
        car.setColor(this.color);
        return car;
    }
}