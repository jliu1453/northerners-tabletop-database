//generic inteface for all mappers
package com.northerners.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface repo<T, ID> {
    List<T> findAll(); //return list of entity
    T findById(ID id);
    int insert(T entity);
    int update(T entity);
    int delete(ID id);
}

