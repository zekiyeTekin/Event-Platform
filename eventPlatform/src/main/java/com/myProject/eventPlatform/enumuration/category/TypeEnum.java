package com.myProject.eventPlatform.enumuration.category;

public enum TypeEnum {

    TEKNOLOJI_BILGISAYAR("Teknoloji ve Bilgisayar"),
    SANAT_KULTUR("Sanat ve Kültür"),
    SPOR_AKTIVITE("Spor ve Aktivite"),
    YEMEK_MUTFAK("Yemek ve Mutfak"),
    DOGA_CEVRE("Doğa ve Çevre"),
    EGITIM_OGRENME("Eğitim ve Öğrenme"),
    HOBI_ELSANATLARI("Hobi ve El Sanatları"),
    KARIYER_ISDUNYASI("Kariyer ve El Sanatları"),
    YARDIM_DESTEK("Sosyal Yardım ve Destek Grupları"),
    GEZI_SEYAHAT("Gezi ve Seyahat");


    private final String name;

    TypeEnum(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
