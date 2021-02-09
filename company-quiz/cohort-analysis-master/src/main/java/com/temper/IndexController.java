package com.temper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.temper.models.Cohort;
import com.temper.models.WeekStats;

//@RestController
@Controller
public class IndexController extends BaseController {

    private static final String DATE_FORMAT = "MMM d";

    /*
     * @RequestMapping("/home") public String index(Model model) {
     * 
     * model.addAttribute("name", "kakashi");
     * 
     * return "home"; }
     */

    @RequestMapping("/cohorts")
    @ResponseBody
    public List<Cohort> cohorts() {

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

        Collection<WeekStats> list = analysisService.getWeeklyCohorts();
        list = list.stream().sorted((a, b) -> a.created.compareTo(b.created)).collect(Collectors.toList());
        List<Cohort> cohortlist = new ArrayList<>(list.size());
        list.forEach((w) -> {

            log.info(w);
            Cohort c = new Cohort();
            c.name = sdf.format(w.created);
            c.data = new ArrayList<>();

            c.data.add(100.0);
            BigDecimal bd;
            bd = new BigDecimal(w.stageCount2 * 100.0 / w.stageCount1).setScale(2, RoundingMode.HALF_UP);
            c.data.add(bd.doubleValue());
            bd = new BigDecimal(w.stageCount3 * 100.0 / w.stageCount1).setScale(2, RoundingMode.HALF_UP);
            c.data.add(bd.doubleValue());
            bd = new BigDecimal(w.stageCount4 * 100.0 / w.stageCount1).setScale(2, RoundingMode.HALF_UP);
            c.data.add(bd.doubleValue());
            bd = new BigDecimal(w.stageCount5 * 100.0 / w.stageCount1).setScale(2, RoundingMode.HALF_UP);
            c.data.add(bd.doubleValue());
            bd = new BigDecimal(w.stageCount6 * 100.0 / w.stageCount1).setScale(2, RoundingMode.HALF_UP);
            c.data.add(bd.doubleValue());
            bd = new BigDecimal(w.stageCount7 * 100.0 / w.stageCount1).setScale(2, RoundingMode.HALF_UP);
            c.data.add(bd.doubleValue());
            bd = new BigDecimal(w.stageCount8 * 100.0 / w.stageCount1).setScale(2, RoundingMode.HALF_UP);
            c.data.add(bd.doubleValue());

            cohortlist.add(c);
        });
        return cohortlist;

    }

}
