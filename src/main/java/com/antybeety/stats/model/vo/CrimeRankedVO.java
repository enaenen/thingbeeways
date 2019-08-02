package com.antybeety.stats.model.vo;

import lombok.Data;

@Data
public class CrimeRankedVO implements  Comparable<CrimeRankedVO>{
    private CrimeStatsVO stats;
    private double rate;

    public CrimeRankedVO() {}
    public CrimeRankedVO(CrimeStatsVO stats, double rate) {
        this.stats=stats;
        this.rate = rate;
    }
    public String toString() {
        return "CrimeRankedVO [stats=" + stats + ", rate=" + rate + "]";
    }
    public int compareTo(CrimeRankedVO arg0) {
        int targetRank = arg0.getStats().getOccurCnt();
        if(stats.getOccurCnt()==targetRank) return 0;
        else if(stats.getOccurCnt() > targetRank) return 1;
        else return -1;
    }

}
