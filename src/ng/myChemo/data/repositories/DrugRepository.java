package ng.myChemo.data.repositories;

import ng.myChemo.data.models.Drug;

public interface DrugRepository {

    long count();

    Drug save(Drug drug);

    Drug findById(long drugId);

    void deleteById(long drugId);

    void delete(Drug drug);

    void deleteAll();

//    boolean existsById(int id);

    Drug findByNameAndBrand(String name,String brand);



}
