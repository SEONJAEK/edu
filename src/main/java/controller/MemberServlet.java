package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.MemberVO;


@WebServlet("/inform1")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected static String format(String str) {
		return str.replaceFirst("([0-9]{3})([0-9]{4})([0-9]{4})$", "$1-$2-$3");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html;charset=utf-8");// 왜 안써줘도돼?
		request.setCharacterEncoding("UTF-8");//post방식으로 전달 쿼리 쿼리 안에 한글 있을 수 있으니 추출하기전에 꼭 써줘야 함
		
		
		String name = request.getParameter("name");
		String phone =request.getParameter("phone");
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		
		//null이거나 null문자열이면,,,!
		if(name.equals("")|| name==null) 
			name= "없음";
		if(phone.equals("")|| phone==null) 
			phone= "없음";
		if(account.equals("")|| account==null) 
			account= "없음";
		if(passwd.equals("")|| passwd==null) 
			passwd= "없음";
		
		MemberVO vo = new MemberVO();
		vo.setAccount(account);
		vo.setName(name);
		vo.setPhone(MemberServlet.format(phone));
		vo.setPasswd(passwd);
		
		request.setAttribute("member", vo);
		request.getRequestDispatcher("/jspsrc/memberViewEL.jsp").forward(request, response);
	}
}
