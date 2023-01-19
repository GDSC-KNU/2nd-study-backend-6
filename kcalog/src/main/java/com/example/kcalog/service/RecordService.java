package com.example.kcalog.service;

import com.example.kcalog.domain.MealType;
import com.example.kcalog.domain.Record;
import com.example.kcalog.domain.RecordItem;
import com.example.kcalog.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecordService {
    private final RecordRepository recordRepository;

    /**
     * 식단 기록 등록
     */
    @Transactional
    public Record save(Record record) {
        return recordRepository.save(record);
    }

    /**
     * 식단 수정
     */
    @Transactional
    public Long update(Long id, MealType mealType,  List<RecordItem> recordItems) {
        Record record = recordRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("등록된 식단이 없습니다. id = " + id));

        record.update(mealType, recordItems);
        return id;
    }

    /**
     * 날짜로 식단 조회
     */
    public List<Record> findByDate(LocalDate date) {
        return recordRepository.findByDate(date);
    }

    /**
     * 기간으로 식단 조회
     */
    public List<Record> findByPeriod(LocalDate start, LocalDate end) {
        return recordRepository.findByPeriod(start, end);
    }

    /**
     * 식단 삭제
     */
    @Transactional
    public void delete(Long recordId) {
        recordRepository.deleteById(recordId);
    }

}
