import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//브라우저 매핑명이 /first야
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//어떤 형식이다 -> 브라우저에게 알려줌
		//이거 안해주면 브라우저 못인식해서 잘못함
		//text/plain: 글자 그대로 일반 텍스트야 => MIME타입
		//text/html :html로 인식
		//응답해라 ("text/html;charset=UTF-8") 이런식으로
		
		//거의 쌍으로 온다고 생각하면 됨 반드시 getwriter쓰기 전에 setContentType지정해줘야 함
		//response.setContentType("text/html;charset=UTF-8");
		//PrintWriter out = response.getWriter();
		
		response.setContentType("text/html;charset=UTF-8");
		//응답을 텍스트로 하고 싶으면 getWriter
		//응답을 이미지로 하고 싶으면 response.inputStream
		//client의 출력객체 out을 활용해서 나가야 브라우저에 출력가능
		PrintWriter out = response.getWriter();//response쪽으로 writer객체를 리턴받겠어
		out.print("<h1>FirstServlet 수행 완료</h1>");//html은 개행문자를 blank하나로 인식한다. => println의미 없다
		out.print("<hr>");
		//요청 방식:GET
		out.print("<h2>요청 방식:"+ request.getMethod()+"<h2>");
		//url에다가 ?name=경선재 이렇게 주면 name에 자동으로 경선재가 나옴
		out.print("<h2>반가워요..."+ request.getParameter("name")+"님!!<h2>");
		out.close();
		//브라우저(html화면)에 전송 안함. 브라우저에 전송하려면 반드시 getwriter이용해서 보내줘야 함
		System.out.println("서블릿에서의 표쥰 출력은 어디로 나갈까용");
	}
}


