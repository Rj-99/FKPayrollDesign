package assigment;

class MonthlySalary implements Salaried
{
    private double monthlyRate;

    double getRate()
    {
        return monthlyRate;
    }

    void setRate(double rate)
    {
        monthlyRate = rate;
    }

    double calculateSalary()
    {
        return monthlyRate;
    }
}