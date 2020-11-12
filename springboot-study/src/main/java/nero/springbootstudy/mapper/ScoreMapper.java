package nero.springbootstudy.mapper;

import nero.springbootstudy.model.Score;
import nero.springbootstudy.model.ScoreExample;
import nero.springbootstudy.model.Stu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ScoreMapper {
    long countByExample(ScoreExample example);

    int deleteByExample(ScoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Score record);

    int insertSelective(Score record);

    List<Score> selectByExample(ScoreExample example);

    Score selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByExample(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);

    List<Score> test(Stu stu);
}