package com.example.kcalog.repository;

import com.example.kcalog.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {
    /**
     * 날짜로 식단 조회
     */
    @Query("select r from Record r where r.date = :date")
    List<Record> findByDate(@Param("date") LocalDate date);

    /**
     * 기간으로 식단 조회
     */
    @Query("select r from Record r where r.date >= :start and r.date <= :end")
    List<Record> findByPeriod(@Param("start") LocalDate startDate, @Param("end") LocalDate endDate);

}
