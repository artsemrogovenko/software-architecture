package ru.geekbrains.lesson4.task3;


import java.util.ArrayList;

public class PaymentProvider {

    private ArrayList<CardInfo> cards = new ArrayList<>();

    {
        for (int i = 1000; i < 1050; i += 10) {
            cards.add(new CardInfo(0 + i, String.format("100000000000%d", i)));
        }
    }

    public boolean buyTicket(int orderId, String cardNo, double amount) {
        // Посылаем запрос на формирование заявки на проведение платежа в процессинговую компанию (ProcessingCompany)

        try {
            // Предусловие
            if (String.valueOf(cardNo).length() != 16) {
                throw new TicketException("Некорректный номер карточки.");
            }

            if (amount < 0) {
                throw new TicketException("Некорректная сумма.");
            }

            // Выполнение подпрограммы
            CardInfo cardInfo = null;
            for (CardInfo card : cards) {
                if (card.getCardNumber().equals(cardNo) ) {
                    cardInfo = card;
                }
            }
            // Инвариант #1 ..
            if (cardInfo == null) {
                throw new TicketException("Карты не существует.");
            }

            // Выполнение подпрограммы
            double balance = cardInfo.getAmount() - amount;

            // Инвариант #2 ..
            validateAmount(cardInfo, amount);

            // Постусловие
            cardInfo.setAmount(balance);

        } catch (PaymentException | TicketException ex) {
            System.out.println(ex.getMessage() + "Order:" + orderId);
            return false;
        }

        return true;
    }


    private void validateAmount(CardInfo card, double amount) throws PaymentException {
        if (card.getAmount() < amount) {
            throw new PaymentException("Недостаточно средств.");
        }
    }


    private class PaymentException extends Exception {
        public PaymentException(String message) {
            super(message);
        }

    }

    private class TicketException extends Exception {
        public TicketException(String message) {
            super(message);
        }
    }
}