package nero.controller;

import nero.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/award")
public class AwardController {

    @Autowired
    private AwardService awardService;

}
