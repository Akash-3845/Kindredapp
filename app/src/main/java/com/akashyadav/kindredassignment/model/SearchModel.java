package com.akashyadav.kindredassignment.model;

import java.util.ArrayList;

public class SearchModel {

    private ArrayList<imageModel> results;

    public SearchModel(ArrayList<imageModel> results) {
        this.results = results;
    }

    public ArrayList<imageModel> getResults() {
        return results;
    }

    public void setResults(ArrayList<imageModel> results) {
        this.results = results;
    }
}
