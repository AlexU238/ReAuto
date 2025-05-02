package u238.reauto.service;

import java.util.List;

public interface Service<T, ID> {

    T save(T t);

    T update(T t);

    void delete(T t);

    void deleteById(ID id);

    List<T> findAll();

    T findById(ID id);
}
