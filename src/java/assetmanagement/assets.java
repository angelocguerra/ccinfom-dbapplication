/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assetmanagement;
import java.util.*;
import java.sql.*;
/**
 *
 * @author ccslearner
 */
public class assets {
    
    //fields
    public int  assetID;
    public String assetName;
    public String assetDescription;
    public String acquisitionDate;
    public int isForRent;
    public double assetValue;
    public String typeAsset;
    public String status;
    public double locLatitude;
    public double locLongitude;
    public String hoaName;
    public String enclosingAsset = null;
    
    //list of assets
    public ArrayList<Integer> assetIdList = new ArrayList<>();
    public ArrayList<String> assetNameList = new ArrayList<>();
    
//        <a href="register.html"> 1. Register Asset              </a><br>
//        <a href="register.html"> 2. Update Asset Information    </a><br>
//        <a href="register.html"> 3. Delete Asset                </a><br>
//        <a href="register.html"> 4. Dispose Asset               </a><br>

    
    public int registerAsset(){
        
        try {
            //code to interact with database
            //1. Connect to database
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678"); //TODO: Fill out
            System.out.println("Connection Successful");
            
            //2. sql statements
            
            //getting next asset ID
            PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(asset_id) + 1 AS newID FROM assets");
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()){
                assetID = rst.getInt("newID");
                System.out.println("new ID: " + assetID);
            }
            
            pstmt = conn.prepareStatement("INSERT INTO assets VALUE (?, ?, ?, NOW(), ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1,assetID);
            pstmt.setString(2, assetName);
            pstmt.setString(3, assetDescription);
            pstmt.setInt(4, isForRent);
            pstmt.setDouble(5, assetValue);
            pstmt.setString(6, typeAsset);
            pstmt.setString(7, status);
            pstmt.setDouble(8, locLatitude);
            pstmt.setDouble(9, locLongitude);
            pstmt.setString(10, hoaName);
           
            
            //TODO: Verify
            if (enclosingAsset.equals("null")){
                enclosingAsset = null;
                pstmt.setString(11, null);
            } else{
                pstmt.setString(11, enclosingAsset);
            }
            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            
            System.out.println("Successfully registered new asset: " +  "into asset list");
            return 1;
            
            
        } catch (Exception e){
            System.out.println("Failed to register new asset: " + assetName + " into asset list");
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int updateAssetInformation(){
        try{
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678"); //TODO: Fill out
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE assets SET asset_name=?, asset_description=?, forrent=?, asset_value = ?, type_asset=?, status=?, loc_lattitude=?, loc_longiture=?, hoa_name=?, enclosing_asset=? WHERE asset_id=?");
            
            pstmt.setString(1, assetName);
            pstmt.setString(2, assetDescription);
            pstmt.setInt(3, isForRent);
            pstmt.setDouble(4, assetValue);
            pstmt.setString(5, typeAsset);
            pstmt.setString(6, status);
            pstmt.setDouble(7, locLatitude);
            pstmt.setDouble(8, locLongitude);
            pstmt.setString(9, hoaName);
            
            if(enclosingAsset.equals("null")){
                pstmt.setString(10, null);
            } else{
                pstmt.setInt(10, Integer.parseInt(enclosingAsset));
            }
            
            pstmt.setInt(11, assetID);
            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            
            System.out.println("Successfully updated asset: " +  "in asset list");
            return 1;
        }catch(Exception e){
            System.out.println("Failed to update asset: " + assetName + " in asset list");
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int deleteAsset(){
        try{
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678"); //TODO: Fill out
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM assets WHERE asset_id=?");
            pstmt.setInt(1, assetID);
            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            
            System.out.println("Successfully deleted asset: " +  "from asset list");
            return 1;
        }catch(Exception e){
            System.out.println("Failed to delete asset: " + assetName + " from asset list");
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int disposeAsset(){
        try{
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678"); //TODO: Fill out
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE assets SET status='X' WHERE asset_id=?");
            pstmt.setInt(1, assetID);
            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            
            System.out.println("Successfully disposed asset: " + assetName + "from asset list");
            return 1;
        }catch(Exception e){
            System.out.println("Failed to dispose asset: " + assetName + " from asset list");
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int recordRental(){
        return 0;
    }
    
    public int returnRental(){
        return 0;
    }
    
    public int updateRentalInfo(){
        return 0;
    }
    
    public int deleteRentalInfo(){
        return 0;
    }
    
}
