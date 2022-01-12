package base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/query")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String p1 = request.getParameter("p1");//null
		int p2 = Integer.parseInt(request.getParameter("p2"));//request.getParameter: String 으로 반환, null을 int로 변환하는 작업 -> 변환할 데이터가 없어서 에러.
		String p3[] = request.getParameterValues("p3");//null이 아니라 비어있는 배열을 반환함
		out.print("<ul>");
		out.print("<li>p1 : "+ p1 +"</li>");
		out.print("<li>p2 : "+ p2 +"</li>");
		for(int i=0; i < p3.length; i++)
			out.print("<li>p3["+i+"] : "+ p3[i] +"</li>");
		out.print("</ul>");
		//a테그: 하이퍼링크 만들어주는 테그
		out.print("<a href='/edu/htmlexam/queryservlettest.html'>입력화면으로</a>");
		out.close();		
	}
}




