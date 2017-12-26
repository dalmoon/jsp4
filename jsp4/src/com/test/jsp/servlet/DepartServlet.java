package com.test.jsp.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.jsp.dto.DepartInfo;
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
		if (idx != -1) {
			return uri.substring(idx + 1);
		}
		return uri;
	}

	public void doProcess(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		String str = req.getCharacterEncoding();
		System.out.println(str);
		String uri = req.getRequestURI();
		String cmd = getCommandFormUri(uri);
		System.out.println(cmd);

		if (cmd.equals("list")) {
			String search = req.getParameter("searchOption");
			String searchStr = req.getParameter("diName");
			req.setAttribute("departList", ds.selectDepartList(search, searchStr));
		} else if (cmd.equals("view") || cmd.equals("update")) {
			String diNo = req.getParameter("dino");
			System.out.println(diNo);
			req.setAttribute("depart", ds.selectDepart(Integer.parseInt(diNo)));
		} else if (cmd.equals("insert")) {

		} else if (cmd.equals("insert_ok")) {
			String diName = req.getParameter("diName");
			String diEtc = req.getParameter("diEtc");
			DepartInfo di = new DepartInfo();
			di.setDiName(diName);
			di.setDiEtc(diEtc);
			req.setAttribute("insert", ds.insertDepart(di));
			uri = "/depart/list";
		} else if (cmd.equals("delete")) {
			int diNo = Integer.parseInt(req.getParameter("dino"));
			DepartInfo di = new DepartInfo();
			di.setDiNo(diNo);
			int result = ds.deleteDepart(di);
			String msg = "삭제 되었습니다.";
			if (result != 1) {
				msg = "삭제에 실패하였습니다.";
			}
			req.setAttribute("msg", msg);
			uri = "/depart/list";
		} else {
			uri = "/error";
		}
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view" + uri + ".jsp");
		rd.forward(req, res);
	}
}
