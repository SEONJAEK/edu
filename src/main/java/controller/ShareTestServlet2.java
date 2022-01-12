package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vo.CountVO;
@WebServlet("/sharetest2")
public class ShareTestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int param = Integer.parseInt(request.getParameter("num"));
		HttpSession session = request.getSession();
		//objsession이라는 이름에 값 없니?
		if(session.getAttribute("objsession") == null) {
			session.setAttribute("objsession", new CountVO());
		}
		CountVO vo = (CountVO)session.getAttribute("objsession");
		vo.setNumber(param);
		
		//다만 객체를 언제까지 유지할거냐. 에 따라 객체 서블릿이 보관함, jsp도 하려면 하는데
		//주로 서블릿이 보관하고 jsp가 꺼내씀 그게 mvc패턴이기때문에
		request.getRequestDispatcher("/jspsrc/share2.jsp").
		              forward(request, response);
	}
}
