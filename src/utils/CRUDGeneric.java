package utils;

import java.util.List;
import java.util.Optional;

public interface CRUDGeneric<T> {
    T add(List<T> genericList, T model);
    T get(List<T> genericList, int index);
    T remove(List<T> genericList, T model);
    T update(List<T> genericList, T model, int index);
}
