package assignment;

import java.time.LocalDate;

class SalesReceipt {
    private LocalDate date;
    private double salesAmount;

    public SalesReceipt(LocalDate date, double amount)
    {
        this.date = date;
        salesAmount = amount;
    }

    double getAmount()
    {
        return salesAmount;
    }

    void setAmount(double amount)
    {
        salesAmount = amount;
    }

    LocalDate getDate()
    {
        return date;
    }

    void setDate(LocalDate date)
    {
        this.date = date;
    }
}