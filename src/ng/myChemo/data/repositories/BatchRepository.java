package ng.myChemo.data.repositories;


import ng.myChemo.data.models.Batch;

public interface BatchRepository {



    long count();

    Batch save(Batch batch);

    Batch findById(long batchId);

    void deleteById(long batchId);

    void delete(Batch batch);

    void deleteAll();


}
