package nero.base;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BaseMapper<T extends BaseEntity> {
    T selectByPrimaryKey(Integer id);
    int deleteByPrimaryKey(Integer id);
    List<T> selectAll();
    List<T> selectByCondition(T t);
}
