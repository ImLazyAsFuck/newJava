public class Circle implements Shape{
    double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public float area(){
        return (float)(Math.pow(this.radius, 2) * Math.PI);
    }
}
