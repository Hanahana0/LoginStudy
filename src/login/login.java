package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		String id = request.getParameter("u_id");
		String pw = request.getParameter("u_pw");
		String msg = "";

		System.out.println("id:" +id + " pw:"+pw);
		
		if(id == null || id.equals("") || pw == null || pw.equals("")) {
			//�α��� ����
			request.getSession().setAttribute(msg, "���̵�� ��й�ȣ�� Ȯ�����ּ���");
			response.sendRedirect("login.html");
			System.out.println("�α��μ���");
			return;
		}
		
		
		if( id == "admin" && pw == "1234"){
			//�α��� ����
			System.out.println("�α��μ���");
			request.getSession().setAttribute(msg, "�α��� ����<br/>"+id+"�� �ȳ��ϼ���");
			response.sendRedirect("login.html");
			return;
		}
		
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
