package com.temper.models;

import java.util.Date;

public class WeekStats {

    public static double onboardingPercentage1 = 0;
    public static double onboardingPercentage2 = 20;
    public static double onboardingPercentage3 = 40;
    public static double onboardingPercentage4 = 50;
    public static double onboardingPercentage5 = 70;
    public static double onboardingPercentage6 = 90;
    public static double onboardingPercentage7 = 99;
    public static double onboardingPercentage8 = 100;

    public Date created;// represents week
    public Double onboardingPercentage;
    public Integer applications;
    public Integer acceptedApplications;

    public int stageCount1;// 1. create account - 0%
    public int stageCount2;// 2. activate account - 20%
    public int stageCount3;// 3. provide profile information - 40%
    public int stageCount4;// 4. what jobs are you interested in? - 50%
    public int stageCount5;// 5. do you have relevant experience in these jobs? - 70%
    public int stageCount6;// 6. are you freelancer? - 90%
    public int stageCount7;// 7. waiting for approval - 99%
    public int stageCount8;// 8. approval - 100%

   
}
