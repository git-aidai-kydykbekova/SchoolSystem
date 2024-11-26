package com.example.Software_P.dto;




public class ScheduleDto {
    private String title;
    private String dayOfWeek;
    private String dueTime;
    private String year;


    public String getTitle() {
        return title;
    }

    public ScheduleDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public ScheduleDto setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        return this;
    }

    public String getDueTime() {
        return dueTime;
    }

    public ScheduleDto setDueTime(String dueTime) {
        this.dueTime = dueTime;
        return this;
    }

    public String getYear() {
        return year;
    }

    public ScheduleDto setYear(String year) {
        this.year = year;
        return this;
    }
}

