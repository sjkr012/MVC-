package com.jsplec.bss.command;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bss.dao.SDao;
import com.jsplec.bss.dto.SDto;

public class sContentCommand implements SCommand {
	
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String seqno = request.getParameter("seqno");
		SDao dao = new SDao();
		SDto dto = dao.contentView(seqno);
		request.setAttribute("content_view", dto);
		
	}

}
