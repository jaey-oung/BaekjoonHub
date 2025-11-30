import java.util.Scanner;

class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] ans = str.toCharArray(); // 문자열을 문자 배열로 변환

        for (int i = 0; i < str.length(); i++) {
            if ('a' <= ans[i] && ans[i] <= 'z') // 소문자인 경우
                ans[i] = (char)('A' + ans[i] - 'a'); // 대문자로 변환
            else // 대문자인 경우
                ans[i] = (char)('a' + ans[i] - 'A'); // 소문자로 변환
        }
        System.out.println(ans);
    }
}