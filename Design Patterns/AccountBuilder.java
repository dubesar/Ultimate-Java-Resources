/*
    Builder pattern is a creational design pattern that lets you construct complex objects step by step.
    The pattern allows you to produce different types and representations of an object
    using the same construction code
    Objective: To get rid of complex Constructors

    link: https://refactoring.guru/design-patterns/builder
 */
public class AccountBuilder {

    private long accountNumber;
    private String owner;
    private double balance;
    private double interestRate;

    // Builder class
    public static class Builder{
        private final long accountNumber;
        private String owner;
        private double balance;
        private double interestRate;

        public Builder(long accountNumber){
            this.accountNumber = accountNumber;
        }

        // note: hasOwner - a verb is attached
        public Builder hasOwner(String owner){
            this.owner = owner;
            return this;
        }

        public Builder hasBalance(double balance){
            this.balance = balance;
            return this;
        }

        public Builder hasInterestRate(double interestRate){
            this.interestRate = interestRate;
            return this;
        }

        // the holy-grail method
        public AccountBuilder build(){
            AccountBuilder accountBuilder = new AccountBuilder();
            accountBuilder.accountNumber = this.accountNumber;
            accountBuilder.balance = this.balance;
            accountBuilder.interestRate = this.interestRate;
            accountBuilder.owner = this.owner;

            return accountBuilder;
        }
    }

    //Important: Make constructor private - to make builder class very important
    private AccountBuilder(){}

    // needed boiler-plate

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "AccountBuilder{" +
                "accountNumber=" + accountNumber +
                ", owner='" + owner + '\'' +
                ", balance=" + balance +
                ", interestRate=" + interestRate +
                '}';
    }

    // try this now;
    public static void main(String[] args) {
        AccountBuilder firstAccount = new AccountBuilder.Builder(548263L)
                .hasBalance(1000L)
                .hasOwner("John")
                .hasInterestRate(1.2)
                .build(); // now it's more verbose and more human readable

        AccountBuilder secondAccount = new AccountBuilder.Builder(2658745L)
                .hasOwner("Jane")
                .hasBalance(25000L)
                .build();

        System.out.println("First Account has values: " + firstAccount.toString());
        System.out.println("Second Account has values: " + secondAccount.toString());
    }
}
