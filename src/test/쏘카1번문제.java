package test;
import java.util.*;

class 쏘카1번문제 {
    public int[] solution(int n, int k, int[][] roads) {
        int[] answer = {};
        int[][] roadTime = new int[n][n];
        List<Integer> tmpAnswer = new ArrayList<>();

        for(int i=0; i<roads.length; i++) {

            int nodeA = roads[i][0];
            int nodeB = roads[i][1];
            int t = roads[i][2];
            roadTime[nodeA][nodeB] = t;
            roadTime[nodeB][nodeA] = t;

        }

        Queue<Step> queue = new LinkedList<>();

        // 첫번째 노드는 0번
        Step firstStep = new Step(0, 0);
        queue.add(firstStep);

        while(!queue.isEmpty()) {

            Step nowStep = queue.poll();            
            int nowNode = nowStep.nowNode;
            int nowTime = nowStep.time;

            //System.out.println("now:"+nowNode+"// time:" + nowTime);

            // 현재 소모한 시간이 제한 시간과 같으면 임시 배열에 넣는다.
            if(nowTime == k) {                
                if(!tmpAnswer.contains(nowNode)){
                    tmpAnswer.add(nowNode);
                }                
                continue;
            }

            // 현재 소모한 시간이 제한 시간보다 크다면 더이상 진행x
            if(nowTime > k) {
                continue;
            }

            // 현재 노드에서 갈 수 있는 모든 노드를 큐에 넣는다.
            // 왔던 길도 되돌아가도 상관 없음            
            for(int i=0; i<roadTime[nowNode].length; i++) {
                if(roadTime[nowNode][i] > 0) {
                    Step nextStep = new Step(i,nowTime + roadTime[nowNode][i]);
                    queue.add(nextStep);
                }
            }

        }

        answer = new int[tmpAnswer.size()];
        for(int i=0; i<tmpAnswer.size(); i++) {
            answer[i] = tmpAnswer.get(i);
        }

        // 조건을 만족하는 보관소가 없는 경우
        if(answer.length == 0) {
            answer = new int[1];
            answer[0] = -1;
        }        

        // 오름차순 정렬
        Arrays.sort(answer);

        return answer;
    }


    class Step {
        int nowNode;
        int time;    
        public Step(int nowNode, int time) {
            this.nowNode = nowNode;
            this.time = time;
        }    
    }
}