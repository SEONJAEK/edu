package base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.printf("<h1>선택한 상품: %s</h1>", request.getParameter("pid"));
		String value = request.getParameter("pid");
		int v = Integer.parseInt(value.substring(1,4));
		out.print("<img src=\"/edu/images/"+v+".png\"/>");
		out.print("<hr>");
		out.print("<a href=\"/edu/htmlexam/productlog.html\">상품 선택 화면</a>");
		out.print("<hr><a href='"+ request.getHeader("referer")+"'>상품 선택 화면</a>");
	}
}
