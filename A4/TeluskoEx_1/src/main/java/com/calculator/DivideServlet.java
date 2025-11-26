package com.calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DivideServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// super.service(req, resp);

		int a = Integer.parseInt(req.getParameter("num1"));
		int b = Integer.parseInt(req.getParameter("num2"));

		int divide = a / b;

		PrintWriter prt = resp.getWriter();
		prt.println("""
				<!DOCTYPE html>
				<html lang='en'>
				<head>
				<meta charset='UTF-8'>
				<meta name='viewport' content='width=device-width, initial-scale=1.0'>
				<title>Calculation Result</title>

				<style>
				    body {
				        margin: 0;
				        padding: 0;
				        background: #0d0f13;
				        font-family: 'Segoe UI', sans-serif;
				        display: flex;
				        align-items: center;
				        justify-content: center;
				        height: 100vh;
				        color: #fff;
				    }

				    .container {
				        background: #1a1d24;
				        width: 380px;
				        padding: 30px;
				        border-radius: 18px;
				        box-shadow: 0 0 25px rgba(0,0,0,0.5);
				        text-align: center;
				    }

				    h2 {
				        margin-bottom: 20px;
				        font-weight: 500;
				        color: #4da8ff;
				        letter-spacing: 1px;
				    }

				    .result-box {
				        background: #262a32;
				        padding: 20px;
				        border-radius: 10px;
				        border: 1px solid #3a3f49;
				        font-size: 22px;
				        margin-bottom: 20px;
				    }

				    a{
				        padding: 12px 22px;
				        background: #4da8ff;
				        color: #000;
				        text-decoration: none;
				        border-radius: 10px;
				        font-weight: bold;
				        transition: 0.25s;
				    }

				    a:hover {
				        background: #77c4ff;
				    }
				</style>

				</head>
				<body>

				<div class='container'>
				    <h2>Result</h2>
				    <div class='result-box'>
				        Result =  """ + " " + divide + """
				    </div>

				    <a href='HomePage.html'>Go Back</a>
				</div>

				</body>
				</html>
				""");
	}

}
