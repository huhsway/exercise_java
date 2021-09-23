package 오픈채팅방;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> arr = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < record.length; i++){
            String[] command = record[i].split(" ");
            if (command[0].equals("Enter")){
                arr.add(command[1] + "님이 들어왔습니다.");
                map.put(command[1], command[2]);
            } else if (command[0].equals("Change")) {
                map.put(command[1], command[2]);
            } else {
                arr.add(command[1] + "님이 나갔습니다.");
            }
        }
        String[] answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++){
            int idx = arr.get(i).indexOf("님");
            String id = arr.get(i).substring(0, idx);
            String[] temp = arr.get(i).split(" ");
            answer[i] = map.get(id) + "님이 " + temp[1];
        }
        return answer;

    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(record)));
    }
}

//class Solution {
//    public String[] solution(String[] record) {
//        ArrayList<String> chatLog = new ArrayList<>();
//        HashMap<String, String> nickMap = new HashMap<>();
//
//        for(String log : record){
//            StringTokenizer st = new StringTokenizer(log);
//            String command = st.nextToken();
//            String userId = st.nextToken();
//            String nickname = "";
//
//            if(!command.equals("Leave")){
//                nickname = st.nextToken();
//            }
//
//            switch(command){
//                case "Enter":
//                    nickMap.put(userId, nickname);
//                    chatLog.add(userId + "님이 들어왔습니다.");
//                    break;
//                case "Leave":
//                    chatLog.add(userId + "님이 나갔습니다.");
//                    break;
//                case "Change":
//                    nickMap.put(userId, nickname);
//                    break;
//            }
//        }
//
//        String[] answer = new String[chatLog.size()];
//        int logIdx = 0;
//
//        for(String str : chatLog){
//            int endOfId = str.indexOf("님");
//            String userId = str.substring(0, endOfId);
//
//            answer[logIdx++] = str.replace(userId, nickMap.get(userId));
//        }
//
//        return answer;
//    }
//}