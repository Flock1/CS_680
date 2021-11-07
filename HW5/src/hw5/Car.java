package hw5;

public class Car {
    
    private String make, model; 
    private int mileage, year; 
    private float price; 

    public Car(
        String Make, 
        String Model, 
        int Mileage, 
        int Year, 
        float Price
    ){
        this.make = Make; 
        this.model = Model; 
        this.mileage = Mileage; 
        this.year = Year; 
        this.price = Price;
    }

    public String getMake(){
        return this.make; 

    }

    public String getModel(){
        return this.model; 
    }

    public int getMileage(){
        return this.mileage; 
    }
    public int getYear(){
        return this.year; 
    }
    public float getPrice(){
        return this.price; 
    }
}