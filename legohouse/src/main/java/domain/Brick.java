package domain;
public enum Brick {
    Red(1,3.00), Blue(2,4.00), Yellow(4,6.00);
    private final int size;
    private final double price;
    Brick(int size, double price){
        this.size = size;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }
    public static void main(String[] args){
        Brick brick = Brick.Blue;
        System.out.println(brick + " costs: "+brick.getPrice());
    }
}