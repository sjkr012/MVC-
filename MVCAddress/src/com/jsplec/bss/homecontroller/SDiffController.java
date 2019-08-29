package com.jsplec.bss.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bss.command.SCommand;
import com.jsplec.bss.command.SDeleteCommand;
import com.jsplec.bss.command.SListCommand;
import com.jsplec.bss.command.SListPageCommand;
import com.jsplec.bss.command.SSearchCommand;
import com.jsplec.bss.command.SWriteCommand;
import com.jsplec.bss.command.sContentCommand;
import com.jsplec.bss.command.sModifyCommand;


/**
 * Servlet implementation class SDiffController
 */
@WebServlet("*.s")
public class SDiffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SDiffController() {
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
		SCommand command = null; // Command Name 정의
		
		String uri = request.getRequestURI(); // URI 받기                  e.g) /MVCBoard/*.do
		String conPath = request.getContextPath(); //             e.g) MVCBoard
		String com = uri.substring(conPath.length()); //          e.g) /*.do
		
		System.out.println(uri); 
		System.out.println(conPath);
		System.out.println(com);
		
		switch(com) {
		case("/list.s"):
			command = new SListCommand();
			command.execute(request, response);
			viewPage = "list2.jsp";
			break;
		case("/write_view.s"):
			viewPage = "write_view.jsp";
			break;
		case("/write.s"):
			command = new SWriteCommand();
			command.execute(request, response);
			viewPage = "list.s";
			break;
		case("/content_view.s"):
			command = new sContentCommand();
		 	command.execute(request, response);
		 	viewPage = "content_view.jsp";
		 	break;
		case("/modify.s"):
			command = new sModifyCommand();
			command.execute(request, response);
			viewPage = "list.s";
			break;
		case("/delete.s"):
			command = new SDeleteCommand();
			command.execute(request, response);
			viewPage = "list.s";
			break;
		case("/search_view.s"):
			command = new SSearchCommand();
			command.execute(request, response);
			viewPage = "search_view.jsp";
		case("/listPage.s"): // 페이지 분할
			command = new SListPageCommand();
			command.execute(request, response);
			viewPage = "listPage.jsp";
		
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); // viewPage 받아서 날라감
		dispatcher.forward(request, response);  
	}

}
