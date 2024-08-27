import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
[BOJ] 2504 괄호의 값
11524KB | 	64ms
목표 : 주어진 괄호열을 읽고, 그 괄호값을 계산
=> 만약 올바르지 못한 괄호열이면 0출력
풀이 : 분배 법칙 이용
1. (,[ 일 때 stack에 넣기 &  2 ,3 곱하기
2. ). ] 일 때 /2, /3 하기
    - 바로 직전 값이 (,[ 이면 더하기
*/
public class B2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int tmp = 1;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '('){
                stack.push(c);
                tmp *= 2;
            }
            else if(c == '['){
                stack.push(c);
                tmp *= 3;
            }
            // 닫는 괄호
            else{
                if(stack.isEmpty()){
                    answer = 0;
                    break;
                }
                if(c == ')'){
                    if(stack.peek() != '('){
                        answer = 0;
                        break;
                    }
                    if(str.charAt(i-1) == '('){
                        answer += tmp;
                    }
                    stack.pop();
                    tmp /= 2;
                }
                else{
                    if(stack.peek() != '['){
                        answer = 0;
                        break;
                    }
                    if(str.charAt(i-1) == '['){
                        answer += tmp;
                    }
                    stack.pop();
                    tmp /= 3;
                }
            }


        }
        if(!stack.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(answer);
        }
    }
}
