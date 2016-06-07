package webtechnologies.openData;

import java.io.IOException;
import javax.servlet.http.*;


public class FindNearestWIFI extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		String var1 = req.getParameter("var1");
		double i1 = Double.parseDouble(var1);
		
		String var2 = req.getParameter("var2");
		double i2 = Double.parseDouble(var2);
		
		Wifi[] array=ParseOpenData.Parse();
		double difference;
		int i;
		Wifi nearestWifi=array[0];
		difference=Math.abs(array[0].getLatitude()-i2)+Math.abs(array[0].getLongitude()-i1);
		for(i=1;i<array.length;i++){
			if(difference>Math.abs(array[i].getLatitude()-i2)+Math.abs(array[i].getLongitude()-i1)){
				difference=Math.abs(array[i].getLatitude()-i2)+Math.abs(array[i].getLongitude()-i1);
				nearestWifi=array[i];
			}
		}
		resp.getWriter().println("<table border=\"1\"><tr><td>Порядковый номер</td><td>Название</td><td>Адрес</td><td>Зона покрытия</td><td>Долгота</td><td>Широта</td><td>Место расположения</td><tr>");
		resp.getWriter().println("<tr><td>"+nearestWifi.getIndex()+"</td><td>"+nearestWifi.getNameOfWifi()+"</td><td>"+nearestWifi.getAddress()+"</td><td>"+nearestWifi.getRadius()+"</td><td>"+nearestWifi.getLongitude()+"</td><td>"+nearestWifi.getLatitude()+"</td><td>"+nearestWifi.getPlace()+"</td><tr></table>");
	}
}
