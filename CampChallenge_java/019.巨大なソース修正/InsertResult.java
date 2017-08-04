package jums;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * insertresultと対応するサーブレット フォームから入力された値をセッション経由で受け取り、データベースにinsertする
 * 直接アクセスした場合はerror.jspに振り分け
 *
 * @author hayashi-s
 */
public class InsertResult extends HttpServlet {

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

        //セッションスタート
        HttpSession session = request.getSession();

        try {
            request.setCharacterEncoding("UTF-8");//セッションに格納する文字コードをUTF-8に変更
            String accesschk = request.getParameter("ac");
            if (accesschk.equals("null") || (Integer) session.getAttribute("ac") != Integer.parseInt(accesschk)) {
                throw new Exception("不正なアクセスです");
            }

            String year = (String) session.getAttribute("year");
            String month = (String) session.getAttribute("month");
            String day = (String) session.getAttribute("day");
            String total = year + "-" + month + "-" + day;

            //ユーザー情報に対応したDTOとBeansに格納していく
            //DTOへ格納
            UserDataDTO userdata = new UserDataDTO();

            userdata.setName((String) session.getAttribute("name"));
            userdata.setBirthday(total);
            userdata.setType(Integer.parseInt((String) session.getAttribute("type")));
            userdata.setTell((String) session.getAttribute("tell"));
            userdata.setComment((String) session.getAttribute("comment"));

            Date now = new Date();//現在日時を取得
            // SimpleDateFormat作成
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//現在日時をフォーマット
            session.setAttribute("sdf", sdf.format(now));//現在の日時をセッションへ保存
            userdata.setNewDate((String) session.getAttribute("sdf"));//セッションから現在日時を取得→DTOへ引数として渡す。

            //DAOへDBへデータの挿入
            UserDataDAO.getInstance().insert(userdata);

            request.getRequestDispatcher("/insertresult.jsp").forward(request, response);
        } catch (Exception e) {
            //データ挿入に失敗したらエラーページにエラー文を渡して表示
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
