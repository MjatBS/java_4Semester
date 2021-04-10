package com.lab6;

public class Lab6 {
    public static void main(String[] args) {
        Substance c2o5 = new Substance("C2O5"); c2o5.setWeight(15);
        Ointment aqua = new Ointment("Aqua",c2o5,52);
        Substance heroin = new Substance("Heroin"); heroin.setWeight(0.2);
        Medicine med  = new Medicine("Losa",heroin,15);
        Substance weed = new Substance("Weed"); weed.setWeight(14);
        Tablets tablet = new Tablets("Giperleo",weed,15);
        Substance h2so4 = new Substance("H2SO4"); h2so4.setWeight(40);
        Solution sol = new Solution(h2so4,52);

        MedicinalProduct[] meds = new MedicinalProduct[4];
        meds[0] = aqua;
        meds[1] = med;
        meds[2] = tablet;
        meds[3] = sol;

        for(MedicinalProduct mp:meds){
            System.out.println(mp);
            System.out.println(mp.getInfoActiveSubstance(0));
            System.out.println(mp.calculateDosage());
            System.out.println();
        }
    }
}
