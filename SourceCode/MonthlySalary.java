package SourceCode;

class MonthlySalary implements Salaried
{
    private double monthlyRate;

    public double getRate()
    {
        return monthlyRate;
    }

    public void setRate(double rate)
    {
        monthlyRate = rate;
    }

    public double calculateSalary()
    {
        return monthlyRate;
    }
}