package base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lotto1")
public class LottoServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int number = Integer.parseInt(request.getParameter("number"));
		int random = (int)(Math.random()*6)+1;
		System.out.printf("전달된 값: %d, 추출된 값: %d%n", number, random);
		if (number == random ){
			RequestDispatcher rd = request.getRequestDispatcher("/htmlexam/succcess.html");
			rd.forward(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/htmlexam/fail.html");
			rd.forward(request, response);
			out.close();
		}
	}
}
