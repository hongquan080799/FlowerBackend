package com.abc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.abc.model.Thongke;

public class DAO {
	Connection con;
	public DAO() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=FLOWER;username=sa;password=Hongquan123");
			System.out.println("connected !!!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public List<Thongke> getListTK(){
		List<Thongke> list = new ArrayList<Thongke>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("exec SP_THONGKE");
			while(rs.next()) {
				Thongke tk = new Thongke();
				tk.setMasp(rs.getString(1));
				tk.setTensp(rs.getString(2));
				tk.setSoluong(rs.getInt(3));
				list.add(tk);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		System.out.println(new DAO().getListTK());
	}
}
