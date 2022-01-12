package base;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getpost")
public class GetPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h2>요청 방식 : "+request.getMethod()+"</h2>");
		out.print("<h2>Query 문자열 : "+
		                  request.getParameter("name")+"</h2>");
		out.close();
		System.out.println("GET 방식 수행");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		//post방식일때는 한글 안깨지려면 ((쿼리 추출천에) request.setCharacterEncoding("UTF-8")써줘야함
		//전달되는 방법의 차이이다.
		request.setCharacterEncoding("UTF-8");
		out.print("<h2>요청 방식 : "+request.getMethod()+"</h2>");
		out.print("<h2>request Parameter(요청 파라미터) : "+request.getParameter("name")+"</h2>");
		out.close();
		System.out.println("POST 방식 수행");
	}
}



