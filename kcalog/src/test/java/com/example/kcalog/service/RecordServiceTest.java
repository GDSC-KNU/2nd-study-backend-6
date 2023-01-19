package com.example.kcalog.service;

import com.example.kcalog.domain.Food;
import com.example.kcalog.domain.MealType;
import com.example.kcalog.domain.Record;
import com.example.kcalog.domain.RecordItem;
import com.example.kcalog.repository.RecordRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class RecordServiceTest {

    @Autowired RecordService recordService;
    @Autowired RecordRepository recordRepository;

    @Test
    public void 식단_등록() throws Exception{
        //given
        Record record = createRecord();

        //when
        Record save = recordService.save(record);

        //then
        Assertions.assertThat(save).isEqualTo(record);
     }


    @Test
    public void 날짜로_조회() throws Exception{
        //given
        Record record = createRecord();

        //when
        Record save = recordService.save(record);
        LocalDate targetDate = LocalDate.now();

        //then
        Assertions.assertThat(save).isEqualTo(recordService.findByDate(targetDate).get(0));
     }

      @Test
      public void 식단_수정() throws Exception{
          //given
          Record record = createRecord();
          recordService.save(record);

          //when
          Long changeId = recordService.update(record.getId(), MealType.LUNCH, record.getRecordItems());

          //then
          Assertions.assertThat(recordRepository.findById(changeId).get().getMealType()).isEqualTo(MealType.LUNCH);

       }

       @Test
       public void 식단_삭제() throws Exception{
           //given
           Record save = recordService.save(createRecord());

           //when
            recordService.delete(save.getId());

           //then
           Assertions.assertThat(recordRepository.findById(save.getId())).isEmpty();
        }

    public Record createRecord() {
        List<RecordItem> recordItems = new ArrayList<RecordItem>();

        Food food = Food.builder()
                .name("밥")
                .kcal(100)
                .build();

        RecordItem recordItem = RecordItem.builder()
                .count(2)
                .food(food)
                .build();

        recordItems.add(recordItem);

        Record record = Record.builder()
                .date(LocalDate.now())
                .mealType(MealType.BREAKFAST)
                .recordItems(recordItems)
                .build();
        return record;
    }

}