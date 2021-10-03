package com.bridgelabz.employeepayrolljdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollService {

	public static void main(String[] args) {

		System.out.println("Welcome to the JDBC");

		EmployeePayrollService employeepayrollservice = new EmployeePayrollService();
		List<Employee> employeeInfor = employeepayrollservice.retrieveData();
		employeeInfor.stream().forEach(e -> System.out.println(e.getId() + "     " + e.getName() + "    "
				+ e.getAddress() + "     " + e.getGender() + "     " + e.getPhone() + "      " + e.getStartdate()));
	}

	public List<Employee> retrieveData() {
		ResultSet resultSet = null;
		List<Employee> employeeInfoList = new ArrayList<>();
		try (Connection connection = JdbcConnection.getConnection()) {
			Statement statement = connection.createStatement();
			String sql = "select * from employee where id=2";
			resultSet = statement.executeQuery(sql);
			int count = 1;
			while (resultSet.next()) {
				count++;
				Employee employeeInfo = new Employee();
				employeeInfo.setId(resultSet.getInt("id"));
				employeeInfo.setName(resultSet.getString("name"));
				employeeInfo.setAddress(resultSet.getString("address"));
				employeeInfo.setPhone(resultSet.getString("phone"));
				employeeInfo.setGender(resultSet.getString("gender").charAt(0));
				employeeInfo.setStartdate(resultSet.getDate("startdate").toLocalDate());
				employeeInfoList.add(employeeInfo);
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
		return employeeInfoList;
	}

}
