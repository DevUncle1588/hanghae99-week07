package com.example.model;

public enum MusicCategoryEnum {
    HIPHOP("hiphop"),
    ROCK("rock");



    final private String category;

    private MusicCategoryEnum(String category){
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}

