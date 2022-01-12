package base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberlocal")
public class MemberLocalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int member_v=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int local_v=0;		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//새로 고침할때마다 지역변수 member_v의 값이 10씩 증가
		//서블릿은 한번 객체 생성되면 계속 쓰인다는 것을 알 수 잇다. 
		//멤버변수는 언제 메모리에 할당돼?
		//객체 생성시 메모리에 할당된다. 
		//서버 돌아갈때까지 member변수 유지
		member_v += 10;
		//doget메서드 호출할 때마다 local_v사라졌다가 생성했다가 함
		//요청이 끝날때까지 지역변수 유지
		local_v += 10;
		out.print("<ul>");
		out.print("<li>멤버변수 : "+ member_v +"</li>");
		out.print("<li>지역변수 : "+ local_v +"</li>");
		out.print("</ul>");
		out.close();		
	}
}
