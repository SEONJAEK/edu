package base;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/lotto2")
public class LottoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		RequestDispatcher rd1 = request.getRequestDispatcher("/jspsrc/success.jsp");
		RequestDispatcher rd2 = request.getRequestDispatcher("/jspsrc/fail.jsp");
		RequestDispatcher rd3 = request.getRequestDispatcher("/jspsrc/impossible.jsp");
		//세션객체를 준비한다
		HttpSession session = request.getSession();
		if (session.getAttribute("cnt") == null) {
			
			//integer객체로 쓸 때에는 값을 변경하기 어렵다.
			session.setAttribute("cnt", new int[1]);
		}
		int number = Integer.parseInt(request.getParameter("number"));
		int random = (int) (Math.random() * 6) + 1;
		System.out.printf("전달된 값: %d, 추출된 값: %d%n", number, random);
		int[] data = (int[]) session.getAttribute("cnt");
		
		if (number == random && data[0]!=3) {
			data[0] = 3;
			rd1.forward(request, response);
		} else if(number!= random && data[0]!=3) {
			data[0]++;
			rd2.forward(request, response);
		} else {
			rd3.forward(request, response);
		}
	}
}






