package com.example.kcalog.service;

import com.example.kcalog.domain.Food;
import com.example.kcalog.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    /**
     * 음식 등록
     */
    @Transactional
    public Food save(Food food) {
        return foodRepository.save(food);
    }

    /**
     * 모든 음식 조회
     */
    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    /**
     * 아이디로 음식 조회
     */
    public List<Food> findOne(String foodName) {
        return foodRepository.findByFoodName(foodName);
    }


}
