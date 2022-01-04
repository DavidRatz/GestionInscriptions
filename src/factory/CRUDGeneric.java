package factory;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface CRUDGeneric<T> {
    T add(List<T> genericList, T model);
    T get(List<T> genericList, int index);
    Optional<T> getBy(List<T> genericList, Predicate<T> predicate);
    int getIndexBy(List<T> genericList, Predicate<T> predicate);
    T remove(List<T> genericList, T model);
    T update(List<T> genericList, T model, int index);
}
