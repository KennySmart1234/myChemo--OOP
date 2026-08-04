package ng.myChemo.data.repositories;

import ng.myChemo.data.models.Drug;

import java.util.ArrayList;
import java.util.List;

public class DrugRepositoryImpl implements DrugRepository {

    private static final List<Drug> drugs = new ArrayList<>();
    private static long drugId = 0;


    @Override
    public long count() {

        return drugs.size();
    }



    @Override
    public Drug save(Drug drug) {
        if (isNew(drug)) {
            saveNew(drug);
        }else {
            updateExisting(drug);
        }
        return drug;
    }


    private boolean isNew(Drug drug){

        return drug.getDrugId() == 0;
    }


    private void saveNew(Drug drug){
        if (drugs.contains(drug)) {
            throw new IllegalArgumentException("Drug already exists");
        }
        drug.setDrugId(++drugId);
        drugs.add(drug);

    }

    @Override
    public void deleteById(long drugId) {
        Drug drug = findById(drugId);
        if (drug != null) {
            drugs.remove(drug);
        }
    }


    @Override
    public void delete(Drug drug) {
        drugs.remove(drug);
    }


    private void updateExisting(Drug drug){
        Drug existingDrug = findById(drug.getDrugId());
        if (existingDrug == null) {
            throw new IllegalArgumentException("Drug already exists");
        }

        int index = drugs.indexOf(existingDrug);
        drugs.set(index, drug);

    }



    @Override
    public void deleteAll(){
        drugs.clear();
        drugId = 0;
    }


    @Override
    public Drug findById(long drugId) {
        for (Drug drug : drugs) {
            if (drug.getDrugId() == drugId) {
                return drug;
            }
        }
        return null;
    }
    
    
    

    @Override
    public Drug findByNameAndBrand(String name, String brand) {
        for (Drug drug : drugs) {
            if(drug.getDrugName().equals(name) && drug.getBrand().equals(brand)) {
                return drug;
            }
        }

        return null;
    }

    
  

}
