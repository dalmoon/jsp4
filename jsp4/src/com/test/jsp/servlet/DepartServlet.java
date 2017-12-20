package com.test.jsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.jsp.service.DepartService;
import com.test.jsp.service.DepartServiceImpl;

public class DepartServlet extends HttpServlet {

	DepartService ds = new DepartServiceImpl();

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doProcess(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doProcess(req, res);
	}
	private String getCommandFormUri(String uri) {
		int idx = uri.lastIndexOf("/");
		if(idx!=-1) {
			return uri.substring(idx+1);
		}
		return uri;
	}
	public void doProcess(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		
		String uri = req.getRequestURI();
		String cmd = getCommandFormUri(uri);
		System.out.println(cmd);
		
		uri = uri.replace("/s", "/");
		if(cmd.equals("list")) {
			ds.selectDepartList(req);
		}else if(cmd.equals("view")) {
			
		}else if(cmd.equals("update")) {
			
		}else if(cmd.equals("insert")) {
			
		}else {
			uri = "/error";
		}
		RequestDispatcher rd = req.getRequestDispatcher(uri + ".jsp");
		rd.forward(req, res);
	}
}
