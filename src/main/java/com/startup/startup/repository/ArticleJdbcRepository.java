package com.startup.startup.repository;

import com.startup.startup.dto.DayStatisticsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ArticleJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<DayStatisticsDTO> getStatisticsByDayAfterDate(@Param("d") LocalDateTime date) {
        return jdbcTemplate.query("select CAST(a.published_at AS DATE) as date, count(a.id) as count" +
                        " from Article a " +
                        " where a.published_at > ? " +
                        " group by CAST(a.published_at AS DATE)",
                this::mapRowToDayStatisticsDTO,
                date
        );
    }

    private DayStatisticsDTO mapRowToDayStatisticsDTO(ResultSet row, int rowNum) throws SQLException {

        return new DayStatisticsDTO() {
            private final Integer count = row.getInt("count");
            private final LocalDate date = row.getDate("date").toLocalDate();

            @Override
            public Integer getCount() {
                return count;
            }

            @Override
            public LocalDate getDate() {
                return date;
            }
        };
    }
}
