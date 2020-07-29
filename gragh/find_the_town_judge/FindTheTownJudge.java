package gragh.find_the_town_judge;

public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        int[] inDegree = new int[N];
        int[] outDegree = new int[N];
        for (int[] path : trust) {
            outDegree[path[0] - 1]++;
            inDegree[path[1] - 1]++;
        }
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == N-1 && outDegree[i] == 0) {
                return i+1;
            }
        }
        return -1;
    }
}