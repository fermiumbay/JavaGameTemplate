package javaGameTemplate;

//サンプル
//学生要素を管理し、スコアが合格点（60点）に満たない学生は削除される

import java.util.ArrayList;
import java.util.List;

import javaGameTemplate.System.BaseManager;

class Student extends BaseManager {
	public int id;
	public int score;

	public void update() {
		if (score < 60) {
			clear();
		}
	}

	public Student(int id, int score) {
		this.id = id;
		this.score = score;
	}
}

class StudentManager extends BaseManager {
	public List<Student> students = new ArrayList<Student>();

	public void add(Student student) {
		students.add(student);
	}

	public void show() {
		for (Student student : students) {
			System.out.println("学生" + student.id + " スコア:" + student.score);
		}
	}

	public void update() {
		for (Student student : students) {
			student.update();
		}
	}
}

public class Test {

	public static void main(String args[]) {
		StudentManager sm = new StudentManager();

		// 学生を追加していく
		sm.add(new Student(1, 80));
		sm.add(new Student(2, 50));
		sm.add(new Student(3, 75));
		sm.add(new Student(4, 25));
		sm.add(new Student(5, 40));

		// 学生の情報を表示（5人いる）
		sm.show();

		// テストの結果を反映
		sm.update();

		// リストの更新
		BaseManager.allRefresh(sm.students);

		// 再度学生を表示（2人に減っている）
		sm.show();
	}
}
