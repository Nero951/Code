package nero.service;

import nero.exception.BusinessException;
import nero.mapper.SettingMapper;
import nero.model.Award;
import nero.model.Member;
import nero.model.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingService {

    @Autowired
    private SettingMapper settingMapper;

    @Autowired
    private AwardService awardService;

    @Autowired
    private MemberService memberService;

    public Setting query(Integer id) {
        Setting query = new Setting();
        query.setUserId(id);
        //注册用户时需要生成一个Setting数据，如果没有生成代表业务有问题
        Setting setting = settingMapper.selectOne(query);
        if(setting == null){
            throw new BusinessException("SET001","用户设置信息出错");
        }
        //查询奖品列表、人员列表，设置到属性中
        //通过setting_id查询奖品列表
        Award award = new Award();
        award.setSettingId(setting.getId());
        List<Award> awards = awardService.query(award);
        setting.setAwards(awards);

        //通过user_id，查询人员列表
        Member member = new Member();
        member.setUserId(id);
        List<Member> members = memberService.query(member);
        setting.setMembers(members);

        return setting;
    }
}
