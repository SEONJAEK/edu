package base;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("FowardServlet 수행 시작");		
		//인터페이스임, getRequestDispatcher펙토리 메서드임, 그 뒤에 포워드할 주소를 줘. (전달할 uri)
		//현재 프로젝트의 이름을 무조건 붙여주기 때문에, 같은 프로젝트 안에 잇는 애만 사용하게 강제로 붙여버린다 그래서 나머지만 붙여줘야함
		RequestDispatcher rd = request.getRequestDispatcher("/htmlexam/first.html");// 컨텍스트패스 이후 부분을 줘야	
		//RequestDispatcher rd = request.getRequestDispatcher("http://www.naver.com/");// 컨텍스트패스 이후 부분을 줘야	
		rd.forward(request, response);	
		System.out.println("FowardServlet 수행 종료");		
	}
}






