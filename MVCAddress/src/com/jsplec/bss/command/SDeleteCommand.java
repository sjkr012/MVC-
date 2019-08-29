package com.jsplec.bss.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bss.dao.SDao;

public class SDeleteCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String seqno = request.getParameter("seqno");
		SDao dao = new SDao();
		dao.delete(seqno);

	}

}
