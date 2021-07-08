package top.sakuraffy.solution.entity;

public class TransactionEntity {
    private String name;
    private int time;
    private int amount;
    private String city;

    public TransactionEntity(String name, int time, int amount, String city) {
        this.name = name;
        this.time = time;
        this.amount = amount;
        this.city = city;
    }

    @Override
    public String toString() {
        return name + "," + time + "," + amount + "," + city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
