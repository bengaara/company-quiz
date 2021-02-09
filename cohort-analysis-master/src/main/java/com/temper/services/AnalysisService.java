package com.temper.services;

import java.util.Collection;

import com.temper.models.WeekStats;

public interface AnalysisService {

    public Collection<WeekStats> getWeeklyCohorts();
}
