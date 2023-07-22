package com.KG.KGMS.dateLimit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class DateLimitService {

    private final DateLimitRepository dateLimitRepository;

    public DateLimitService(DateLimitRepository dateLimitRepository) {
        this.dateLimitRepository = dateLimitRepository;
    }

    public List<DateLimit> getAllDateLimits() {
        return dateLimitRepository.findAll();
    }

    public Optional<DateLimit> getDateLimitById(Long id) {
        return dateLimitRepository.findById(id);
    }

    public DateLimit saveDateLimit(DateLimit dateLimit) {
        return dateLimitRepository.save(dateLimit);
    }

    public void deleteDateLimit(Long id) {
        dateLimitRepository.deleteById(id);
    }

    public List<String> getYearsFromValidDates() {
        List<DateLimit> dateLimits = dateLimitRepository.findAll();
        List<String> yearsList = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (DateLimit dateLimit : dateLimits) {
            try {
                dateFormat.parse(dateLimit.getFromDate()); // This will throw ParseException if the date is invalid
                String year = dateLimit.getFromDate(); // Extract the year from the date string
                yearsList.add(year);
                dateFormat.parse(dateLimit.getEndDate()); // This will throw ParseException if the date is invalid
                year = dateLimit.getEndDate(); // Extract the year from the date string
                yearsList.add(year);
            } catch (Exception e) {
                // The date is invalid, skip it
            }
        }

        return yearsList;
    }

    public String checkIfBetweenDate(String studentDate) {
        DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<DateLimit> dateLimits = dateLimitRepository.findAll();
        System.out.println(dateLimits.size());
        try {
            for (DateLimit dateLimit : dateLimits) {
                LocalDate targetDate = LocalDate.parse(studentDate, DATE_FORMATTER);
                LocalDate startDate = LocalDate.parse(dateLimit.getFromDate(), DATE_FORMATTER);
                LocalDate endDate = LocalDate.parse(dateLimit.getEndDate(), DATE_FORMATTER);
                if ((targetDate.equals(startDate) || targetDate.isAfter(startDate))
                        && (targetDate.equals(endDate) || targetDate.isBefore(endDate))) {
                    return dateLimit.getTypeStudent();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
        // AgeCalculator.isDateBetweenTwoDates(studentDate,, null);
    }
}