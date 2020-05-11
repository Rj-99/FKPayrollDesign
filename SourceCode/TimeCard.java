package assignment;

import java.time.LocalDate;

class TimeCard {
    private LocalDate date;
    private double time;

    public TimeCard(LocalDate date, double time)
    {
        this.date = date;
        this.time = time;
    }

    double getDuration()
    {
        return time;
    }

    void setDuration(double time)
    {
        this.time = time;
    }

    LocalDate getDate()
    {
        return date;
    }

    void setDate(LocalDate date)
    {
        this.date = date;
    }
}