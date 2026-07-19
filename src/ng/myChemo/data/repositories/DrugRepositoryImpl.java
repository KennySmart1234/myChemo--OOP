package ng.myChemo.data.repositories;

import ng.myChemo.data.models.Drug;

import java.util.ArrayList;
import java.util.List;

public class DrugRepositoryImpl implements DrugRepository {

    private final List<Drug> drugs = new ArrayList<>();
    private int count;

    @Override
    public int count() {
        return count;
    }


    @Override
    public Drug save(Drug drug) {
        if (!drugs.contains(drug)) {
            drug.setId(++count);
            drugs.add(drug);
            return drug;
        }
        throw new IllegalArgumentException("Drug already exists");

    }

    @Override
    public Drug findById(int id) {
        for (Drug drug : drugs) {
            if (drug.getId() == id) {
                return drug;
            }
        }
        return null;
    }

    @Override
    public void delete(Drug drug) {
        drugs.remove(drug);
        count--;
    }

    @Override
    public void deleteById(int id) {
        drugs.remove(findById(id));
        count--;
    }

    @Override
    public void deleteAll(){
        drugs.clear();
        count = 0;
    }

    @Override
    public boolean existsById(int id) {
        for (Drug drug : drugs) {
            if (drug.getId() == id) {
                return true;
            }
        }
        return false;
    }

}
