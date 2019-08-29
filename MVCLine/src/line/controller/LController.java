package line.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import line.command.LCommand;
import line.command.LDeleteCommand;
import line.command.LListCommand;
import line.command.LWriteCommand;

/**
 * Servlet implementation class LController
 */
@WebServlet("*.com")
public class LController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("sjSystem");
		sjSystem(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("sjSystem");
		sjSystem(request, response);
	}
	private void sjSystem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("sjSystem");
		
		request.setCharacterEncoding("utf-8"); // 한글 처리
		
		String viewPage = null; // JSP File name
		LCommand command = null; // Command Name 정의
		
		String uri = request.getRequestURI(); // URI 받기                  e.g) /MVCBoard/*.do
		String conPath = request.getContextPath(); //             e.g) MVCBoard
		String com = uri.substring(conPath.length()); //          e.g) /*.do
		
		System.out.println(uri); 
		System.out.println(conPath);
		System.out.println(com);
		
		switch(com) {
		case("/list.com"):
			command = new LListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
			break;
		case("/write_view.com"):
			viewPage = "write_view.jsp";
			break;
		case("/write.com"):
			command = new LWriteCommand();
			command.execute(request, response);
			viewPage = "list.com";
			break;
		case("/delete.com"):
			command = new LDeleteCommand();
			command.execute(request, response);
			viewPage = "list.com";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); // viewPage 받아서 날라감
		dispatcher.forward(request, response);  
	}
	
	
}
