package jums;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * 基本的にはやりたい1種類の動作に対して1メソッド
 * @author hayashi-s
 */
public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * データの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public ArrayList search(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            //
            String sql = "SELECT * FROM user_t";
            boolean flag = false;
            int check_name = 0;
            int check_birthday = 0;
            int check_type = 0;
            //ud.getName()＝入力フォームの情報がそのままきます
            if (!ud.getName().equals("")) {
                sql += " WHERE name like ?";
                flag = true;
                check_name++;
            }
            //セレクトフォームで選択されなかった場合はnullが返ってきます
            if (ud.getBirthday()!=null) {
                //if(trueの場合)という意味なので書きのif文は
                //flagがtrueでない場合という意味になる
                if(!flag){
                    sql += " WHERE birthday like ?";
                    flag = true;
                    check_birthday++;
                }else{
                    sql += " AND birthday like ?";
                    check_birthday++;
                }
            }
            //ラジオボタン選択を何もされなければ0が返ってきます
            if (ud.getType()!=0) {
                if(!flag){
                    sql += " WHERE type like ?";
                    check_type++;
                }else{
                    sql += " AND type like ?";
                    check_type++;
                }
            }
            st =  con.prepareStatement(sql);
            
            //if文でそれぞれの選択パターン別にSQL文へ送るコードを分岐
            if(check_name == 1){
            st.setString(1, "%"+ud.getName()+"%");
            }
            if(check_name == 1 && check_birthday == 1){
            st.setString(1, "%"+ud.getName()+"%");
            //timeスタンプ型で送られてきたBirthdayの情報を
            //SimpleDateFormatで年のみを文字列へ直してSQL文へ送っている
            st.setString(2, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
            }
            if(check_name == 1 && check_type == 1){
            st.setString(1, "%"+ud.getName()+"%");
            st.setInt(2, ud.getType());
            }
            if(check_name == 1 && check_birthday == 1 && check_type == 1){
            st.setString(1, "%"+ud.getName()+"%");
            st.setString(2, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
            st.setInt(3, ud.getType());
            }
            if(check_birthday == 1){
            st.setString(1, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
            }
            if(check_birthday == 1 && check_type == 1){
            st.setString(1, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
            st.setInt(2, ud.getType());
            }
            if(check_type == 1){
            st.setInt(1, ud.getType());
            }
            
            ResultSet rs = st.executeQuery();
            //UserDataDTOへそれぞれの情報を格納
            ArrayList<UserDataDTO> hako = new ArrayList<UserDataDTO>();
            
            while(rs.next()){
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            hako.add(resultUd);
            }
            System.out.println("search completed");
            return hako;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * ユーザーIDによる1件のデータの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE userID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            
            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            
            System.out.println("searchByID completed");

            return resultUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    //検索されたデータを更新を行う
     public void update(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            
            con = DBManager.getConnection();
          
            st =  con.prepareStatement("update user_t set name = ?,birthday = ?,tell = ?,type = ?,comment = ?,newDate = ? where userID = ?");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.setInt(7, ud.getUserID());
            
            st.executeUpdate();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
     
    /**
     *
     * @param ud
     * @throws SQLException
     */
    public void Delete(UserDataDTO ud) throws SQLException{
     Connection con = null;
     PreparedStatement st = null;
     try{
         
    con = DBManager.getConnection();
    
     st =  con.prepareStatement("delete from user_t where userID = ?");
            st.setInt(1, ud.getUserID());
            
            st.executeUpdate();
    }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
     }
     
     
     
     
     
}
