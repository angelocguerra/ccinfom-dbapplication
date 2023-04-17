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
public class asset_rentals {
   //fields
    public int assetID;
    public String rentalDate;
    public String reservationDate;
    public int residentID;
    public String rentalAmount = null;
    public String discount = null;
    public String status;
    public String inspectionDetails = null;
    public String assessedValue = null;
    public String acceptHoId = null;
    public String acceptPosition = null;
    public String acceptElectionDate = null;
    public String returnDate = null;
    
    public int recordRental(){
        try{
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            //2. sql statements
//            public int assetID;                           1
//            public String rentalDate;                     2
//            public String reservationDate;                NOW()
//            public int residentID;                        3
//            public String rentalAmount = null;            4##
//            public String discount = null;                5##
//            public String status;                         6
//            public String inspectionDetails = null;       7##
//            public String assessedValue = null;           8##
//            public String accept_hoid = null;             9##
//            public String acceptPosition = null;          10##
//            public String acceptElectionDate = null;      11##
//            public String returnDate = null;              12##
            
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO asset_rentals VALUE (?, ?, NOW(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1,assetID);
            pstmt.setString(2, rentalDate);
            pstmt.setInt(3, residentID);
            
            if (rentalAmount.equals("null")){
                pstmt.setString(4, null);
            } else{
                pstmt.setDouble(4, Double.parseDouble(rentalAmount));
            }
            
            if (discount.equals("null")){
                pstmt.setString(5, null);
            } else{
                pstmt.setDouble(5, Double.parseDouble(discount));
            }
            
            pstmt.setString(6, status);
            
            if (inspectionDetails.equals("null")){
                pstmt.setString(7, null);
            } else{
                pstmt.setString(7, inspectionDetails);
            }
            
            if (assessedValue.equals("null")){
                pstmt.setString(8, null);
            } else{
                pstmt.setDouble(8, Double.parseDouble(assessedValue));
            }
            
            if (acceptHoId.equals("null")){
                pstmt.setString(9, null);
            } else{
                pstmt.setInt(9, Integer.parseInt(acceptHoId));
            }
            
            if (acceptPosition.equals("null")){
                pstmt.setString(10, null);
            } else{
                pstmt.setString(10, acceptPosition);
            }
            
            if (acceptElectionDate.equals("null")){
                pstmt.setString(11, null);
            } else{
                pstmt.setString(11, acceptElectionDate);
            }
            
            if (returnDate.equals("null")){
                pstmt.setString(12, null);
            } else{
                pstmt.setString(12, returnDate);
            }
            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            
            System.out.println("Successfully recorded new rental into asset rental list");
            return 1;
            
            
        } catch (Exception e){
            System.out.println("Failed to record new rental into asset rental list");
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int returnRental(){
        try{
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678"); //TODO: Fill out
            System.out.println("Connection Successful");
            
            //TODO: Find more suitable WHERE statement to ensure accuracy of chosen rental info
            PreparedStatement pstmt = conn.prepareStatement("UPDATE asset_rental SET status='N' WHERE asset_id=? AND residentID=?");
            pstmt.setInt(1, assetID);
            pstmt.setInt(2, residentID);
            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            
            System.out.println("Successfully returned asset");
            return 1;
        }catch(Exception e){
            System.out.println("Failed to return asset");
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int updateRentalInfo(){
        try{
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE asset_rentals SET asset_id=?, rental_date=?, reservation_date=?, resident_id=?, rental_amount=?, discount=?, status=?, inspection_details=?, assessed_value=?, accept_hoid=?, accept_position=?, accept_electiondate=?, return_date=?");
            
            pstmt.setInt(1,assetID);
            pstmt.setString(2, rentalDate);
            pstmt.setString(3, reservationDate);
            
            if (rentalAmount.equals("null")){
                pstmt.setString(5, null);
            } else{
                pstmt.setDouble(5, Double.parseDouble(rentalAmount));
            }
            
            if (discount.equals("null")){
                pstmt.setString(6, null);
            } else{
                pstmt.setDouble(6, Double.parseDouble(discount));
            }
            
            pstmt.setString(7, status);
            
            if (inspectionDetails.equals("null")){
                pstmt.setString(8, null);
            } else{
                pstmt.setString(8, inspectionDetails);
            }
            
            if (assessedValue.equals("null")){
                pstmt.setString(9, null);
            } else{
                pstmt.setDouble(9, Double.parseDouble(assessedValue));
            }
            
            if (acceptHoId.equals("null")){
                pstmt.setString(10, null);
            } else{
                pstmt.setInt(10, Integer.parseInt(acceptHoId));
            }
            
            if (acceptPosition.equals("null")){
                pstmt.setString(11, null);
            } else{
                pstmt.setString(11, acceptPosition);
            }
            
            if (acceptElectionDate.equals("null")){
                pstmt.setString(12, null);
            } else{
                pstmt.setString(12, acceptElectionDate);
            }
            
            if (returnDate.equals("null")){
                pstmt.setString(13, null);
            } else{
                pstmt.setString(13, returnDate);
            }
            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            
            System.out.println("Successfully updated rental info in asset rental list");
            return 1;
            
            
        } catch (Exception e){
            System.out.println("Failed to update rental info in asset rental list");
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int deleteRentalInfo(){
        try{
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678"); //TODO: Fill out
            System.out.println("Connection Successful");
            
            //TODO: Find more suitable WHERE statement to ensure accuracy of chosen rental info
            PreparedStatement pstmt = conn.prepareStatement("UPDATE asset_transaction SET isdeleted='1' WHERE transaction_date=?");
            pstmt.setString(1, rentalDate);
            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            
            System.out.println("Successfully deleted rental info from asset list");
            return 1;
        }catch(Exception e){
            System.out.println("Failed to delete rental info from asset list");
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
