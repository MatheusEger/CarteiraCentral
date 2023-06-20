/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.utils;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 *
 * @author PC-Eger
 */
public class Range {
    private LocalDate startDate;
    private LocalDate endDate;

    public Range(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Range(YearMonth yearMonth) {
        this.startDate = yearMonth.atDay(1);
        this.endDate = yearMonth.atEndOfMonth();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Range{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}