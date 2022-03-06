package com.javalec.home;

import java.util.Scanner;

public class gugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("구구단을 진행할 숫자를 입력하세요 : ");
		int gugu = scanner.nextInt();
		
		System.out.println(gugu + "의 구단은 : " );
		for (int i = 1; i <= 9; i++) {
			System.out.println(gugu + "*" + i + " = " + gugu*i);
		}
		
		
		
	}

}
