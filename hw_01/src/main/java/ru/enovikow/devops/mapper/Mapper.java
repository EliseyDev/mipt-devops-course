package ru.enovikow.devops.mapper;

public interface Mapper<D, M> {
    D toDto(M model);
}
