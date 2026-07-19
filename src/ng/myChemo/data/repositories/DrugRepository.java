package ng.myChemo.data.repositories;

import ng.myChemo.data.models.Drug;

public interface DrugRepository {

    int count();

    Drug save(Drug drug);

    Drug findById(int id);

    void deleteById(int id);

    void delete(Drug drug);

    void deleteAll();

    boolean existsById(int id);



}
