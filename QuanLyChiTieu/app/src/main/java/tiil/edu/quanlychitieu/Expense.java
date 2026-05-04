package tiil.edu.quanlychitieu;

public class Expense {

    private String id;
    private String name;
    private int money;

    public Expense() {
    }

    public Expense(String id,
                   String name,
                   int money) {

        this.id = id;
        this.name = name;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}