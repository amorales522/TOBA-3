
package Controller;

import Database.AccountDB;
import Database.UserDB;
import JavaBeans.Account;
import JavaBeans.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NewCustomerServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
              
    String firstName = request.getParameter("fname");
    System.out.println(request.getParameter("fname"));
     System.out.println(request.getParameter("lname"));
    String lastName= request.getParameter("lname");
    String address= request.getParameter("address");
    String phno= request.getParameter("phno");
    String city= request.getParameter("city");
    String state= request.getParameter("state");
    String email= request.getParameter("email");
    String zipCode= request.getParameter("zipcode");
    if(firstName.equals("") ||lastName.equals("")||address.equals("")||phno.equals("")||city.equals("")||state.equals("")||email.equals("")||zipCode.equals(""))
    {
         request.getSession().setAttribute("error","Please fill out form completely.");
         response.sendRedirect("New_customer.jsp");
         
         return;
    }
    String username = lastName+zipCode;
    User user = new User(username,"welcome1",firstName,lastName,address,phno,state,city,email,zipCode);
    
    Account saving = new Account(25.0,user);
    saving.setType(Account.Type.Savings);
    Account checking = new Account(0,user);
    checking.setType(Account.Type.Checking);
    
    UserDB userdb = new UserDB();
    
    AccountDB accountdb = new AccountDB();
    accountdb.insertAccount(checking);
    accountdb.insertAccount(saving);
    
    
    userdb.insertUser(user);
    request.getSession().setAttribute("user", user);
    
    response.sendRedirect("Success.jsp");
        } finally {
            out.close();
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
