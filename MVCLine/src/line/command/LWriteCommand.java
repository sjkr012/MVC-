package line.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import line.dao.LDao;

public class LWriteCommand implements LCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bName = request.getParameter("name");
		String bTitle = request.getParameter("telno");
		
		LDao dao = new LDao();
		
		dao.write(bName, bTitle);

	}

}
