package java_3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Java_3Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		switch (req.getParameter("my_some_parameter")) {
		case "1":
			case_1(resp);
			break;
		case "2":
			case_2(req, resp);
			break;
		case "3":
			case_3(req, resp);
			break;
		case "4":
			case_4(req, resp);
			break;
		}
		/*
		 * Enumeration mytests = req.getParameterNames(); String[] test = { ""
		 * }; List<String> zoom = new ArrayList<>(); try { while
		 * (mytests.hasMoreElements()) {
		 * zoom.add(mytests.nextElement().toString()); } } catch
		 * (NoSuchElementException n) {
		 * 
		 * } resp.getWriter().println(" содержимое " + mytests.toString());
		 * 
		 * for (String z1 : zoom) {
		 * resp.getWriter().println(" /n Элемент mytests " + z1); }
		 */
	}

	void case_1(HttpServletResponse resp) throws IOException {
		// типы данных
		byte b = 127;
		resp.getWriter().println(b);

		short s = 32767;
		resp.getWriter().println(s);

		int i = 999999999;
		resp.getWriter().println(i);

		// для чисел типа long обязательно добавлять 'l'
		long l = 100l;
		resp.getWriter().println(l);

		// символьный тип данных
		char c2 = 'c';
		char c3 = 1200;
		resp.getWriter().println(c2);
		resp.getWriter().println(c3);

		// в шестнадцатиричной системе счисления
		char c = 0x0770;
		resp.getWriter().println(c);

		/*
		 * //вывод символов for (char c1 = 1200; c1<1300;c1++){
		 * resp.getWriter().print(c1+" "); if ((c1 % 10)==0){
		 * resp.getWriter().println("==="); } }
		 */

		// приведение типов
		resp.getWriter().println((int) c);

		int h = 3, g = 2;
		resp.getWriter().println(h / g);
		resp.getWriter().println((float) h / g);

		float h1 = 30000000000000000.0f, g1 = 2;
		resp.getWriter().println(h1 / g1);
		resp.getWriter().println((int) (h1 / g1));

		resp.getWriter().println();
		float f = 100000000000000000000000000000000000000.0f;
		resp.getWriter().println(f);
		double googol = 1e100;
		double d = 1100.34;
		boolean bool = true;

		// escape-символы
		resp.getWriter().println(googol);
		resp.getWriter().print("Перенос строки" + "\n");

		// условный оператор switch
		int x = 1, y = 2, z, operation = 0;

		switch (operation) {
		case 0:
			z = x + y;
			break;
		case 1:
			z = x - y;
			break;
		case 2:
			z = x * y;
			break;
		default:
			z = x / y;
		}
		resp.getWriter().println("Результат выполнения операции: " + z);

		// цикл for
		long factorial = 1;
		for (l = 1l; l < 10; l++) {
			factorial *= l;
		}
		resp.getWriter().println(factorial);

		// массивы
		int[] m1;
		int[] m2 = new int[5];
		int[] m3 = { 1, 2, 3 };
		resp.getWriter().println(m3[0]);

		int[][] m4;
		int[][] m5 = { { 1, 2 }, { 2 } };
		resp.getWriter().println(m5[0][0]);

		String[] str = new String[4];
		String[] seasons = { "Зима", "Весна", "Лето", "Осень" };

		for (i = 0; i < seasons.length; i++) {
			resp.getWriter().println(seasons[i]);
		}

		double dd = Math.random();
		resp.getWriter().println(dd);

		int random = (int) (dd * 100);
		resp.getWriter().println(random);
	}

	void case_2(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		double int_m = Double.parseDouble(req.getParameter("ex_1_integer_m"));
		double int_n = Double.parseDouble(req.getParameter("ex_1_integer_n"));
		if (abs(int_m - 10) < abs(int_n - 10)) {
			resp.getWriter().println(
					" Число " + int_m + " ближе к 10 чем " + int_n);
		} else {
			resp.getWriter().println(
					" Число " + int_n + " ближе к 10 чем " + int_m);
		}
	}

	void case_3(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		int i;
		int j;
		int r;
		resp.getWriter().println("<table border=\"1\">");
		for (i = 0; i < 8; i++) {
			resp.getWriter().println("<tr>");
			for (j = 0; j < 5; j++) {
				r = (int) (Math.random() * 100);
				if (r < 10) {
					r = 10;
				}
				resp.getWriter().println("<td>" + r + "</td>");
			}
			resp.getWriter().println("</tr>");
		}
		resp.getWriter().println("</table>");
	}

	void case_4(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		int i;
		int j;
		int r;
		resp.getWriter().println("<table border=\"1\">");
		for (i = 0; i < 8; i++) {
			resp.getWriter().println("<tr>");
			for (j = 0; j < 5; j++) {
				r = (int) (Math.random() * 10);
				if (r < 5) {
					r = -(int) (Math.random() * 100);
				} else {
					r = (int) (Math.random() * 100);
				}
				resp.getWriter().println("<td>" + r + "</td>");
			}
			resp.getWriter().println("</tr>");
		}
		resp.getWriter().println("</table>");
	}

	private double abs(double d) {
		// TODO Auto-generated method stub
		if (d < 0) {
			return d * (-1);
		} else {
			return d;
		}
	}
}