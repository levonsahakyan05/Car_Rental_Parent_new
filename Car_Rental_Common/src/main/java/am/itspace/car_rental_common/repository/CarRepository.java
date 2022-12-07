package am.itspace.car_rental_common.repository;


import am.itspace.car_rental_common.entity.Car;
import am.itspace.car_rental_common.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findAllByCategory(Category category);
    Page<Car> findAll(Pageable pageable);

    List<Car> findCarByDealerId(int dealerId);

    Optional<Car> findById(int id);
    @Query("SELECT p FROM Car p WHERE CONCAT(p.name, p.model,p.productionYear) LIKE %?1%")
    Page<Car> searchCarByNameOrModel(Pageable pageable,String keyword);
}