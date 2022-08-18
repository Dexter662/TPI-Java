package com.informatorio.news.mappers;

public interface IMapper <I, O> {
    public O map(I in);
}
