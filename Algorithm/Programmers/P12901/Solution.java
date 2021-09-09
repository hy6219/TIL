package programmers.P12901;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Solution {

    //calendar는 매달-1
//윤년
    static String[] days={"","SUN","MON","TUE","WED","THU","FRI","SAT"};

    public static String solution(int a, int b) {
        String answer = "";
        LocalDate date=LocalDate.of(2016,a,b);
        DayOfWeek dayOfWeek =date.getDayOfWeek();
        String temp=String.valueOf(dayOfWeek);

        switch (temp){
            case "SUNDAY":
                answer=days[1];
                break;
            case "MONDAY":
                answer=days[2];
                break;
            case "TUESDAY":
                answer=days[3];
                break;
            case "WEDNESDAY":
                answer=days[4];
                break;
            case "THURSDAY":
                answer=days[5];
                break;
            case "FRIDAY":
                answer=days[6];
                break;
            case "SATURDAY":
                answer=days[7];
                break;
        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(5,24));
    }

}
