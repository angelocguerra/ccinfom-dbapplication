<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, assetmanagement.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Record Rental Processing</title>
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
            <h1>Record Asset Rental</h1>
            <jsp:useBean id="A" class="assetmanagement.asset_rentals" scope="session" />
            <% // Receive the values from record-rental.html
            
                    String v_asset_id = request.getParameter("asset_id");
                    A.assetID = Integer.parseInt(v_asset_id);

                    String v_rental_date = request.getParameter("rental_date");
                    A.transactionDate = v_rental_date;
                    A.rentalDate = v_rental_date;

                    String v_resident_id = request.getParameter("resident_id");
                    A.residentID = Integer.parseInt(v_resident_id);

                    String v_officer_id = request.getParameter("officer_id");
                    A.transHOID = Integer.parseInt(v_officer_id);
                    
                    String v_officer_position = request.getParameter("officer_position");
                    A.transPosition = v_officer_position;
                    
                    String v_date_elected = request.getParameter("date_elected");
                    A.transElectionDate = v_date_elected;
                    
                    String v_rental_amount = request.getParameter("rental_amount");
                    A.rentalAmount = v_rental_amount;

                    String v_discount = request.getParameter("discount");
                    A.discount = v_discount;
                    
                    String v_orno = request.getParameter("or_no");
                    A.orNum = v_orno;

                    int status = A.recordRental();

                    if(status == 1) {
            %>
                        <h5>New Asset Rental Successfully Recorded</h5>
            <%      } else {
            %>
                        <h5>Failed to Record New Asset Rental</h5>
            <%  }
            %>
            <input type="submit" value="BACK TO MENU" class="submit">
        </form>
    </body>
</html>