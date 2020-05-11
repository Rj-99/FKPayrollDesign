package SourceCode;

class EmployeeUnion implements Unions
{
    private double weeklyRate;
    private double serviceCharges;

    public double getWeeklyDues()
    {
        return weeklyRate;
    }

    public double getServiceCharges()
    {
        return serviceCharges;
    }

    public void setRate(double rate)
    {
        weeklyRate = rate;
    }

    public void setServiceCharges(double serviceCharges) {
        this.serviceCharges = serviceCharges;
    }

    public void resetServiceCharges()
    {
        serviceCharges = 0;
    }

    public void updateServiceCharges(double charges)
    {
        serviceCharges += charges;
    }
}