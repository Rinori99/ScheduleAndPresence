package server.services;

public interface BaseService<T, I> {

    T create(T t);

    T findById(I id);

}
