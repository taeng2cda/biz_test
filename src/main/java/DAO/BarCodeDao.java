package DAO;

import VO.BarCodeVo;
import jdbc.BarCode;
import jdbc.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BarCodeDao {
    public BarCodeDao(){}

    //바코드 정보 검색
    public BarCodeVo SelectBarcode(int id){

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from barcode where ID = ?";
        BarCodeVo vo = new BarCodeVo();

        try{
            con = JDBCUtil.getCon();;
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();

            while (rs.next()){
                String barcodeKey = rs.getString("barcodeKey");
                String title = rs.getString("title");
                String content = rs.getString("content");
                Date created_at = rs.getTimestamp("created_at");
                Date updated_at = rs.getTimestamp("updated_at");

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일   HH시 mm분");
                String format_Created_at = simpleDateFormat.format(created_at);
                String format_Updated_at = simpleDateFormat.format(updated_at);

                vo.setId(id);
                vo.setBarcodeKey(barcodeKey);
                vo.setTitle(title);
                vo.setContent(content);
                vo.setFormat_created_at(format_Created_at);
                vo.setFormat_updatred_at(format_Updated_at);
            }
            return vo;

        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }finally {
            JDBCUtil.close(con,pstmt,rs);
        }


    }

    //바코드 게시판 목록
    public ArrayList<BarCodeVo> BarcodeList(int startRow, int endRow , String column , String search){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "";

        try{
            con = JDBCUtil.getCon();

            if(column == null || column.equals("")){
                sql = "select * from barcode " +
                        "order by created_at  desc " +
                        "limit 10 offset ?";
            }else{
                sql = "select * from barcode ";
                    if(column.equals("barcodeKey")) sql += "where barcodeKey like '%"+ search +"%' ";
                    else if(column.equals("title")) sql += "where title like '%"+ search +"%' ";
                    else if(column.equals("content")) sql += "where content like '%"+search+"%' ";
                    else if(column.equals("title-content")) sql += "where title like '%"+ search +"%' or content like '%"+ search +"%' ";

                    sql += "order by created_at desc limit 10 offset ? ";
            }

            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,startRow);

            rs = pstmt.executeQuery();
            ArrayList list = new ArrayList<BarCodeVo>();

            while (rs.next()){
                int id = rs.getInt("id");
                String barcodeKey = rs.getString("barcodeKey");
                String title = rs.getString("title");
                String content = rs.getString("content");
                Date created_at = rs.getDate("created_at");
                Date updated_at = rs.getDate("updated_at");
                BarCodeVo vo = new BarCodeVo(id,barcodeKey,title,content,created_at,updated_at);
                list.add(vo);
            }
            return list;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }finally {
            JDBCUtil.close(con,pstmt,rs);
        }
    }


    //전체 글의 갯수 리턴
    public int getCount(){
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql ="select COUNT(ID) from barcode";
        ResultSet rs = null;

        try{
            con = JDBCUtil.getCon();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            return count;
        }catch (SQLException se){
            se.printStackTrace();
            return -1;
        }finally {
            JDBCUtil.close(con,pstmt,rs);
        }
    }



}
