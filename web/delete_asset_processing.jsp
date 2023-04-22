<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, assetmanagement.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Asset Processing</title>
        <style>
            html {
                background: linear-gradient(0deg, rgba(15,15,15,0.7), rgba(15,15,15,0.7)),
                    url('Assets/goks-bg.png') no-repeat center center fixed;
                background-size: cover;
                margin-top: 25px;
                margin-left: 50px;
                margin-right: 50px;
            }
            h1 {
                text-align: center;
                font-size: 60px;
                color: white;
                font-family: 'Inter', sans-serif;
                border-radius: 15px;
                background: #0869d9;
                padding: 10px;
            }
            h5 {
                text-align: center;
                font-size: 30px;
                color: white;
                font-family: 'Inter', sans-serif;
            }
            form {
                display: block;
                text-align: center;
            }
            input.submit {
                height: 40px;
                width: 250px;
                font-size: 25px;
                font-family: 'Inter', sans-serif;
            }
        </style>
    </head>
    
    <body>
        <form action="index.html">
            <h1>Delete Asset</h1>
            <jsp:useBean id="A" class="assetmanagement.assets" scope="session" />
            <% // Receive the values from register-asset.html
                try {
                    String v_asset_id = request.getParameter("asset_id");
                    A.assetID = Integer.parseInt(v_asset_id);
                    
                    int status = A.deleteAsset();
                    
                    if(status == 1) {
            %>
                        <h5>Asset Successfully Deleted</h5>
            <%      }
                } catch (Exception e) {
            %>
                    <h5>Failed to Delete Asset</h5>
            <%  }
            %>
            <input type="submit" value="BACK TO MENU" class="submit">
        </form>
    </body>
</html>