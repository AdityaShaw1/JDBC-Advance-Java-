<%-- 
    Document   : s1
    Created on : 18 Jan, 2024, 12:13:39 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
            background-color: #fcf5c7;
        }

        .quote-container {
            text-align: center;
            padding: 200px;
            border-radius: 8px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            animation: fadeIn 10s ease-in-out;
        }

        @keyframes fadeIn {
            0% {
                opacity: 0;
                transform: translateY(-20px);
            }
            100% {
                opacity: 1;
                transform: translateY(0);
            }
        }
    </style>
    </head>
    <body bgcolor="#ffc09f">
         <div class="quote-container">
        <h2>"Hii! Welcome to Java World"</h2>
        <p>- Aditya</p>
    </div>
    <marquee>
        <h1>LOGIN SUCCESS!</h1>
        
    </marquee>
        
    </body>
</html>
