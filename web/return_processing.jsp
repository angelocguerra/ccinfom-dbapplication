<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, assetmanagement.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Return Rental Processing</title>
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
                background: #4a8830;
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
            <h1>Return Asset Rental</h1>
            <jsp:useBean id="A" class="assetmanagement.asset_rentals" scope="session" />
            <% // Receive the values from register-asset.html

                try {
                    String v_inspection_details = request.getParameter("inspection_details");
                    A.inspectionDetails = v_inspection_details;
                    
                    String v_assessed_value = request.getParameter("assessed_value");
                    A.assessedValue = Double.parseDouble(v_assessed_value);
                    
                    String v_accept_hoid = request.getParameter("accept_hoid");
                    A.acceptHoId = Integer.parseInt(v_accept_hoid);
                    
                    String v_accept_position = request.getParameter("accept_position");
                    A.acceptPosition = v_accept_position;
                    
                    String v_accept_electiondate = request.getParameter("accept_electiondate");
                    A.acceptElectionDate = v_accept_electiondate;

                    String v_asset_id = request.getParameter("asset_id");
                    A.assetID = Integer.parseInt(v_asset_id);

                    String v_resident_id = request.getParameter("resident_id");
                    A.residentID = Integer.parseInt(v_resident_id);
                    
                    int status = A.returnRental();
                    
                    if(status == 1) {
            %>
                        <h5>Asset Rental Successfully Returned</h5>
            <%      } else {
            %>
                        <h5>Failed to Return Asset Rental</h5>
            <%  }
            %>
            <input type="submit" value="BACK TO MENU" class="submit">
        </form>
    </body>
</html>