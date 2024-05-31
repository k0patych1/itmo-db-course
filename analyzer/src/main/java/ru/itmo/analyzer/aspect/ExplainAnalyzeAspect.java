package ru.itmo.analyzer.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Aspect
@Component
@RequiredArgsConstructor
public class ExplainAnalyzeAspect {
    private final JdbcTemplate jdbcTemplate;

    @Around("execution(* org.springframework.jdbc.core.JdbcTemplate.execute(..))")
    public Object logPerformance(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        List<String> queries = new ArrayList<>();
        List<String> costs = new ArrayList<>();

        if (args.length > 0 && args[0] instanceof String sql) {
            String explainSql = "EXPLAIN ANALYZE " + sql;
            List<Map<String, Object>> explainResult = jdbcTemplate.queryForList(explainSql);
            String cost = getCostFromExplainAnalyzeResult(explainResult);
            queries.add(sql);
            costs.add(cost);
        }

        writeResultToFile(queries, costs);

        return pjp.proceed();
    }

    private void writeResultToFile(List<String> queries, List<String> costs) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("results/results.txt", true))) {
            int len = queries.size();
            for (int i = 0; i < len; ++i) {
                writer.write("""
                        Query: %s
                        Cost: %s
                        """.formatted(queries.get(i), costs.get(i)));
                writer.newLine();
            }
        }
    }

    private String getCostFromExplainAnalyzeResult(List<Map<String, Object>> explainResult) {
        String input = (String) explainResult.getFirst().get("QUERY PLAN");
        Pattern pattern = Pattern.compile("cost=(\\d+\\.\\d+)\\.\\.(\\d+\\.\\d+)");
        Matcher matcher = pattern.matcher(input);

        if (!matcher.find()) {
            return "Error parsing cost";
        }

        return matcher.group(2);
    }
}