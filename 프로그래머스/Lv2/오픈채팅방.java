package 프로그래머스.Lv2;

// 소요시간
// [240427] : 30분
//[251121] : 25분

import java.util.*;

public class 오픈채팅방 {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();

        List<Info> commandList = new ArrayList<>();
        for(int i=0; i<record.length; i++){
            String[] infos = record[i].split(" ");
            String command = infos[0];  //명령어
            switch(command){
                case "Enter":
                    String uuid = infos[1];
                    String nickname = infos[2];

                    commandList.add(new Info(command,uuid));
                    map.put(uuid,nickname); // uuid 기준 있으면 덮어쓰기
                    break;
                case "Leave":
                    uuid = infos[1];

                    commandList.add(new Info(command,uuid));
                    break;
                case "Change":
                    uuid = infos[1];
                    nickname = infos[2];

                    map.put(uuid,nickname);
                    break;
            }
        }

        //결과 출력
        List<String> resultList = new ArrayList<>();

        for(Info x : commandList){
            String message = "";
            if(x.command.equals("Enter")){
                message = map.get(x.uuid) +"님이 들어왔습니다.";
            }else if(x.command.equals("Leave")){
                message = map.get(x.uuid) +"님이 나갔습니다.";
            }

            resultList.add(message);
        }
        // System.out.println(resultList);
        return resultList.stream().toArray(String[]::new);
    }


    public class Info{
        String command;
        String uuid;

        public Info(String command,String uuid){
            this.command = command;
            this.uuid = uuid;
        }
        @Override
        public String toString(){
            return command + " " + uuid;
        }
    }
}
