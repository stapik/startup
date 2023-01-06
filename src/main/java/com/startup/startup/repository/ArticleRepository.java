package com.startup.startup.repository;

import com.startup.startup.dto.DayStatisticsDTO;
import com.startup.startup.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query(value = "select CAST(a.published_at AS DATE) as date, count(a.id) as count" +
            " from Article a " +
            " where a.published_at > :d " +
            " group by CAST(a.published_at AS DATE)", nativeQuery = true)
    List<DayStatisticsDTO> getStatisticsByDayAfterDate(@Param("d") LocalDateTime date);
}
