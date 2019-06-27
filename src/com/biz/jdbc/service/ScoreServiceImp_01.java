package com.biz.jdbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.jdbc.config.Dbconnection;
import com.biz.jdbc.model.ScoreVO;

public class ScoreServiceImp_01 implements ScoreService {

	Connection dbcon=null;
	List<ScoreVO> scList=null;
	
	public ScoreServiceImp_01() {
		this.dbcon=Dbconnection.getDBconnection();
		
	}
	
	private void dbConnection() {

//		String jdbcDriver="oracle.jdbc.driver.OracleDriver";
//		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
//		String userName="user5";
//		String pssword="1234";
//		
//		try {
//			Class.forName(jdbcDriver);
//			con=DriverManager.getConnection(url, userName, pssword);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}  
	 
	@Override
	public List<ScoreVO> selecAll() {
		// TODO Auto-generated method stub
		
		String sql=" SELECT * FROM tbl_score ";
		PreparedStatement pSer=null;
		try {
			pSer=dbcon.prepareStatement(sql);
			ResultSet rs=pSer.executeQuery();
			
			scList=new ArrayList<ScoreVO>();
			while(rs.next()) {
				ScoreVO vo=new ScoreVO();
				/*
				 *  SC_SEQ
					SC_DATE
					SC_ST_NO
					SC_SUBJECT
					SC_SCORE
				 */
				vo.setSc_seq(rs.getLong("sc_seq"));
				vo.setSc_date(rs.getString("sc_date"));
				vo.setSc_st_no(rs.getString("sc_st_no"));
				vo.setSc_subject(rs.getString("sc_subject"));
				vo.setSc_score(rs.getInt("sc_score"));
				scList.add(vo);
			}
			return scList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ScoreVO findById(long sc_seq) {
		// TODO Auto-generated method stub
		String sql=" SELECT * FROM tbl_score ";
		sql += " WHERE sc_seq " +sc_seq;
		PreparedStatement pSer=null;
		try {
			pSer=dbcon.prepareStatement(sql);
			ResultSet rs=pSer.executeQuery();
			
			scList=new ArrayList<ScoreVO>();
			if(rs.next()) {
				ScoreVO vo=new ScoreVO();
				/*
				 *  SC_SEQ
					SC_DATE
					SC_ST_NO
					SC_SUBJECT
					SC_SCORE
				 */
				vo.setSc_seq(rs.getLong("sc_seq"));
				vo.setSc_date(rs.getString("sc_date"));
				vo.setSc_st_no(rs.getString("sc_st_no"));
				vo.setSc_subject(rs.getString("sc_subject"));
				vo.setSc_score(rs.getInt("sc_score"));
				return vo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insert(ScoreVO vo) {
		// TODO Auto-generated method stub
		String sql=" INSERT INTO tbl_score ( ";
		sql += " SC_SEQ, ";
		sql += " SC_DATE, ";
		sql += " SC_ST_NO, ";
		sql += " SC_SUBJECT, ";
		sql += " SC_SCORE ";
		sql += " VALUES( SEQ_SCORE.NEXTVAL ,?,?,?,? ) ";
		return 0;
	}

	@Override
	public int update(ScoreVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long sc_sep) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public List<ScoreVO> findByNum(String st_no) {
		// TODO Auto-generated method stub
		String sql=" SELECT * FROM tbl_score ";
		sql += " WHERE sc_st_no = "+st_no;
		PreparedStatement pSer=null;
		try {
			pSer=dbcon.prepareStatement(sql);
			ResultSet rs=pSer.executeQuery();
			
			scList=new ArrayList<ScoreVO>();
			while(rs.next()) {
				ScoreVO vo=new ScoreVO();
				/*
				 *  SC_SEQ
					SC_DATE
					SC_ST_NO
					SC_SUBJECT
					SC_SCORE
				 */
				vo.setSc_seq(rs.getLong("sc_seq"));
				vo.setSc_date(rs.getString("sc_date"));
				vo.setSc_st_no(rs.getString("sc_st_no"));
				vo.setSc_subject(rs.getString("sc_subject"));
				vo.setSc_score(rs.getInt("sc_score"));
				scList.add(vo);
			}
			return scList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
