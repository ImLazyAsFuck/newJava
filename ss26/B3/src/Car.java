public class Car{
    private String engine;
    private int seats;
    private String color;

    public static class CarBuilder{
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
            car.engine = this.engine;
            car.seats = this.seats;
            car.color = this.color;
            return car;
        }
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
