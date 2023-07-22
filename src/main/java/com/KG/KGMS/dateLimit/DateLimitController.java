package com.KG.KGMS.dateLimit;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/datelimits")
public class DateLimitController {

    private final DateLimitService dateLimitService;

    public DateLimitController(DateLimitService dateLimitService) {
        this.dateLimitService = dateLimitService;
    }

    @GetMapping
    public ResponseEntity<List<DateLimit>> getAllDateLimits() {
        List<DateLimit> dateLimits = dateLimitService.getAllDateLimits();
        return new ResponseEntity<>(dateLimits, HttpStatus.OK);
    }

    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> uniqueSet = new HashSet<>(list);
        return new ArrayList<>(uniqueSet);
    }

    @GetMapping("/limitsYears")
    public ResponseEntity<List<String>> limitsYears() {
        List<String> string = dateLimitService.getYearsFromValidDates();
        List<String> uniqueStrings = removeDuplicates(string);
        uniqueStrings.sort(null);
        return ResponseEntity.ok(uniqueStrings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DateLimit> getDateLimitById(@PathVariable Long id) {
        Optional<DateLimit> dateLimit = dateLimitService.getDateLimitById(id);
        return dateLimit.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<DateLimit> createDateLimit(@RequestBody DateLimit dateLimit) {
        DateLimit savedDateLimit = dateLimitService.saveDateLimit(dateLimit);
        return new ResponseEntity<>(savedDateLimit, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DateLimit> updateDateLimit(@PathVariable Long id, @RequestBody DateLimit updatedDateLimit) {
        Optional<DateLimit> dateLimit = dateLimitService.getDateLimitById(id);
        if (dateLimit.isPresent()) {
            updatedDateLimit.setDateLimitId(id);
            DateLimit savedDateLimit = dateLimitService.saveDateLimit(updatedDateLimit);
            return new ResponseEntity<>(savedDateLimit, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDateLimit(@PathVariable Long id) {
        Optional<DateLimit> dateLimit = dateLimitService.getDateLimitById(id);
        if (dateLimit.isPresent()) {
            dateLimitService.deleteDateLimit(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
