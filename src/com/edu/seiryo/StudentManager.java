package com.edu.seiryo;

import java.util.Scanner;

public class StudentManager {
	// scannerを作る
	Scanner scanner = new Scanner(System.in);
	// 学生の情報を記録する配列
	Student[] students = new Student[5];
	// 学生のデータを記録
	{
		students[0] = new Student(1, "张三", "男", 20, "11301");
		students[1] = new Student(2, "李四", "男", 21, "11302");
		students[2] = new Student(3, "王五", "男", 20, "11301");
		students[3] = new Student(4, "麻六", "男", 19, "11301");
		students[4] = new Student(5, "赵七", "男", 18, "11301");
	}
	
	public static void main(String[] args) {
			
			
			// accountsという配列を宣言（アカウントの情報を記録するため）
			String[][] accounts = new String[10][2];
			// countAccountsという整数型の変数を宣言（アカウントの数量を記録するため）
			int countAccounts = 0;
			
			// choiceという文字列型の変数を宣言（ユーザーのインプットを記録するため）
			String choice;
			// bo1というブーリアン型の変数を宣言（メインプログラムをループするかと記録するため）
			boolean bo1;
			do {
				bo1 = false;
				// 登録・ログイン画面の選択肢をプリント
				System.out.println("欢迎使用青凌学生管理系统");
				System.out.println("--------------------------------------------");
				System.out.println("1.注册");
				System.out.println("2.登录");
				System.out.println("--------------------------------------------");
				System.out.println("请选择[1/2]：");
				// ユーザーが数字を入力し、登録機能とログイン機能を選択
				choice = scanner.next();
				String id, pwd;
				if (choice.equals("1")) {
					// １が入力されたら、登録機能に入る
					// bo2というブーリアン型の変数を宣言（登録機能をループするかと記録するため）
					boolean bo2;
					do {
						bo2 = false;
						// ユーザーが名前を入力
						System.out.println("请输入注册账号：");
						id = scanner.next();
						// 名前のフォーマットが正しいかと判断
						char firstName = id.charAt(0);
						char lastName = id.charAt(id.length() - 1);
						if ((firstName >= 65 && firstName <= 90) && (lastName >= 33 && lastName <= 47)) {
							// 名前のフォーマットが正しい場合、ifに入り
							// bo3というブーリアン型の変数を宣言（パスワード入力をループするかと記録するため）
							boolean bo3;
							do {
								bo3 = false;
								// ユーザがパスワードを入力
								System.out.println("请输入注册密码：");
								pwd = scanner.next();
								// パスワードのフォーマットが正しいかと判断
								firstName = pwd.charAt(0);
								lastName = pwd.charAt(pwd.length() - 1);
								if ((firstName >= 65 && firstName <= 90) && (lastName >= 33 && lastName <= 47)) {
									accounts[countAccounts][0] = id;
									accounts[countAccounts][1] = pwd;
									countAccounts++;
									if (countAccounts == 10) {
										countAccounts = 0;
									}
									// パスワードのフォーマットが正しい場合、登録成功
									System.out.println("注册成功！");
									bo1 = true;
								} else {
									// パスワードのフォーマットが正しくない場合、また入力させる
									System.out.println("输入错误。第一个字符须为大写字母，最后一个字符须为特殊符号。");
									bo3 = true;
								}
							} while(bo3);
						} else {
							// 名前のフォーマットが正しくない場合、また入力させる
							System.out.println("输入错误。第一个字符须为大写字母，最后一个字符须为特殊符号。");
							bo2 = true;
						}
					} while(bo2);
				} else if (choice.equals("2")) {
					// ２が入力されたら、ログイン画面に入る
					// bo4というブーリアン型の変数を宣言（ログインしたかと記録するため）
					boolean bo4 = false;
					// ログイン失敗の数を記録する整数型の変数を宣言
					int failure = 0;
					do {
						// まず、ユーザーが名前とパスワードを入力
						System.out.println("请输入登录账号："); 
						id = scanner.next();
						System.out.println("请输入登录密码：");
						pwd = scanner.next();
						for (int i = 0; i < accounts.length; i++) {
							if (id.equals(accounts[i][0]) && pwd.equals(accounts[i][1])) {
								// 一致する場合、ログイン成功を記録する
								bo4 = true;
							}
						}
						if (bo4) {
							System.out.println("登陆成功");
						} else {
							// ログイン失敗の場合
							System.out.println("登陆失败");
							// 失敗数が増加
							failure++;
							if (failure == 3) {
								// ３回失敗したら、システム終了
								System.out.println("已失败3次，系统即将自动退出");
								System.exit(0);
							} else {
								// ３回に達したら、システム終了の通知をプリント
								System.out.println("已失败" + failure + "次，失败3次系统会自动退出");
							}
						}
					} while (!bo4);
				} else {
					// １と２以外の文字が入力されたら、また入力させる
					System.out.println("输入错误，请重新输入。");
					bo1 = true;
				}
			} while (bo1);
					
			// メインメニュー
			do {
				// メインメニューをプリント
				System.out.println("欢迎使用青凌学生管理系统");
				System.out.println("--------------------------------------------");
				System.out.println("1.显示所有学生信息");
				System.out.println("2.根据编号查询学生信息");
				System.out.println("3.根据编号修改学生年龄");
				System.out.println("4.根据姓名修改学生班级");
				System.out.println("5.根据班级查询全部学生信息");
				System.out.println("--------------------------------------------");
				// ユーザーが入力して選ぶ
				System.out.println("请选择[1/2/3/4/5]：");
				choice = scanner.next();

				// 文字列型の変数を宣言（ユーザーが次のプログラムに、「続くかどうか」という質問にyかnを答えることを記録するため）
				String flag;
				// switchを使って、ユーザーの選択を実行
				switch (choice) {
				// １が入力されたら、学生情報一覧機能
				case "1":
					do {
						// 学生の情報をプリント
						System.out.println("--------------------------------------------");
						System.out.println("编号\t姓名\t性别\t年龄\t班级");
						for (int i = 0; i < students.length; i++) {
							Student student = students[i];
							System.out.print(student.getId() + "\t");
							System.out.print(student.getName() + "\t");
							System.out.print(student.getGender() + "\t");
							System.out.print(student.getAge() + "\t");
							System.out.println(student.getClassNumber() + "\t");
						}
						System.out.println("--------------------------------------------");
						// ユーザーが続きたいと、yを入力
						System.out.println("是否继续[y/n]：");
						flag = scanner.next();
					} while ("y".equals(flag));			
					break;
				// ２が入力されたら、学生情報検索機能
				case "2":
					do {
						// ユーザーが検索したい番号を入力
						System.out.println("请输入需要查询的编号：");
						int id = scanner.nextInt();
						// ブーリアン型の変数を宣言（一致する番号が存在するかと記録するため）
						boolean bo5 = true;
						System.out.println("--------------------------------------------");
						// 一致する情報をプリント
						for (int i = 0; i < students.length; i++) {
							Student student = students[i];
							if (id == student.getId()) {
								System.out.println("编号\t姓名\t性别\t年龄\t班级");
								System.out.print(student.getId() + "\t");
								System.out.print(student.getName() + "\t");
								System.out.print(student.getGender() + "\t");
								System.out.print(student.getAge() + "\t");
								System.out.println(student.getClassNumber() + "\t");
								// 一致する情報が存在すると、記録
								bo5 = false;
							}
						}
						if (bo5) {
							// 学生が存在しない場合、通知
							System.out.println("该学生信息不存在");
						}
						System.out.println("--------------------------------------------");
						// ユーザーが続きたいと、yを入力
						System.out.println("是否继续[y/n]：");
						flag = scanner.next();
					} while ("y".equals(flag));
					break;
				// ３が入力されたら、学生番号によって年齢を修正する機能
				case "3":
					do {
						// ユーザーが検索したい番号を入力
						System.out.println("请输入需要查询的编号：");
						int id = scanner.nextInt();
						// ブーリアン型の変数を宣言（一致する番号が存在するかと記録するため）
						boolean bo6 = true;
						System.out.println("--------------------------------------------");
						// 一致する情報をプリント
						for (int i = 0; i < students.length; i++) {
							Student student = students[i];
							if (id == student.getId()) {
								System.out.println("编号\t姓名\t性别\t年龄\t班级");
								System.out.print(student.getId() + "\t");
								System.out.print(student.getName() + "\t");
								System.out.print(student.getGender() + "\t");
								System.out.print(student.getAge() + "\t");
								System.out.println(student.getClassNumber() + "\t");
								System.out.println("--------------------------------------------");
								// ユーザーが年齢の修正を入力
								System.out.println("请输入要将年龄修改为：");
								int edit = scanner.nextInt();
								// 年齢の修正を実行
								students[i].setAge(edit);
								// 一致する情報が存在すると、記録
								bo6 = false;
							}
						}
						if (bo6) {
							// 学生が存在しない場合、通知
							System.out.println("该学生信息不存在");
							System.out.println("--------------------------------------------");
						}
						// ユーザーが続きたいと、yを入力
						System.out.println("是否继续[y/n]：");
						flag = scanner.next();
					} while (flag.equals("y"));
					break;
				// ４が入力されたら、学生名前によってクラス番号を修正する機能
				case "4":
					do {
						// ユーザーが検索したい名前を入力
						System.out.println("请输入需要查询的姓名：");
						String name = scanner.next();
						// ブーリアン型の変数を宣言（一致する名前が存在するかと記録するため）
						boolean bo7 = true;
						System.out.println("--------------------------------------------");
						// 一致する情報をプリント
						for (int i = 0; i < students.length; i++) {
							Student student = students[i];
							if (name.equals(student.getName())) {
								System.out.println("编号\t姓名\t性别\t年龄\t班级");
								System.out.print(student.getId() + "\t");
								System.out.print(student.getName() + "\t");
								System.out.print(student.getGender() + "\t");
								System.out.print(student.getAge() + "\t");
								System.out.println(student.getClassNumber() + "\t");
								System.out.println("--------------------------------------------");
								// ユーザーがクラス番号の修正を入力
								System.out.println("请输入要将班级修改为：");
								String edit = scanner.next();
								// 年齢の修正を実行
								students[i].setClassNumber(edit);
								// 一致する情報が存在すると、記録
								bo7 = false;
							}
						}
						if (bo7) {
							// 学生が存在しない場合、通知
							System.out.println("该学生信息不存在");
							System.out.println("--------------------------------------------");
						}
						// ユーザーが続きたいと、yを入力
						System.out.println("是否继续[y/n]：");
						flag = scanner.next();
					} while (flag.equals("y"));
					break;
				// ５が入力されたら、クラス番号によって学生情報を検索する機能
				case "5":
					do {
						System.out.println("请输入需要查询的班级号：");
						int classNumber = scanner.nextInt();
						// ブーリアン型の変数を宣言（一致するクラス番号が存在するかと記録するため）
						boolean bo8 = true;
						System.out.println("--------------------------------------------");
						
						// 整数型の変数を宣言（テーブルのヘッドを一回だけプリントするため）
						int printed = 0;
						// 一致する情報をプリント開始
						for (int i = 0; i < students.length; i++) {
							Student student = students[i];
							if (classNumber == Integer.parseInt(student.getClassNumber())) {
								if (printed == 0) {
									System.out.println("编号\t姓名\t性别\t年龄\t班级");
									// テーブルのヘッドが既にプリントされたことを記録
									printed = 1;
								}
								System.out.print(student.getId() + "\t");
								System.out.print(student.getName() + "\t");
								System.out.print(student.getGender() + "\t");
								System.out.print(student.getAge() + "\t");
								System.out.println(student.getClassNumber() + "\t");
								// 一致する情報が存在すると、記録
								bo8 = false;
							}
						}
						if (bo8) {
							// 学生が存在しない場合、通知
							System.out.println("该学生信息不存在");
						}
						System.out.println("--------------------------------------------");
						// ユーザーが続きたいと、yを入力
						System.out.println("是否继续[y/n]：");
						flag = scanner.next();
					} while (flag.equals("y"));
					break;
				default:
					// デフォールト（１から５以外の文字が入力されたら、また入力させる）
					System.out.println("输入错误，请重新输入");
				}			
			} while (true);
	}
}
