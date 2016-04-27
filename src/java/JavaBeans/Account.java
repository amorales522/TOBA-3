
package JavaBeans;


 
public class Account {
    public enum Type {
    Checking, Savings
}
    private int id;
    private Type type;
    private double balance;
    User user;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account(double balance, User user) {
        this.balance = balance;
        this.user = user;
    }
    
    public void credit(double balance){
        this.balance +=balance;
    }
public void debit(double balance){
        
        this.balance -=balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account() {
        this.user = new User();
    }

    public Account(int id, Type type, double balance, User user) {
        this.id = id;
        this.type = type;
        this.balance = balance;
        this.user = user;
    }
    
     
}
