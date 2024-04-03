package com.polixis.demo.converter;

public interface Converter<M, E> {
    E convertToEntity(M model, E entity);
    M convertToModel(E entity, M model);
}
