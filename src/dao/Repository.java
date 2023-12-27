package dao;

import java.util.List;

public interface Repository<T> {
    public int add(T t);
    public List<T> list();

}
