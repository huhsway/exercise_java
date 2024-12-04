package nsuslab.three;

import java.util.*;

public class Solution {
    public List<String> solution(String path) {
        List<String> answer = new ArrayList<>();
        int time = 0;           // 현재 시간
        int distance = 0;       // 현재까지 이동한 거리
        char currentDirection = path.charAt(0);  // 현재 진행 방향

        for (int i = 0; i < path.length(); i++) {
            // 방향이 변경될 다음 인덱스를 체크
            if (i > 0 && path.charAt(i) != path.charAt(i - 1)) {
                // 방향이 변경되면 이전 거리 체크
                if (distance >= 500) {
                    answer.add("Time " + time + ": Go straight 500m and turn " + getTurnDirection(currentDirection, path.charAt(i)));
                    distance -= 500;  // 남은 거리 업데이트
                }
                // 방향 변경 직후 남은 거리가 500m 이하일 경우 메시지 출력
                else if (distance > 0) {
                    answer.add("Time " + time + ": Go straight " + distance + "m and turn " + getTurnDirection(currentDirection, path.charAt(i)));
                    distance = 0;  // 거리 초기화
                }
                // 방향 변경 후 방향 업데이트
                currentDirection = path.charAt(i);
            }

            // 매번 100m씩 이동
            distance += 100;  // 거리 업데이트
            time++;
        }

        return answer;
    }

    // 방향 전환을 결정하는 메서드
    private String getTurnDirection(char currentDirection, char nextDirection) {
        if (currentDirection == 'E' && nextDirection == 'S' ||
                currentDirection == 'S' && nextDirection == 'W' ||
                currentDirection == 'W' && nextDirection == 'N' ||
                currentDirection == 'N' && nextDirection == 'E') {
            return "right";
        }
        return "left";
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("EEESEEEEEENNNN")); // 예상: ["Time 0: Go straight 300m and turn right", "Time 3: Go straight 100m and turn left", "Time 5: Go straight 500m and turn left"]
        System.out.println(sol.solution("SSSSSSWWWNNNNNN")); // 예상: ["Time 1: Go straight 500m and turn right", "Time 6: Go straight 300m and turn right"]
    }
}

