package com.aztsoft.gym.persistence.repository;

/**
 * Created by Arnold on 15/11/2017.
 */
public interface Repository<T> {
    public void add(T item);
    Boolean success();
}

