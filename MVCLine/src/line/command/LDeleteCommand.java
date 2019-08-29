package line.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import line.dao.LDao;

public class LDeleteCommand implements LCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bId = request.getParameter("bId");
		LDao dao = new LDao();
		dao.delete(bId);

	}

}
