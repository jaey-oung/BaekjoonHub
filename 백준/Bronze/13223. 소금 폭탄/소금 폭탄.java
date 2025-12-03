import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String current = sc.next(); // 현재 시각
        String drop = sc.next(); // 소금 투하 시각

        String[] currentUnit = current.split(":"); // 현재 시각을 시분초로 분리
        int currentHour = Integer.parseInt(currentUnit[0]); // 현재 시
        int currentMinute = Integer.parseInt(currentUnit[1]); // 현재 분
        int currentSecond = Integer.parseInt(currentUnit[2]); // 현재 초
        int currentSecondAmount = currentHour * 3600 + currentMinute * 60 + currentSecond; // 현재 시각을 초로 변환

        String[] dropUnit = drop.split(":"); // 소금 투하 시각을 시분초로 분리
        int dropHour = Integer.parseInt(dropUnit[0]); // 투하 시
        int dropMinute = Integer.parseInt(dropUnit[1]); // 투하 분
        int dropSecond = Integer.parseInt(dropUnit[2]); // 투하 초
        int dropSecondAmount = dropHour * 3600 + dropMinute * 60 + dropSecond; // 투하 시각을 초로 변환

        int diffSecondAmount = dropSecondAmount - currentSecondAmount; // 초 단위로 차이 계산

        if (diffSecondAmount <= 0) // 0 이하면
            diffSecondAmount += 24 * 3600; // 24시간 더하기

        int diffHour = diffSecondAmount / 3600; // 초를 시간으로 변환
        int diffMinute = (diffSecondAmount % 3600) / 60; // 나머지를 분으로 변환
        int diffSecond = diffSecondAmount % 60; // 나머지가 초
        System.out.printf("%02d:%02d:%02d", diffHour, diffMinute, diffSecond);
    }
}