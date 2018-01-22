package hello.controller.quartz;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/1/22.
 */
@Controller("QuartzJob")
public class QuartzJob {
    private final Logger logger = LoggerFactory.getLogger(QuartzJob.class);

    @ResponseBody
    @RequestMapping("executeJob")
    public void executeJob() {
        logger.error("Start a jod 参数{}，参数{}", "A", "B");

        logger.error("End a jod {}", "特殊");
    }
}