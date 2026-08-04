package ng.myChemo.data.repositories;

import ng.myChemo.data.models.Batch;

import java.util.ArrayList;
import java.util.List;

public class BatchRepositoryImpl implements BatchRepository {


    private static final List<Batch> batches = new ArrayList<>();
    private static long batchId = 0;



    @Override
    public long count() {

        return batches.size();
    }


    @Override
    public Batch save(Batch batch) {
        if (isNew(batch)) {
            saveNew(batch);
        }else {
            updateExisting(batch);
        }
        return batch;
    }


    private boolean isNew(Batch batch){

        return batch.getBatchId() == 0;
    }


    private void saveNew(Batch batch){
        if (batches.contains(batch)) {
            throw new IllegalArgumentException("Batch already exists");
        }
        batch.setBatchId(++batchId);
        batches.add(batch);

    }

    @Override
    public void deleteById(long batchId) {
        Batch batch = findById(batchId);
        if (batch != null) {
            batches.remove(batch);
        }
    }


    @Override
    public void delete(Batch batch) {
        batches.remove(batch);
    }


    private void updateExisting(Batch batch){
        Batch existingBatch = findById(batch.getBatchId());
        if (existingBatch != null) {
            throw new IllegalArgumentException("Batch already exists");
        }

        int index = batches.indexOf(existingBatch);
        batches.set(index, batch);

    }



    @Override
    public void deleteAll(){
        batches.clear();
        batchId = 0;
    }


    @Override
    public Batch findById(long batchId) {
        for (Batch batch : batches) {
            if (batch.getBatchId() == batchId) {
                return batch;
            }
        }
        return null;
    }

    
}
