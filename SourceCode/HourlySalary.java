package assignment;

class HourlySalary implements Salaried
{
    private double hoursWorked;
    private double extraHours;
    private double dailyRate;
    private TimeCard card;
    
    double getHoursWorked()
    {
        return hoursWorked;
    }

    double getExtraHours()
    {
        return extraHours;
    }

    void setTimeCard(TimeCard card)
    {
        this.card = card;
    }

    TimeCard getTimeCard()
    {
        return card;
    }
    
    double getRate()
    {
        return dailyRate;
    }

    double setRate(double rate){
        dailyRate = rate;
    }
    
    void resetWorkHours()
    {
        hoursWorked = 0.0;
        extraHours = 0.0;
    }

    void updateHoursWorked()
    {
        if(card.getDuration() <= 8.0)
            hoursWorked += card.getDuration();
        else
        {
            hoursWorked += 8.0;
            extraHours += card.getDuration() - 8.0;
        }
    }

    double calculateSalary()
    {  
        return ((dailyRate * hoursWorked)
                + (1.5 * dailyRate * extraHours));
    }
}