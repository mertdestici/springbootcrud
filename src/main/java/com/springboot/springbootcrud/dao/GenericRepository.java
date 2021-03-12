package com.springboot.springbootcrud.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface GenericRepository<T,ID> extends PagingAndSortingRepository<T,ID>, JpaSpecificationExecutor<T> {

    Page<T> findAll(Pageable pageable);
    long count();
}
