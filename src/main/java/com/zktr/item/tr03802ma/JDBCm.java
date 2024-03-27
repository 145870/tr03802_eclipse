package com.zktr.item.tr03802ma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.PreparableStatement;

public class JDBCm {
	public static void main(String[] args) throws Exception {
		// 加载驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 创建连接对象
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/fuxi?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8",
				"root", "123456");
		// 执行sql语句
		PreparedStatement stmt = conn.prepareStatement("select * from score");
		// 获取
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println(
					rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));

		}
		conn.close();
		stmt.close();
		rs.close();
	}
}
