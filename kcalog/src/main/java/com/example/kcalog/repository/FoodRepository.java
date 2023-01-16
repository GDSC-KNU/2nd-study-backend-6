package com.example.kcalog.repository;

import com.example.kcalog.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    /**
     * 음식 이름으로 검색
     */
    @Query("select f from Food f where f.name like %:foodName% order by f.kcal desc")
    List<Food> findByFoodName(@Param("foodName") String foodName);
}
