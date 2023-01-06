package com.startup.startup.dto;

import java.sql.SQLException;
import java.time.LocalDate;

public interface DayStatisticsDTO {

    Integer getCount() throws SQLException;

    LocalDate getDate() throws SQLException;
}
