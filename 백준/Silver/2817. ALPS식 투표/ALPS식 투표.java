import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    // 스태프의 점수 정보
    static class Score implements Comparable<Score> {
        int staffIndex;
        double value;

        Score(int staffIndex, double value) {
            this.staffIndex = staffIndex;
            this.value = value;
        }

        @Override
        public int compareTo(Score other) {
            return Double.compare(other.value, this.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalParticipants = Integer.parseInt(br.readLine());
        int totalStaff = Integer.parseInt(br.readLine());

        double cutLine = totalParticipants * 0.05;
        boolean[] isCandidate = new boolean[26];
        int[] votes = new int[26];
        int candidateCount = 0;

        for (int i = 0; i < totalStaff; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int vote = Integer.parseInt(st.nextToken());

            if (vote >= cutLine) {
                int index = name.charAt(0) - 'A';
                isCandidate[index] = true;
                votes[index] = vote;
                candidateCount++;
            }
        }

        Score[] scores = createScores(isCandidate, votes, candidateCount);
        Arrays.sort(scores);

        int[] chips = distributeChips(scores);
        System.out.print(formatResult(isCandidate, chips));
    }

    // 점수 집합 생성
    private static Score[] createScores(boolean[] isCandidate, int[] votes, int candidateCount) {
        Score[] scores = new Score[candidateCount * 14];
        int index = 0;

        for (int i = 0; i < 26; i++) {
            if (isCandidate[i]) {
                for (int divisor = 1; divisor <= 14; divisor++) {
                    scores[index++] = new Score(i, (double) votes[i] / divisor);
                }
            }
        }
        return scores;
    }

    // 상위 14개 점수에 칩 배분
    private static int[] distributeChips(Score[] scores) {
        int[] chips = new int[26];

        for (int i = 0; i < 14; i++) {
            chips[scores[i].staffIndex]++;
        }
        return chips;
    }

    // 결과 문자열 생성
    private static String formatResult(boolean[] isCandidate, int[] chips) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (isCandidate[i]) {
                sb.append((char) ('A' + i))
                        .append(' ')
                        .append(chips[i])
                        .append('\n');
            }
        }
        return sb.toString();
    }
}