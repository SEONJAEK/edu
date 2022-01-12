package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ProductVO;


@WebServlet("/fruit")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션 잇는지 없는지 확인+ 없으면 session객체 만들어줌
		//세션객체 컨테이너: 방의 역할을 할때 컨테이너라고 할수있음(session)
		//이미 브라우저당 한개씩 만들어져있는 session객체가 만들어져잇는가 찾아보는것 
		HttpSession session = request.getSession();
		//방에 해당하는 객체를 등록하는 코드(이미 등록되어있니?) 객체의 참조값을 리턴함
		if(session.getAttribute("fruit") == null) {
			//fruit이름의 객체를 만들고 그 객체의 참조값을 리턴
			session.setAttribute("fruit", new ProductVO());
		}
		//vo도 참조값임
		ProductVO vo = (ProductVO)session.getAttribute("fruit");
		String fruit_code1 = request.getParameter("pid").replace("p", "");
		int fruit_code2 = Integer.parseInt(fruit_code1);
		switch(fruit_code2) {
		case 1: vo.setApple_cnt(1);
		break;
		case 2: vo.setBanana_cnt(1);
		break;
		case 3: vo.setHanra_cnt(1);
		break;
		}
		request.getRequestDispatcher("/jspsrc/productViewEL.jsp").forward(request, response);
	}
}
