package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int result = 0;
		String n1 = request.getParameter("num1");
		String n2 = request.getParameter("num2");
		int num1 = Integer.parseInt(n1);
		int num2 = Integer.parseInt(n2);
		String sign = request.getParameter("sign");
		if(n1 == null || n2 == null || n1.equals("")||n2.equals("")) {
			request.getRequestDispatcher("/jspsrc/errorResult.jsp").forward(request, response);
		}else if (num2 == 0 && sign.equals("/")) {
			String error = "나눗셈 연산시 두 번째 숫자는 0일 수 없습니다!!";
			request.setAttribute("message", error);
			request.getRequestDispatcher("/jspsrc/errorResult.jsp").forward(request, response);
		}else {
			switch(sign) {
			case "+":
				result = num1+num2;
				break;
			case "-":
				result = num1-num2;
				break;
			case "*":
				result = num1*num2;
				break;
			case "/":
				result = num1/num2;
				break;
			}
			request.setAttribute("result", result);
			request.getRequestDispatcher("/jspsrc/calcResultEL.jsp").forward(request, response);
		}
	}
}
