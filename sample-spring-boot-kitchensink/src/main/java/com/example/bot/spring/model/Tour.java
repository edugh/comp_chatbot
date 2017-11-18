package com.example.bot.spring.model;

import com.example.bot.spring.DatabaseException;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tour {
    public String planId;
    public Date tourDate;
    public String guideName;
    public String guideAccount;
    public String hotel;
    public int capacity;
    public int booked;
    public int minimum;

    public Tour(String planId, Date tourDate, String guideName, String guideAccount, String hotel, int capacity, int booked, int minimum) {
        this.planId = planId;
        this.tourDate = tourDate;
        this.guideName = guideName;
        this.guideAccount = guideAccount;
        this.hotel = hotel;
        this.capacity = capacity;
        this.booked = booked;
        this.minimum = minimum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tour tour = (Tour) o;

        if (capacity != tour.capacity) return false;
        if (booked != tour.booked) return false;
        if (minimum != tour.minimum) return false;
        if (planId != null ? !planId.equals(tour.planId) : tour.planId != null) return false;
        if (tourDate != null ? !tourDate.equals(tour.tourDate) : tour.tourDate != null) return false;
        if (guideName != null ? !guideName.equals(tour.guideName) : tour.guideName != null) return false;
        if (guideAccount != null ? !guideAccount.equals(tour.guideAccount) : tour.guideAccount != null) return false;
        return hotel != null ? hotel.equals(tour.hotel) : tour.hotel == null;
    }

    @Override
    public int hashCode() {
        int result = planId != null ? planId.hashCode() : 0;
        result = 31 * result + (tourDate != null ? tourDate.hashCode() : 0);
        result = 31 * result + (guideName != null ? guideName.hashCode() : 0);
        result = 31 * result + (guideAccount != null ? guideAccount.hashCode() : 0);
        result = 31 * result + (hotel != null ? hotel.hashCode() : 0);
        result = 31 * result + capacity;
        result = 31 * result + booked;
        result = 31 * result + minimum;
        return result;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "planId='" + planId + '\'' +
                ", tourDate=" + tourDate +
                ", guideName='" + guideName + '\'' +
                ", guideAccount='" + guideAccount + '\'' +
                ", hotel='" + hotel + '\'' +
                ", capacity=" + capacity +
                ", booked=" + booked +
                ", minimum=" + minimum +
                '}';
    }

    public static Tour fromResultSet(ResultSet resultSet) {
        try {
            return new Tour(
                resultSet.getString(1),
                resultSet.getDate(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getString(5),
                resultSet.getInt(6),
                resultSet.getInt(7),
                resultSet.getInt(8)
            );
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }
}
