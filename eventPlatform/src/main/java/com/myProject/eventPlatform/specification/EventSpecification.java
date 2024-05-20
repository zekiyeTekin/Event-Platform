package com.myProject.eventPlatform.specification;

import com.myProject.eventPlatform.entity.Event;
import com.myProject.eventPlatform.filter.EventFilter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class EventSpecification {


    public static Specification<Event> searchByDate(EventFilter eventFilter){
        return (Root< Event > root, CriteriaQuery < ?> query, CriteriaBuilder builder) ->{

            List<Predicate> predicateList = new ArrayList<>();

            if (eventFilter.getDate() != null)
            {
                predicateList.add(builder.equal(root.get("date"), eventFilter.getDate()));
            }
            return builder.and(predicateList.toArray(new Predicate[0]));
        };
    }


    public static Specification<Event> searchByCategoryName(EventFilter eventFilter){
        return (Root< Event> root, CriteriaQuery <?> query, CriteriaBuilder builder) -> {

            List<Predicate> predicateList = new ArrayList<>();

            if (eventFilter.getCategory() != null ){
                predicateList.add(builder.equal(root.get("category").get("type"), eventFilter.getCategory()));
            }
            return builder.and(predicateList.toArray(new Predicate[0]));
        };
    }

    public static Specification<Event> searchByAddress(EventFilter eventFilter){
        return (Root< Event> root, CriteriaQuery <?> query, CriteriaBuilder builder) -> {

            List<Predicate> predicateList = new ArrayList<>();

            if(eventFilter.getAddress() != null && !eventFilter.getAddress().isEmpty()){
                predicateList.add(builder.like(builder.lower(root.get("address")), "%" + eventFilter.getAddress().toLowerCase() + "%"));
            }
            return builder.and(predicateList.toArray(new Predicate[0]));
        };

    }

    public static Specification<Event> searchByCommunity(EventFilter eventFilter){
        return (Root <Event> root, CriteriaQuery <?> query, CriteriaBuilder builder) -> {

            List<Predicate> predicateList = new ArrayList<>();
            if(eventFilter.getCommunity() != null && !eventFilter.getCommunity().isEmpty()){
                predicateList.add(builder.like(builder.lower(root.get("community").get("title")), "%" + eventFilter.getCommunity().toLowerCase() + "%" ));
            }
            return builder.and(predicateList.toArray(predicateList.toArray(new Predicate[0])));
        };

    }




}
