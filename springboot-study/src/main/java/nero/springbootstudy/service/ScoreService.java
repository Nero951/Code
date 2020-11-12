package nero.springbootstudy.service;

import nero.springbootstudy.mapper.ScoreMapper;
import nero.springbootstudy.model.Score;
import nero.springbootstudy.model.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;
    public Score query(Integer id) {
        return scoreMapper.selectByPrimaryKey(id);

    }

    public List<Score> test(Stu stu) {
        return scoreMapper.test(stu);
    }
}
