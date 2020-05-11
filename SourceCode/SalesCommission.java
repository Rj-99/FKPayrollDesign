package SourceCode;

class SalesCommission implements Commission
{
    private double commissionRate;
    private double salesAmount;

    public double getSales()
    {
        return salesAmount;
    }

    public void setSalesAmount(double salesAmount) {
        this.salesAmount = salesAmount;
    }

    public void resetSales()
    {
        salesAmount = 0.0;
    }

    public void updateSales(double amount)
    {
        salesAmount += amount;
    }

    public void setRate(double rate)
    {
        commissionRate = rate;
    }

    public double getRate()
    {
        return commissionRate;
    }

    public double calculateCommission()
    {
        return (commissionRate * salesAmount);
    }
}