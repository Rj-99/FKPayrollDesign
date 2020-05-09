package assignment;

class EmployeeUnion implements Unions
{
    private double weeklyRate;
    private double serviceCharges;

    double getWeeklyDues()
    {
        return weeklyRate;
    }

    double getServiceCharges()
    {
        return serviceCharges;
    }

    void setRate(double rate)
    {
        weeklyRate = rate;
    }

    void resetServiceCharges()
    {
        serviceCharges = 0;
    }

    void updateServiceCharges(double charges)
    {
        serviceCharges += charges;
    }
}