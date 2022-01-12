package base;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/flow")   
//프로젝트 context-path: edu/다음에 매핑되는 패스인 flow를 붙여주면 된다
public class FlowServlet extends HttpServlet {
	//최초 생성시 init -> service, 그 다음부터는 service만 호출
	//메모리가 해제될때 destroy
	//서버가 죽을때,, ->reload이용, 이 프로젝트의 reload ->메모리 올렸던 애들 다 내리기, 서블릿 소스 수정하고  저장하면 2초뒤 destroy수행 , 다시 실행하면 됨
	//이름이 [/edu]인 컨텍스트를 다시 로드하는 작업이 시작되었습니다.--> 메모리에서 서블릿객체 있던 애들 다 내림// 서블릿 객체가 매모리에서 사라질때 destroy실행
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출");
	} 
	public void destroy() {
		System.out.println("destroy() 호출");
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 호출");
	}

}
