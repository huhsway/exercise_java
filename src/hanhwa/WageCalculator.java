package hanhwa;

import java.util.*;

public class WageCalculator {
    public int solution(int[][] works, int wage) {
        int totalHours = 31 * 24;
        int[] workingHours = new int[totalHours];
        int[] totalHoursPerDay = new int[32]; // 1일부터 31일까지 사용 (인덱스 1~31)

        processWorkRecords(works, workingHours);
        int totalWorkingHours = analyzeWorkingHours(workingHours, totalHoursPerDay);

        int totalOvertimeHours = calculateOvertimeHours(totalHoursPerDay);
        int totalNightHours = calculateNightHours(workingHours);
        int totalWeekendHours = calculateWeekendHours(workingHours);
        int totalWeeklyHolidayPay = calculateWeeklyHolidayPay(totalHoursPerDay, wage);

        return calculateTotalWage(wage, totalWorkingHours, totalOvertimeHours, totalNightHours, totalWeekendHours, totalWeeklyHolidayPay);
    }

    // 근무 기록 처리
    private void processWorkRecords(int[][] works, int[] workingHours) {
        for (int[] work : works) {
            int startTime = (work[0] - 1) * 24 + work[1];
            int endTime = (work[2] == 32 && work[3] == 0) ? 31 * 24 : (work[2] - 1) * 24 + work[3];

            for (int h = startTime; h < endTime; h++) {
                workingHours[h] = 1;
            }
        }
    }

    // 근무 시간 분석 및 총 근무 시간 반환
    private int analyzeWorkingHours(int[] workingHours, int[] totalHoursPerDay) {
        int totalWorkingHours = 0;
        for (int h = 0; h < workingHours.length; h++) {
            if (workingHours[h] == 1) {
                totalWorkingHours++;
                int day = h / 24 + 1;
                totalHoursPerDay[day]++;
            }
        }
        return totalWorkingHours;
    }

    // 연장 근무 시간 계산
    private int calculateOvertimeHours(int[] totalHoursPerDay) {
        int totalOvertimeHours = 0;
        for (int day = 1; day <= 31; day++) {
            if (totalHoursPerDay[day] > 8) {
                totalOvertimeHours += totalHoursPerDay[day] - 8;
            }
        }
        return totalOvertimeHours;
    }

    // 야간 근무 시간 계산
    private int calculateNightHours(int[] workingHours) {
        int totalNightHours = 0;
        for (int h = 0; h < workingHours.length; h++) {
            if (workingHours[h] == 1) {
                int hourInDay = h % 24;
                if (hourInDay >= 22 && hourInDay <= 23) {
                    totalNightHours++;
                }
            }
        }
        return totalNightHours;
    }

    // 주말 근무 시간 계산
    private int calculateWeekendHours(int[] workingHours) {
        int totalWeekendHours = 0;
        for (int h = 0; h < workingHours.length; h++) {
            if (workingHours[h] == 1) {
                int day = h / 24 + 1;
                int dayOfWeek = (day - 1) % 7;
                if (dayOfWeek == 5 || dayOfWeek == 6) { // 토요일 또는 일요일
                    totalWeekendHours++;
                }
            }
        }
        return totalWeekendHours;
    }

    // 주휴 수당 계산
    private int calculateWeeklyHolidayPay(int[] totalHoursPerDay, int wage) {
        int totalWeeklyHolidayPay = 0;
        for (int week = 1; week <= 4; week++) {
            int weekStartDay = (week - 1) * 7 + 1;
            int weekEndDay = weekStartDay + 6;
            int totalHoursThisWeek = 0;
            for (int day = weekStartDay; day <= weekEndDay && day <= 31; day++) {
                totalHoursThisWeek += totalHoursPerDay[day];
            }
            if (totalHoursThisWeek >= 15) {
                totalWeeklyHolidayPay += (wage * totalHoursThisWeek * 2) / 10;
            }
        }
        return totalWeeklyHolidayPay;
    }

    // 총 임금 계산
    private int calculateTotalWage(int wage, int totalWorkingHours, int totalOvertimeHours, int totalNightHours, int totalWeekendHours, int totalWeeklyHolidayPay) {
        int basePay = wage * totalWorkingHours;
        int overtimePay = (wage * totalOvertimeHours * 5) / 10;
        int nightPay = (wage * totalNightHours * 5) / 10;
        int weekendPay = (wage * totalWeekendHours * 5) / 10;
        return basePay + overtimePay + nightPay + weekendPay + totalWeeklyHolidayPay;
    }

    // 메인 함수 - 입출력 예시 포함
    public static void main(String[] args) {
        WageCalculator sol = new WageCalculator();

        // 예제 1
        int[][] works1 = {{1,8,1,13},{5,18,6,9}};
        int wage1 = 10000;
        int result1 = sol.solution(works1, wage1);
        System.out.println("예제 1 결과: " + result1); // 예상 결과: 300000

        // 예제 2
        int[][] works2 = {{1,22,3,8},{13,12,13,17},{14,22,15,0}};
        int wage2 = 15000;
        int result2 = sol.solution(works2, wage2);
        System.out.println("예제 2 결과: " + result2); // 예상 결과: 934500
    }
}
