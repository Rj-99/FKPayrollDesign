package assignment;

class SalesCommission implements Commission
{
    private double commissionRate;
    private double salesAmount;

    double getSales()
    {
        return salesAmount;
    }

    void resetSales()
    {
        salesAmount = 0.0;
    }

    void updateSales(double amount)
    {
        salesAmount += amount;
    }

    double calculateCommssion()
    {
        return (commissionRate * salesAmount);
    }
}