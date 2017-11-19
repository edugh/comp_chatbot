package com.example.bot.spring.model;

import com.example.bot.spring.DatabaseException;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class FAQ {
    public final String question;
    public final String answer;

    public static FAQ fromResultSet(ResultSet resultSet) throws SQLException {
        return new FAQ(resultSet.getString(1), resultSet.getString(2));
    }
}
