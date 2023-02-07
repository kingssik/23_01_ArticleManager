package com.KoreaIT.java.AM;

import java.util.Scanner;

import com.KoreaIT.java.AM.controller.ArticleController;
import com.KoreaIT.java.AM.controller.Controller;
import com.KoreaIT.java.AM.controller.MemberController;

public class App {

	public App() {

	}

	public void start() {
		System.out.println("== 프로그램 시작 == ");

		Scanner sc = new Scanner(System.in);
		MemberController memberController = new MemberController(sc);
		ArticleController articleController = new ArticleController(sc);

		articleController.makeTestData();
		memberController.makeTestData();

		while (true) {
			System.out.printf("명령어 ) ");
			String cmd = sc.nextLine().trim();

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력하세요");
				continue;
			}

			if (cmd.equals("system exit")) {
				break;
			}

			String[] cmdBits = cmd.split(" ");

			if (cmdBits.length == 1) {
				System.out.println("존재하지 않는 명령어입니다");
				continue;
			}

			String controllerName = cmdBits[0];
			String actionMehtodName = cmdBits[1];

			Controller controller = null;

			if (controllerName.equals("article")) {
				controller = articleController;
			} else if (controllerName.equals("member")) {
				controller = memberController;
			} else {
				System.out.println("존재하지 않는 명령어입니다");
				continue;
			}

			controller.doAction(cmd, actionMehtodName);
		}

		sc.close();

		System.out.println("== 프로그램 종료 == ");
	}

}
