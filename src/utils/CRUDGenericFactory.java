package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class CRUDGenericFactory<T> implements CRUDGeneric<T>{

    // private List<T> genericList;

    // public CRUDGenericFactory() {
    //     genericList = new ArrayList<>();
    // }

    // public List<T> getActivityTypeList() {
    //     return genericList;
    // }

    // public void setGenericList(List<T> genericList) {
    //     this.genericList = genericList;
    // }

    @Override
    public T add(List<T> genericList, T model) {
        genericList.add(model);
        return model;
    }

    @Override
    public T get(List<T> genericList, int index) {
        return genericList.get(index);
    }

    @Override
    public T remove(List<T> genericList, T model) {
        genericList.remove(model);
        return model;
    }

    @Override
    public T update(List<T> genericList, T model, int index) {
        genericList.set(index, model);
        return model;
    }
}
