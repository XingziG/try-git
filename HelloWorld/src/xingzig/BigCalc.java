package xingzig;
/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.math.BigInteger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet computes two integers defined by the user
 * @author Xingzi Guo
 */

public class BigCalc extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //get the integers and operator from request
        String xStr = request.getParameter("x");
        String yStr = request.getParameter("y");
        String operations = request.getParameter("option");
        request.setAttribute("x", xStr);
        request.setAttribute("y", yStr);
        String result;
        result = compute(xStr, yStr, operations);
        request.setAttribute("result", result);

        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        // forward the request and response to index.jsp
        view.forward(request, response);
    }
    /**
     * This method is to compute the two integers
     * @param xStr - the BigInteger x
     * @param yStr - the BigInteger y
     * @param operation - the operation on the 2 BigIntegers
     * @return - the result of the computation
     */
    private String compute(String xStr, String yStr, String operation) {
        //validate the input x and y
        if (!((xStr.matches("^-?\\d+$")) && (yStr.matches("^-?\\d+$")))) {
            return "Please input valid integers!";
        }
        // Pass the validation test, we do the calculation on the xStr and yStr
        BigInteger x = new BigInteger(xStr);
        BigInteger y = new BigInteger(yStr);
        String result = "";
        switch (operation) {
            case "add":
                result = x.add(y).toString();
                break;

            case "multiply":
                result = x.multiply(y).toString();
                break;

            case "relativelyPrime":
                if (x.gcd(y).equals(new BigInteger("1"))) {
                    return "X and Y are relatively prime!";
                } else {
                    return "X and Y are not relatively prime!";
                }

            case "mod":
                if (y.compareTo(new BigInteger("0")) <= 0) {
                    return "The modulus should not be 0";
                } else {
                    result = x.mod(y).toString();
                }
                break;

            case "modInverse":
                if (y.compareTo(new BigInteger("0")) <= 0) {
                    return "The modulus should not be 0";
                } else if (!x.gcd(y).equals(new BigInteger("1"))) {
                    return "X and Y should be relatively prime!";
                } else {
                    result = x.modInverse(y).toString();
                }
                break;

            case "power":
                if (y.compareTo(new BigInteger("0")) >= 0 && y.compareTo(new BigInteger("65535")) <= 0) {
                    result = x.pow(y.intValue()).toString();
                } else {
                    return "The exponent should in range [0, 65535]";
                }
                break;
        }
        return "the result of " + x + " " + operation + " " + y + " is: " + result;
    }
}
