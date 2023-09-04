package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet(urlPatterns = "/calbmi")
public class BMICalculatorServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        double weight = Double.parseDouble(request.getParameter("weight"));
        double heightInMeters = Double.parseDouble(request.getParameter("height"));
        //TODO: calculate bmi
        double BMI = Math.round(weight / (heightInMeters * heightInMeters));
        //TODO: determine the built from BMI
        String BUILT;
        if (BMI < 18.5) {
            BUILT = "underweight";
        } else if (BMI >= 18.5 && BMI < 25) {
            BUILT = "normal";
        } else if (BMI >= 25 && BMI < 30) {
            BUILT = "overweight";
        } else if (BMI >= 30 && BMI < 35) {
            BUILT = "obese";
        } else {
            BUILT = "extremely obese";
        }
        //TODO: add bmi and built to the request's attribute
        request.setAttribute("bmi", BMI);
        request.setAttribute("bodyType", BUILT);
        //TODO: forward to jsp
        request.getRequestDispatcher("bmi_result.jsp").forward(request, response);
    }
}
