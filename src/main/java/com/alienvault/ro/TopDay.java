package com.alienvault.ro;

import java.util.Map;

public class TopDay {

    String day;

    Map<String, Long> occurrences;

    public TopDay(String day, Map<String, Long> occurrences) {
        this.day = day;
        this.occurrences = occurrences;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Map<String, Long> getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(Map<String, Long> occurrences) {
        this.occurrences = occurrences;
    }
}
