/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movies;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rafael
 */
@WebServlet(name = "MovieSearch", urlPatterns = {"/MovieSearch"})
public class MovieSearch extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MovieSearch</title>");
            out.println("</head>");
            out.println("<body>");
            URL url = new URL("http://www.omdbapi.com/?s=" + 
                    request.getParameter("s"));

            ObjectMapper mapper = new ObjectMapper();

            Map<String, Object> map = mapper.readValue(url, Map.class);

            List list = (List) map.get("Search");

            for (Object item : list) {
                Map<String, Object> innerMap = (Map<String, Object>) item;
                for (String key : innerMap.keySet()) {
                    if("Poster".equals(key)) {
                         out.println("<img src=\"" + innerMap.get(key) +
                                 "\" alt=\"" + key +
                                 "\" height=\"250\" width=\"170\">");
                    } else {
                        out.println("<p>" + key + ": " + innerMap.get(key) + "</p>");
                    }
                }
            }

            /*            URL url = new URL("http://www.omdbapi.com/?t=True%20Grit&y=1969");

             ObjectMapper mapper = new ObjectMapper(); 
             Map<String, Object> map = mapper.readValue(url, Map.class);

             for (String key : map.keySet()) {          
             out.println("<p>" + key + ": " + map.get(key) + "</p>"); 
             }*/
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
