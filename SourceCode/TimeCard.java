package SourceCode;

import java.time.LocalDate;

class TimeCard {
    private LocalDate date;
    private double time;

    public TimeCard()
    {
        date = null;
        time = 0.0;
    }

    public TimeCard(LocalDate date, double time)
    {
        this.date = date;
        this.time = time;
    }

    public double getDuration()
    {
        return time;
    }

    public void setDuration(double time)
    {
        this.time = time;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }
}