package gov.cygs.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestSevlet
 */
@WebServlet(
		urlPatterns = { "/TestSevlet" }, 
		initParams = { 
				@WebInitParam(name = "language", value = "chinese", description = "no comment")
		})
public class TestSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String language;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.language = config.getInitParameter("language");
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(language==null || !language.equals("chinese"))
		{
			response.getWriter().append("hello world!");
		}else{
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append("世界，你好!");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
