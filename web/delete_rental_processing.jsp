<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, assetmanagement.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Rental Processing</title>
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
            <h1>Delete Asset Rental Information</h1>
            <jsp:useBean id="A" class="assetmanagement.asset_rentals" scope="session" />
            <% // Receive the values from delete-rental.html
            
                    String v_officer_id = request.getParameter("officer_id");
                    A.approvalHOID = Integer.parseInt(v_officer_id);
                    
                    String v_date_elected = request.getParameter("date_elected");
                    A.approvalElectionDate = v_date_elected;
                    
                    String v_asset_id = request.getParameter("asset_id");
                    A.assetID = Integer.parseInt(v_asset_id);

                    String v_rental_date = request.getParameter("rental_date");
                    A.transactionDate = v_rental_date;

                    int status = A.deleteRentalInfo();

                    if(status == 1) {
            %>
                        <h5>Asset Rental Successfully Deleted</h5>
            <%      } else {
            %>
                        <h5>Failed to Delete Asset Rental</h5>
            <%  }
            %>
            <input type="submit" value="BACK TO MENU" class="submit">
        </form>
    </body>
</html>