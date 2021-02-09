package com.temper.services;

import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temper.CSVLoader;
import com.temper.models.WeekStats;

@Service
public class AnalysisServiceImp implements AnalysisService {

    @Autowired
    CSVLoader csvLoader;
    Log log = LogFactory.getLog(getClass());

    @Override
    public Collection<WeekStats> getWeeklyCohorts() {

        try {

            HashMap<Date, WeekStats> map = new HashMap<Date, WeekStats>();

            csvLoader.loadDataFromFile().stream().forEach(u -> {
                Date date = getWeekStart(u.created);
                WeekStats weekStats = map.get(date);
                if (weekStats == null) {
                    weekStats = new WeekStats();
                    weekStats.created = date;
                    map.put(date, weekStats);
                }
                if (u.onboardingPercentage >= WeekStats.onboardingPercentage1) {
                    weekStats.stageCount1 += 1;
                }
                if (u.onboardingPercentage >= WeekStats.onboardingPercentage2) {
                    weekStats.stageCount2 += 1;
                }
                if (u.onboardingPercentage >= WeekStats.onboardingPercentage3) {
                    weekStats.stageCount3 += 1;
                }
                if (u.onboardingPercentage >= WeekStats.onboardingPercentage4) {
                    weekStats.stageCount4 += 1;
                }
                if (u.onboardingPercentage >= WeekStats.onboardingPercentage5) {
                    weekStats.stageCount5 += 1;
                }
                if (u.onboardingPercentage >= WeekStats.onboardingPercentage6) {
                    weekStats.stageCount6 += 1;
                }
                if (u.onboardingPercentage >= WeekStats.onboardingPercentage7) {
                    weekStats.stageCount7 += 1;
                }
                if (u.onboardingPercentage >= WeekStats.onboardingPercentage8) {
                    weekStats.stageCount8 += 1;
                }
            });

            map.values().forEach(w -> {
                log.info(w);
            });

            return map.values();
        } catch (Exception e) {
            log.error("Error", e);
            return Collections.emptyList();
        }
    }

    Date getWeekStart(Date yourDate) {

        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // cal.set(Calendar.WEEK_OF_YEAR, week);
        // Date yourDate = cal.getTime();
        cal.setTime(yourDate);// Set specific Date of which start and end you want
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Date start = cal.getTime();// Date of Monday of current week

        return start;
    }
}
