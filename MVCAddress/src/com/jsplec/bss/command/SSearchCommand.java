package com.jsplec.bss.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bss.dao.SDao;
import com.jsplec.bss.dto.SDto;

public class SSearchCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String sQuery = request.getParameter("query");
		String sSearch = request.getParameter("search");
		SDao dao = new SDao();
		ArrayList<SDto> dtos = dao.searchView(sQuery,sSearch);

		request.setAttribute("search_view", dtos);
		
		
	}

}
