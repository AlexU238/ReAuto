package u238.reauto.repository;

import java.util.List;
import java.util.Optional;

public interface DefaultRepository<K,T> {

    T save(T object);

    Optional<T> findById(K id);

    List<T> findAll();

    boolean existsById(K id);

    void deleteById(K id);

}
