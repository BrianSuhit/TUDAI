public class Plato {
    
    private String color;

    public Plato(String color){
        setColor(color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString(){
        return "plato con el color: " + this.getColor();
    }
}
