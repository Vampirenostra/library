package ua.vampirenostra.library.entity;

import org.springframework.data.domain.Sort;

public class Search {
    String searchType;
    String searchString;
    String fieldSorted;
    Sort.Direction ascDesc;

    public Search() {
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public String getFieldSorted() {
        return fieldSorted;
    }

    public void setFieldSorted(String fieldSorted) {
        this.fieldSorted = fieldSorted;
    }

    public Sort.Direction getAscDesc() {
        return ascDesc;
    }

    public void setAscDesc(Sort.Direction ascDesc) {
        this.ascDesc = ascDesc;
    }
}
