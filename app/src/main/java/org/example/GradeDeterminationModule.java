package org.example;

public class GradeDeterminationModule extends ScoreDecisionModule {

    public String determineGrade(double nilaiAkhir) {
        return determine(nilaiAkhir);
    }

    @Override
    public String determine(double nilaiAkhir) {
        if (nilaiAkhir >= 85) {
            return "A";
        }
        if (nilaiAkhir >= 70) {
            return "B";
        }
        if (nilaiAkhir >= 60) {
            return "C";
        }
        if (nilaiAkhir >= 50) {
            return "D";
        }
        return "E";
    }
}
