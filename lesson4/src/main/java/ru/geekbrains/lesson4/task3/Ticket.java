package ru.geekbrains.lesson4.task3;

import java.time.LocalDateTime;
import java.util.Date;

class Ticket{

    private int id;
    private int customerId;
    private Date date;
    private String qrcode;

    private boolean enable = true;
    {
        qrcode = LocalDateTime.now().toString();
    }
    public int getId() {
        return id;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getQrcode() {
        return qrcode;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getDate() {
        return date;
    }
}
