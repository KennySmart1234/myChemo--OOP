package ng.myChemo.data.repositories;

import ng.myChemo.data.models.DispensedDrugs;

public interface DispensedDrugsRepository {

    int count();

    DispensedDrugs save(DispensedDrugs dispensedDrugs);

    DispensedDrugs findById(int id);

    void deleteById(int id);

    void delete(DispensedDrugs dispensedDrugs);

    void deleteAll();

    boolean existsById(int id);

}
