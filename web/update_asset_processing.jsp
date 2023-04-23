<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, assetmanagement.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Asset Info Processing</title>
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
            <h1>Update Asset Information</h1>
            <jsp:useBean id="A" class="assetmanagement.assets" scope="session" />
            <% // Receive the values from register-asset.html
            
                    String v_asset_id = request.getParameter("asset_id");
                    A.assetID = Integer.parseInt(v_asset_id);

                    String v_asset_name = request.getParameter("asset_name");
                    A.assetName = v_asset_name;

                    String v_asset_description = request.getParameter("asset_description");
                    A.assetDescription = v_asset_description;

                    String v_is_for_rent = request.getParameter("is_for_rent");
                    A.isForRent = Integer.parseInt(v_is_for_rent);

                    String v_asset_value = request.getParameter("asset_value");
                    A.assetValue = Double.parseDouble(v_asset_value);

                    String v_type_asset = request.getParameter("type_asset");
                    A.typeAsset = v_type_asset;

                    String v_status = request.getParameter("status");
                    A.status = v_status;

                    String v_loc_latitude = request.getParameter("loc_latitude");
                    A.locLatitude = Double.parseDouble(v_loc_latitude);

                    String v_loc_longitude = request.getParameter("loc_longitude");
                    A.locLongitude = Double.parseDouble(v_loc_longitude);

                    String v_hoa_name = request.getParameter("hoa_name");
                    A.hoaName = v_hoa_name;

                    String v_enclosing_asset = request.getParameter("enclosing_asset");
                    A.enclosingAsset = v_enclosing_asset;

                    int status = A.updateAssetInformation();

                    if(status == 1) {
            %>
                        <h5>Asset Information Successfully Updated</h5>
            <%      } else {
            %>
                        <h5>Failed to Update Asset Information</h5>
            <%  }
            %>
            <input type="submit" value="BACK TO MENU" class="submit">
        </form>
    </body>
</html>