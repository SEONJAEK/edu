package controller;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.CountVO;
@WebServlet("/sharetest3")
public class ShareTestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int param = Integer.parseInt(request.getParameter("num"));
		//서버 죽을때까지 보관함, 어느 브라우저이든지,getServletContext()는 자손 클래스에서 부모클래스(httprequest?) 호출하는 거임
		// 톰캣서버가 기동될때 edu를 위해 참조값을 리턴해주는 메소드
		// 다만 언제까지 유지되느냐가 다름 크래스는 각각 다르지만 
		// 이거 펙토리 메서드임?
		ServletContext context = getServletContext();
		if(context.getAttribute("objapp") == null) {
			context.setAttribute("objapp", new CountVO());
		}
		CountVO vo = (CountVO)context.getAttribute("objapp");
		vo.setNumber(param);
		
		request.getRequestDispatcher("/jspsrc/share3.jsp").
		              forward(request, response);
	}
}
