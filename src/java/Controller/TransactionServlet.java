
package Controller;

import Database.AccountDB;
import Database.TransactionDB;
import JavaBeans.Account;
import JavaBeans.Transaction;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TransactionServlet extends HttpServlet {

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
           String account = request.getParameter("account");
           String transaction = request.getParameter("transaction");
           int balance = Integer.parseInt(request.getParameter("balance"));
           AccountDB accountDb = new AccountDB();
        TransactionDB transactionDb = new TransactionDB();
           
           if(account.equals("saving"))
           {
               Account saving =(Account) request.getSession().getAttribute("saving");
               if(transaction.equals("Credit"))
               {
                   saving.setBalance(saving.getBalance() + balance);
                   accountDb.UpdateAccount(saving,"Savings");
                   Transaction tran = new Transaction (saving,balance,"credit");
                   transactionDb.insertTranction(tran,"Credit");
               }
               if(transaction.equals("Debit"))
               {
                   if(saving.getBalance() - balance> 0)
                   {
                   saving.setBalance(saving.getBalance() - balance);
                   accountDb.UpdateAccount(saving,"Savings");
                   Transaction tran = new Transaction (saving,balance,"Debit");
                   transactionDb.insertTranction(tran,"Debit");
                   }
               }
           }
           if(account.equals("checking"))
           {
               Account checking =(Account) request.getSession().getAttribute("checking");
               if(transaction.equals("Credit"))
               {
                   checking.setBalance(checking.getBalance() + balance);
                   accountDb.UpdateAccount(checking,"Checking");
                   Transaction tran = new Transaction (checking,balance,"credit");
                   transactionDb.insertTranction(tran,"Credit");
               }
               if(transaction.equals("Debit"))
               {
                   if(checking.getBalance() - balance> 0)
                   {
                   checking.setBalance(checking.getBalance() - balance);
                   accountDb.UpdateAccount(checking,"Checking");
                   Transaction tran = new Transaction (checking,balance,"Debit");
                   transactionDb.insertTranction(tran,"Debit");
                   }
               }
           }
            response.sendRedirect("Transaction.jsp");
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
