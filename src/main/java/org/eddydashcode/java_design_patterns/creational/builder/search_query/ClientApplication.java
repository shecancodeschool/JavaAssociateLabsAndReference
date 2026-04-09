package org.eddydashcode.java_design_patterns.creational.builder.search_query;

import static org.eddydashcode.java_design_patterns.creational.builder.search_query.SearchCriteria.SortOrderType.ASC;
import static org.eddydashcode.java_design_patterns.creational.builder.search_query.SearchCriteria.SortOrderType.DESC;

public class ClientApplication {

    public static void main(String[] args) {

        // complete search criteria builder
        SearchCriteria completeSearchCriteria = SearchCriteria.builder()
                .keyword("name")
                .category("expired")
                .filterBy("duration")
                .sortOrder(ASC)
                .build();

        System.out.println(completeSearchCriteria.getKeyword());
        System.out.println(completeSearchCriteria.getCategory());
        System.out.println(completeSearchCriteria.getFilterBy());
        System.out.println(completeSearchCriteria.getSortOrder());

        System.out.println(); // for spacing

        // partial search criteria builder
        SearchCriteria partialSearchCriteria = SearchCriteria.builder()
                .keyword("expired")
                .sortOrder(DESC)
                .build();

        System.out.println(partialSearchCriteria.getKeyword());
        System.out.println(partialSearchCriteria.getCategory());
        System.out.println(partialSearchCriteria.getFilterBy());
        System.out.println(partialSearchCriteria.getSortOrder());
    }
}
