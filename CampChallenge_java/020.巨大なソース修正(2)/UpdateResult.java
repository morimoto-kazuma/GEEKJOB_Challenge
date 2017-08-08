package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class UpdateResult extends HttpServlet {

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
        //セッションスタート
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        try {
            //resultdetail.jsp(ユーザー情報詳細画面)のデータをセッションから呼び出し。
            UserDataDTO udd = (UserDataDTO)session.getAttribute("resultData");
            
            //UserDataBeansインスタンス生成
            UserDataBeans udb = new UserDataBeans();
            
            //UserDataBeansへ入力フォームを格納
            udb.setUserID(udd.getUserID());
            udb.setName(request.getParameter("name"));
            udb.setYear(request.getParameter("year"));
            udb.setMonth(request.getParameter("month"));
            udb.setDay(request.getParameter("day"));
            udb.setType(request.getParameter("type"));
            udb.setTell(request.getParameter("tell"));
            udb.setComment(request.getParameter("comment"));
            
            //UserDataDTOをUD2DTOMappingメソッドへ引数として渡す
            //UserDataDTO(searchData)へUserDataBeansのマッピングした情報を格納
            udb.UD2DTOMapping(udd);
            
            //UserDataDAOのupdateメソッドへUserDataDTOのデータを引数として渡す
           UserDataDAO.getInstance().update(udd);//←更新OK
           
           //UserDataDAOのsearchByIDメソッドへUserDataDTOを引数として渡す
           //更新結果用に書き換えられたデータをセッションへ格納
           session.setAttribute("resultData",UserDataDAO.getInstance().searchByID(udd));
           
           //searchresult.jspへ戻った時用にsearchメソッドのArrayListの新しいデータをセッションへ格納
           UserDataDTO search = (UserDataDTO)session.getAttribute("searchData");
           ArrayList resultsearch = UserDataDAO.getInstance().search(search);
           session.setAttribute("resultsearch", resultsearch);
           
           request.getRequestDispatcher("/updateresult.jsp").forward(request, response);
       }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
