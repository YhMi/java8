package top.yhmi;

public class ComplexApple {
    private String name;
    private long weight;
    private String color;

    public ComplexApple(String name, long weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ComplexApple{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
