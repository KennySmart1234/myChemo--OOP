package ng.myChemo.services;

import ng.myChemo.data.models.DispensedDrug;

import java.util.List;

public interface ChemistServices {
    String addDrug(String name, String brand, int price);
    String updateDrug(int id, String name, String brand, int price);
    String deleteDrug(int id);
    String dispenseDrugs(List<DispensedDrug>  dispensedDrugs);
}
