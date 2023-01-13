package com.example.kcalog.service;

import com.example.kcalog.domain.Food;
import com.example.kcalog.repository.FoodRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class FoodServiceTest {

    @Autowired
    FoodRepository foodRepository;

    @Test
    public void 음식등록_불러오기() throws Exception {
        //given
        String foodName = "밥";
        float kcal = 300f;
        float carb = 64.3f;
        float fat = 1;
        float protein = 5.7f;
        float gram = 210;

        foodRepository.save(Food.builder()
                .name(foodName)
                .kcal(kcal)
                .carb(carb)
                .fat(fat)
                .protein(protein)
                .gram(gram)
                .build());

        //when
        List<Food> foodList = foodRepository.findAll();

        //then
        Food food = foodList.get(0);
        Assertions.assertThat(food.getName()).isEqualTo(foodName);
        Assertions.assertThat(food.getKcal()).isEqualTo(kcal);
        Assertions.assertThat(foodList.size()).isEqualTo(1);


    }

}