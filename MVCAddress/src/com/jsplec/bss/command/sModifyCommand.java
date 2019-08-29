package com.jsplec.bss.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bss.dao.SDao;

public class sModifyCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		

		String seqno = request.getParameter("seqno");
		String name = request.getParameter("name");
		String telno = request.getParameter("telno");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String relation = request.getParameter("relation");
		
		SDao dao = new SDao();
		dao.modify(seqno, name, telno, address, email, relation);

	}

}
