package nero.springbootstudy.mapper;

import java.util.List;
import nero.springbootstudy.model.Stu;
import nero.springbootstudy.model.StuExample;
import org.apache.ibatis.annotations.Param;

public interface StuMapper {
    long countByExample(StuExample example);

    int deleteByExample(StuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Stu record);

    int insertSelective(Stu record);

    List<Stu> selectByExample(StuExample example);

    Stu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Stu record, @Param("example") StuExample example);

    int updateByExample(@Param("record") Stu record, @Param("example") StuExample example);

    int updateByPrimaryKeySelective(Stu record);

    int updateByPrimaryKey(Stu record);
}