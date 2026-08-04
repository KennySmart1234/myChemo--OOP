package ng.myChemo.data.repositories;

import ng.myChemo.data.models.DispensedDrugs;

import java.util.ArrayList;
import java.util.List;

public class DispensedDrugsRepositoryImpl implements DispensedDrugsRepository {

    private final List<DispensedDrugs> dispensedDrugs = new ArrayList<>();
    private long dispensedDrugsId = 0;



    @Override
    public long count() {

        return dispensedDrugs.size();
    }


    @Override
    public DispensedDrugs save(DispensedDrugs dispensedDrug) {
        if (isNew(dispensedDrug)) {
            saveNew(dispensedDrug);
        }else {
            updateExisting(dispensedDrug);
        }
        return dispensedDrug;
    }


    private boolean isNew(DispensedDrugs dispensedDrug){

        return dispensedDrug.getDispensedDrugsId() == 0;
    }


    private void saveNew(DispensedDrugs dispensedDrug){
        if (dispensedDrugs.contains(dispensedDrug)) {
            throw new IllegalArgumentException("DispensedDrugs already exists");
        }
        dispensedDrug.setDispensedDrugsId(++dispensedDrugsId);
        dispensedDrugs.add(dispensedDrug);

    }

    @Override
    public void deleteById(long dispensedDrugsId) {
        DispensedDrugs dispensedDrug = findById(dispensedDrugsId);
        if (dispensedDrug != null) {
            dispensedDrugs.remove(dispensedDrug);
        }
    }


    @Override
    public void delete(DispensedDrugs dispensedDrug) {
        dispensedDrugs.remove(dispensedDrug);
    }


    private void updateExisting(DispensedDrugs dispensedDrug){
        DispensedDrugs existingDispensedDrugs = findById(dispensedDrug.getDispensedDrugsId());
        if (existingDispensedDrugs != null) {
            throw new IllegalArgumentException("DispensedDrugs already exists");
        }

        int index = dispensedDrugs.indexOf(existingDispensedDrugs);
        dispensedDrugs.set(index, dispensedDrug);

    }



    @Override
    public void deleteAll(){
        dispensedDrugs.clear();
        dispensedDrugsId = 0;
    }


    @Override
    public DispensedDrugs findById(long dispensedDrugsId) {
        for (DispensedDrugs dispensedDrug : dispensedDrugs) {
            if (dispensedDrug.getDispensedDrugsId() == dispensedDrugsId) {
                return dispensedDrug;
            }
        }
        return null;
    }


}
