package ru.geekbrains.lesson4.task3;

public class CardInfo {
    public CardInfo(double amount, String cardNumber) {
        this.amount = amount;
        this.cardNumber = cardNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    private double amount;
    private String cardNumber;
}
