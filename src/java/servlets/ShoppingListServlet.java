package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author anant
 */
public class ShoppingListServlet extends HttpServlet {
    private ArrayList <String> item = new ArrayList<>();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        String user = (String) session.getAttribute("user");
        if (action != null && action.equals("logout")){
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        
        if (user == null){
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return; 
        }
        
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String user = request.getParameter("user");
        String itemname = request.getParameter("itemname");
        
        if (action != null && action.equals("register")){
            
            if (user != null){
                session.setAttribute("user", user);
                response.sendRedirect("ShoppingList");
                return;
            }
            else{
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
        }
        
        if (action != null && action.equals("add")){
            item.add(itemname);
            session.setAttribute("itemlist", item);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
        if (action != null && action.equals("delete")){
            String deleteitem = request.getParameter("item");
            item.remove(itemname);
            session.setAttribute("itemlist", item);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
    }

    
}
