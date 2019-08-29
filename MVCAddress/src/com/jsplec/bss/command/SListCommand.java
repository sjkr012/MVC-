package com.jsplec.bss.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bss.dao.SDao;
import com.jsplec.bss.dto.SDto;



public class SListCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		

		SDao dao = new SDao();
		ArrayList<SDto> dtos = dao.list();
		request.setAttribute("list", dtos);

	}

}
