package nero.service;

import nero.mapper.AwardMapper;
import nero.model.Award;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardService {

    @Autowired
    private AwardMapper awardMapper;

    public List<Award> query(Award award) {

        return awardMapper.query(award);
    }
}
