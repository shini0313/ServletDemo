
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/test")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		// 重定向到另一个页面
		response.sendRedirect("res.jsp");
		//request.getRequestDispatcher("result.jsp").forward(request, response);

		// 或者使用转发到另一个页面

		// request.getRequestDispatcher("page2.jsp").forward(request, response);
	}

	//
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html;charset=UTF-8");
		String email = request.getParameter("email");
		String email2 = request.getParameter("email2");
		String userID = request.getParameter("u");
		String password = request.getParameter("p");
		String lname = request.getParameter("lname");
	    String fname = request.getParameter("fname");
	    String lnameKana = request.getParameter("lname_kana");
	    String fnameKana = request.getParameter("fname_kana");

		request.setAttribute("email", email);
		request.setAttribute("email2", email2);
		request.setAttribute("userID", userID);
		request.setAttribute("password", password);
		request.setAttribute("lname", lname);
		request.setAttribute("fname", fname);
		request.setAttribute("lnameKana", lnameKana);
		request.setAttribute("fnameKana", fnameKana);
		
		
		System.out.println("Email: " + email);
		System.out.println("Confirm Email: " + email2);
		System.out.println("User ID: " + userID);
		System.out.println("Password: " + password);
		System.out.println("Last Name: " + lname);
		System.out.println("First Name: " + fname);
		System.out.println("Last Name (Kana): " + lnameKana);
		System.out.println("First Name (Kana): " + fnameKana);
		//request.getRequestDispatcher("kakunin.jsp").forward(request, response);

		// 请求转发到另一个 JSP 页面
		response.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("kakunin.jsp");
		dispatcher.forward(request, response);
	}

}
