package line.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import line.dao.LDao;
import line.dto.LDto;

public class LListCommand implements LCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		LDao dao = new LDao();
		ArrayList<LDto> dtos = dao.list();
		request.setAttribute("list", dtos);
	}

}
