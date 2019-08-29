package com.jsplec.bss.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bss.dao.SDao;
import com.jsplec.bss.dto.SDto;

public class SListPageCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String curPage = request.getParameter("curPage");
		SDao dao = new SDao();
		ArrayList<SDto> dtos = dao.listPage(curPage);
		request.setAttribute("listPage", dtos);
	}

}
