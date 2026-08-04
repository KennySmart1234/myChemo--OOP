package ng.myChemo.data.repositories;

import ng.myChemo.data.models.DispensedDrugs;

public interface DispensedDrugsRepository {

    long count();

    DispensedDrugs save(DispensedDrugs dispensedDrugs);

    DispensedDrugs findById(long dispensedDrugs);

    void deleteById(long dispensedDrugs);

    void delete(DispensedDrugs dispensedDrugs);

    void deleteAll();


}
