package com.rexdev08.LiterAlura.gutendex;

import java.util.List;

public class GutendexResponse {

    private List<GutendexBook> results;

    public List<GutendexBook> getResults() {
        return results;
    }

    public void setResults(List<GutendexBook> results) {
        this.results = results;
    }
}
