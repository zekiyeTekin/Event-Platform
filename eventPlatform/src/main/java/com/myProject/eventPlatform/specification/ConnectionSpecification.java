package com.myProject.eventPlatform.specification;

import com.myProject.eventPlatform.entity.Connection;
import com.myProject.eventPlatform.entity.Event;
import com.myProject.eventPlatform.filter.ConnectionFilter;
import com.myProject.eventPlatform.filter.EventFilter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ConnectionSpecification {


    public static Specification<Connection> searchByUserRequest(ConnectionFilter connectionFilter){
        return (Root< Connection > root, CriteriaQuery< ?> query, CriteriaBuilder builder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            if (connectionFilter.getReceiver() != null ){
                predicateList.add(builder.equal(root.get("receiver").get("id"), connectionFilter.getReceiver()));
            }
            return builder.and(predicateList.toArray(new Predicate[0]));
        };
    }



}
