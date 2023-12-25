package br.com.santandar.classes;

import br.com.santandar.exception.BusinessException;

public class Account {
    private int number;
    private String holder;
    private float balance;
    private float withdrawLimit;

    public Account(int number, String holder, float balance, float withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public String toString() {
        return "Account{" +
                "number=" + number +
                ", holder='" + holder + '\'' +
                ", balance=" + balance +
                ", withdrawLimit=" + withdrawLimit +
                '}';
    }

    public void changeBalance(float amount){
        this.balance += amount;

    }

    public void deposit(float amount){
        changeBalance(amount);
    }

    public void withdraw(float amount){
        validateWithdraw(amount);
        changeBalance(-amount);
    }

    private void validateWithdraw(float amount){
        if (amount > this.withdrawLimit){
            throw new BusinessException("Erro de saque: A quantia excede o limite de saque");
        }
        else if (amount > this.balance){
            throw new BusinessException("Erro de saque: Saldo insuficiente");
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(float withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }
}
