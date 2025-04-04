public class Main{
    public static void main(String[] args){
        Car car1 = new CarBuilder()
                .setEngine("V6 Turbo")
                .setSeats(2)
                .setColor("Red")
                .build();

        Car car2 = new CarBuilder()
                .setEngine("Electric")
                .setSeats(5)
                .setColor("Blue")
                .build();

        System.out.println(car1);
        System.out.println(car2);
    }
}