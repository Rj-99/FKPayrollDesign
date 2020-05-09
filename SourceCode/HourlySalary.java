package assignment;

class HourlySalary implements Salaried
{
    private double hoursWorked;
    private double extraHours;
    private double dailyRate;
    
    double getHoursWorked()
    {
        return hoursWorked;
    }

    double getExtraHours()
    {
        return extraHours;
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

    void updateHoursWorked(TimeCard card)
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