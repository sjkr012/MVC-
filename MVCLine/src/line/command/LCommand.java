package line.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LCommand {

	public void execute(HttpServletRequest request, HttpServletResponse response);
}
