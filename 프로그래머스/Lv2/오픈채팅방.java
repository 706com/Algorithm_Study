package 프로그래머스.Lv2;

// 소요시간
// [240427] : 30분

import java.util.*;

public class 오픈채팅방 {
    public String[] solution(String[] record) {
        String[] answer;
        List<String> result = new ArrayList<>();
        //uid를 key로 가지고 닉네임을 값으로 가지는 해시를 생성한다.
        HashMap<String, String> hm = new HashMap<>();
        //queue에 command와 uid를 가지는 클래스를 담는다.
        Queue<Node> q = new LinkedList<>();

        // record 입력값에 따라서 명령어대로 수행
        for(int i=0; i<record.length; i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            String command = st.nextToken();
            String uid;
            String nickname;
            Node node;
            switch(command){
                //Enter : 큐에 명령어와 uid 넣기
                //해시에 값 넣기
                case "Enter":
                    uid = st.nextToken();
                    nickname = st.nextToken();
                    node = new Node(command,uid);
                    q.offer(node);
                    hm.put(uid,nickname);
                    break;
                //Leave : 큐에 명령어와 uid 넣기
                case "Leave":
                    uid = st.nextToken();
                    node = new Node(command,uid);
                    q.offer(node);
                    break;
                //Change : 해시값 변경
                case "Change":
                    uid = st.nextToken();
                    nickname = st.nextToken();
                    hm.put(uid,nickname);
                    break;
            }
        }

        // for(Node x : q){
        //     System.out.println(x.command +" " +x.uid);
        // }

        //큐 순회 :
        while(!q.isEmpty()){
            Node node = q.poll();
            String command = node.command;
            String uid = node.uid;
            //  큐 값이 Enter 일때 -> 해시에 검색해서 들어왔습니다 출력
            if(command.equals("Enter")){
                String nickname = hm.get(uid);
                String str = nickname +"님이 들어왔습니다.";
                result.add(str);
            }
            //  큐 값이 Leave 일때 -> 해시에 검색해서 나갔습니다 출력
            else if(command.equals("Leave")){
                String nickname = hm.get(uid);
                String str = nickname +"님이 나갔습니다.";
                result.add(str);
            }
            //  Change일때 -> 해시 값 변경

        }

//        // for문으로 변경
//        answer = new String[result.size()];
//        for(int i=0; i<result.size(); i++){
//            answer[i] = result.get(i);
//        }
//        return answer;

        // Stream으로 변경
        return result.stream().toArray(String[]::new);
    }
    class Node{
        String command;
        String uid;

        Node(String cmd, String u){
            command = cmd;
            uid = u;
        }
    }
}
