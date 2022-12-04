package ru.enovikow.devops.mapper;

public interface ModelMapper<D, M> {
    D toDto(M model);
}
