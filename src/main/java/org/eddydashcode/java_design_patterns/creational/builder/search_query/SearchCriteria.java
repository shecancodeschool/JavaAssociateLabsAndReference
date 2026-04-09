package org.eddydashcode.java_design_patterns.creational.builder.search_query;

public class SearchCriteria {
    private final String keyword;
    private final String category;
    private final String filterBy;
    private final SortOrderType sortOrder;


    private SearchCriteria(SearchCriteriaBuilder builder) {
        this.keyword = builder.keyword;
        this.category = builder.category;
        this.filterBy = builder.filterBy;
        this.sortOrder = builder.sortOrder;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getCategory() {
        return category;
    }

    public String getFilterBy() {
        return filterBy;
    }

    public SortOrderType getSortOrder() {
        return sortOrder;
    }

    public static SearchCriteriaBuilder builder() {
        return new SearchCriteriaBuilder();
    }

    public static class SearchCriteriaBuilder {

        private String keyword;
        private String category;
        private String filterBy;
        private SortOrderType sortOrder;

        public SearchCriteriaBuilder keyword(String keyword) {
            this.keyword = keyword;
            return this;
        }

        public SearchCriteriaBuilder category(String category) {
            this.category = category;
            return this;
        }

        public SearchCriteriaBuilder filterBy(String filterBy) {
            this.filterBy = filterBy;
            return this;
        }

        public SearchCriteriaBuilder sortOrder(SortOrderType sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }


        public SearchCriteria build() {
            return new SearchCriteria(this);
        }

    }

    public enum SortOrderType {
        ASC, DESC
    }

}
