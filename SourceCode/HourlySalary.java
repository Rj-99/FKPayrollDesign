package SourceCode;

class HourlySalary implements Salaried
{
    private double hoursWorked;
    private double extraHours;
    private double dailyRate;
    private TimeCard card;
    
    public double getHoursWorked()
    {
        return hoursWorked;
    }

    public double getExtraHours()
    {
        return extraHours;
    }

    public void setTimeCard(TimeCard card)
    {
        this.card = card;
    }

    public TimeCard getTimeCard()
    {
        return card;
    }
    
    public double getRate()
    {
        return dailyRate;
    }

    public void setRate(double rate){
        dailyRate = rate;
    }
    
    public void resetWorkHours()
    {
        hoursWorked = 0.0;
        extraHours = 0.0;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setExtraHours(double extraHours) {
        this.extraHours = extraHours;
    }

    public void updateHoursWorked()
    {
        if(card.getDuration() <= 8.0)
            hoursWorked += card.getDuration();
        else
        {
            hoursWorked += 8.0;
            extraHours += card.getDuration() - 8.0;
        }
    }

    public double calculateSalary()
    {  
        return ((dailyRate * hoursWorked)
                + (1.5 * dailyRate * extraHours));
    }
}