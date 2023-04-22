<!DOCTYPE html>
<!--
    This file displays the page for the Register Asset feature.
-->
<html>
    <head>
        <title>Register Asset</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="CSS/register-asset.css">
        <style>
            html {
                background: linear-gradient(0deg, rgba(15,15,15,0.7), rgba(15,15,15,0.7)),
                    url('Assets/goks-bg.png') no-repeat center center fixed;
                background-size: cover;
                margin-top: 25px;
                margin-left: 50px;
                margin-right: 50px;
            }
        </style>
    </head>
    
    <body>
        <h1>Register Asset</h1>
        
        <form action="register_processing.jsp">
            <h5>Asset Name                  <input type="text" id="asset_name" name="asset_name"><br>
                Asset Description           <input type="text" id="asset_description" name="asset_description"><br>
                Is the Asset for Rent?      <select id="is_for_rent" name="is_for_rent" style="width:100px;">
                    <option value="1">YES</option>
                    <option value="0">NO</option>
                </select><br>
                Asset Value                 <input type="text" id="asset_value" name="asset_value" style="width:150px;"><br>
                Asset Type                  <select id="type_asset" name="type_asset">
                    <option value="F">Furniture</option>
                    <option value="P">Property</option>
                    <option value="E">Equipment</option>
                    <option value="O">Others</option>
                </select><br>
                Location Latitude           <input type="text" id="loc_latitude" name="loc_latitude" style="width:200px;"><br>
                Location Longitude          <input type="text" id="loc_longitude" name="loc_longitude" style="width:200px;"><br>
                HOA Name                    <input type="text" id="hoa_name" name="hoa_name"><br>
                Enclosing Asset             <input type="text" id="enclosing_asset" name="enclosing_asset">
            </h5>
            <input type="reset" value="CLEAR" class="reset">
            <input type="submit" value="SUBMIT" class="submit">
        </form>
    </body>
</html>