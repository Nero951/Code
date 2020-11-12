package nero.springbootstudy.controller;

import nero.springbootstudy.model.Score;
import nero.springbootstudy.model.Stu;
import nero.springbootstudy.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;
    @GetMapping("/query")
    public Object query(Integer id){
        Score scores = scoreService.query(id);
        return scores;
    }

    @PostMapping("/test")
    public Object test(Stu stu){
        List<Score> scores = scoreService.test(stu);
        return scores;
    }


}
