package org.example;

// static이란 (정의).. 메모리에 한번 할당되어 프로그램이 종료될때 해제
// static은요 (특징).. 객체를 생성하지 않고 static 자원에 접근이 가능
// static으로 (활용).. 모든 인스턴스가 공통으로 사용하는 변수 생성 가능 + 싱글톤 패턴 (?)

public class Static_check {
    public static int num = 0;

    public static int check_num() {
        return num;
    }

    public Static_check() {
        num++;
    }

    public static void main(String[] args) {
        System.out.println(Static_check.check_num());
        Static_check check1 = new Static_check();
        System.out.println(Static_check.check_num());
        Static_check check2 = new Static_check();
        System.out.println(Static_check.check_num());
    }
}

