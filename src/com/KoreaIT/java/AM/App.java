package com.KoreaIT.java.AM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.AM.controller.ArticleController;
import com.KoreaIT.java.AM.controller.MemberController;
import com.KoreaIT.java.AM.dto.Article;
import com.KoreaIT.java.AM.dto.Member;
import com.KoreaIT.java.AM.util.Util;

public class App {
	private List<Article> articles;
	private List<Member> members;

	public App() {
		articles = new ArrayList<>();
		members = new ArrayList<>();
	}

	public void start() {
		System.out.println("== 프로그램 시작 == ");

		makeTestData();

		Scanner sc = new Scanner(System.in);
		MemberController memberController = new MemberController(members, sc);
		ArticleController articleController = new ArticleController(articles, sc);

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

			if (cmd.equals("member join")) {
				memberController.doJoin();
			} else if (cmd.equals("article write")) {
				articleController.doWrite();
			} else if (cmd.startsWith("article list")) {
				articleController.showList(cmd);
			} else if (cmd.startsWith("article detail ")) {
				articleController.showDetail(cmd);
			} else if (cmd.startsWith("article modify ")) {
				articleController.doModify(cmd);
			} else if (cmd.startsWith("article delete ")) {
				articleController.doDelete(cmd);
			} else {
				System.out.println("없는 명령어입니다");
			}
		}

		sc.close();

		System.out.println("== 프로그램 종료 == ");
	}

	private void makeTestData() {
		System.out.println("테스트를 위한 데이터를 생성합니다");
		articles.add(new Article(1, Util.getNowDateStr(), "title 1", "body 1", 11));
		articles.add(new Article(2, Util.getNowDateStr(), "title 2", "body 2", 22));
		articles.add(new Article(3, Util.getNowDateStr(), "title 3", "body 3", 33));
	}

}
