package ng.myChemo.data.repositories;

import ng.myChemo.data.models.DispensedDrugs;

import java.util.ArrayList;
import java.util.List;

public class DispensedDrugsRepositoryImpl implements DispensedDrugsRepository {

    private final List<DispensedDrugs> dispensedDrugs = new ArrayList<>();
    private int count;

    @Override
    public int count() {
        return count;
    }


    @Override
    public DispensedDrugs save(DispensedDrugs dispensedDrug) {
        if (!dispensedDrugs.contains(dispensedDrug)) {
            dispensedDrug.setId(++count);
            dispensedDrugs.add(dispensedDrug);
            return dispensedDrug;
        }
        throw new IllegalArgumentException("Drug already exists");

    }

    @Override
    public DispensedDrugs findById(int id) {
        for (DispensedDrugs dispensedDrug : dispensedDrugs) {
            if (dispensedDrug.getId() == id) {
                return dispensedDrug;
            }
        }
        return null;
    }

    @Override
    public void delete(DispensedDrugs drug) {
        dispensedDrugs.remove(drug);
        count--;
    }

    @Override
    public void deleteById(int id) {
        dispensedDrugs.remove(findById(id));
        count--;
    }

    @Override
    public void deleteAll(){
        dispensedDrugs.clear();
        count = 0;
    }

    @Override
    public boolean existsById(int id) {
        for (DispensedDrugs dispensedDrug : dispensedDrugs) {
            if (dispensedDrug.getId() == id) {
                return true;
            }
        }
        return false;
    }

}
