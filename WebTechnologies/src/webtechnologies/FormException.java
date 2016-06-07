package webtechnologies;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class FormException extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		String result="";
		
		String var1 = req.getParameter("var1");
		try{
			if(var1.length()<5){
				throw new LengthException();
			}
		}
		catch(LengthException e){
			result+="<p>Длина меньше 5</p>";
		}

		try{
			Pattern p = Pattern.compile("\\W");
			Matcher m = p.matcher(var1);
			if(m.find()){
				throw new NonEnglishException();
			}
		}
		catch(NonEnglishException e){
			result+="<p>Строка содержит не только английские символы и цифры</p>";
		}
		
		resp.getWriter().println(result);

	}
}
