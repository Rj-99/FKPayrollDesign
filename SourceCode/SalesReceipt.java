package SourceCode;

import java.time.LocalDate;

class SalesReceipt {
    private LocalDate date;
    private double salesAmount;

    public SalesReceipt()
    {
        date = null;
        salesAmount = 0.0;
    }

    public SalesReceipt(LocalDate date, double amount)
    {
        this.date = date;
        salesAmount = amount;
    }

    public double getAmount()
    {
        return salesAmount;
    }

    public void setAmount(double amount)
    {
        salesAmount = amount;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }
}