
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConvertTemperatureServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
               String temperatureStr = request.getParameter("temperature");
		//double temperature = Double.parseDouble(request.getParameter("temperature"));
                 String sanitizedTemperatureStr = temperatureStr.trim().replaceAll("[^\\d.+-]", ""); // remove any non-digit, non-decimal point, non-plus, or non-minus characters
            Double temperature = Double.parseDouble(sanitizedTemperatureStr);
		String unit = request.getParameter("unit");
		double convertedTemperature = 0;
		if (unit.equals("Celsius")) {
			convertedTemperature = (temperature - 32) * 5 / 9;
		} else if (unit.equals("Fahrenheit")) {
			
                        convertedTemperature = (temperature * 9 / 5) + 32;
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>The converted temperature is: " + (int)convertedTemperature + " "+ unit+ "</h2>");
		out.flush();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
