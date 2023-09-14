
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import obj.User;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/test")
public class ServletTouroku extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletTouroku() {
		super();

	}

	/**登録画面の表示
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("touroku.jsp");

	}

	/**確認画面えへ
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		String email = request.getParameter("email");
		String email2 = request.getParameter("email2");
		String userId = request.getParameter("u");
		String password = request.getParameter("p");
		String lastname = request.getParameter("lname");
		String firstname = request.getParameter("fname");
		String lastnameKana = request.getParameter("lname_kana");
		String firstnameKana = request.getParameter("fname_kana");

		HttpSession session = request.getSession();
		session.setAttribute("email", email);
		session.setAttribute("email2", email2);
		session.setAttribute("userId", userId);
		session.setAttribute("password", password);
		session.setAttribute("lname", lastname);
		session.setAttribute("fname", firstname);
		session.setAttribute("lnameKana", lastnameKana);
		session.setAttribute("fnameKana", firstnameKana);

		request.setAttribute("email", email);
		request.setAttribute("email2", email2);
		request.setAttribute("userId", userId);
		request.setAttribute("password", password);
		request.setAttribute("lname", lastname);
		request.setAttribute("fname", firstname);
		request.setAttribute("lnameKana", lastnameKana);
		request.setAttribute("fnameKana", firstnameKana);

		boolean isUserIdInUse = checkIfUserIdInUse(userId);

		if (isUserIdInUse) {

			request.setAttribute("userIDError", "ユーザーIDは使用されでいます");

			RequestDispatcher dispatcher = request.getRequestDispatcher("touroku.jsp");
			dispatcher.forward(request, response);
		} else {

			response.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher = request.getRequestDispatcher("kakunin.jsp");
			dispatcher.forward(request, response);
		}

	}

	private boolean checkIfUserIdInUse(String userId) {

		UserDao userDao = new UserDao();
		User user = userDao.userIdUser(userId);
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}

}