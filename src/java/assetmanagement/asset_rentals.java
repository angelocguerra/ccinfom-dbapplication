package assetmanagement;
import java.sql.*;

public class asset_rentals {
    // fields of asset rentals
    public int assetID;
    public String rentalDate;
    public String oldRentalDate;
    public String reservationDate;
    public String transactionDate;
    public int transHOID;
    public String transPosition;
    public String transElectionDate;
    public int residentID;
    public String rentalAmount;
    public String discount;
    public String status;
    public String inspectionDetails = null;
    public double assessedValue;
    public int acceptHoId;
    public String acceptPosition = null;
    public String acceptElectionDate = null;
    public String returnDate = null;
    public int approvalHOID;
    public String approvalElectionDate = null;
    public String orNum;
        
    public asset_rentals() {}
    
    public int recordRental(){
        try{
            // 1. Connect to database
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. SQL statements
            
            // PreparedStatement pstmt = conn.prepareStatement("INSERT INTO asset_rentals VALUE (?, ?, NOW(), ?, ?, ?, ?, null, null, null, null, null, null)");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO asset_transactions VALUE(?, ?, ?, ?, ?, 0, null, null, null, ?, 'R')");
            pstmt.setInt(1, assetID);
            pstmt.setString(2, transactionDate);
            pstmt.setInt(3, transHOID);
            pstmt.setString(4, transPosition);
            pstmt.setString(5, transElectionDate);
            
            if (orNum.equals("null")){
                pstmt.setString(6, null);
            } else{
                pstmt.setInt(6, Integer.parseInt(orNum));
            }
            
            pstmt.executeUpdate();
            pstmt.close();
            
            PreparedStatement pstate = conn.prepareStatement("INSERT INTO asset_rentals VALUE(?, ?, NOW(), ?, ?, ?, 'R', null, null, null, null, null, null)");
            pstate.setInt(1,assetID);
            
            pstate.setString(2, rentalDate);
            pstate.setInt(3, residentID);
            
            if (rentalAmount.equals("null")){
                pstate.setString(4, null);
            } else{
                pstate.setDouble(4, Double.parseDouble(rentalAmount));
            }
            
            if (discount.equals("null")){
                pstate.setString(5, null);
            } else{
                pstate.setDouble(5, Double.parseDouble(discount));
            }
            
            pstate.executeUpdate();
            pstate.close();
            conn.close();
            
            System.out.println("Successfully recorded new rental into asset rental list");
            return 1;
            
        } catch (Exception e){
            System.out.println("Failed to record new rental into asset rental list");
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int updateRentalInfo(){
        try{
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            PreparedStatement pstate = conn.prepareStatement("UPDATE asset_transactions SET trans_hoid=?, trans_position=?, trans_electiondate=?, ornum=? WHERE asset_id=? AND transaction_date=?");
            
            pstate.setInt(1, transHOID);
            pstate.setString(2, transPosition);
            pstate.setString(3, transElectionDate);
            
            if (orNum.equals("null")){
                pstate.setString(4, null);
            } else{
                pstate.setInt(4, Integer.parseInt(orNum));
            }
            
            pstate.setInt(5, assetID);
            pstate.setString(6, rentalDate);
            
            pstate.executeUpdate();
            pstate.close();
            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE asset_rentals SET reservation_date=?, resident_id=?, rental_amount=?, discount=?, status=? WHERE asset_id=? AND rental_date=?");
            
            pstmt.setString(1, reservationDate);
            pstmt.setInt(2,residentID);
            
            if (rentalAmount.equals("null")){
                pstmt.setString(3, null);
            } else{
                pstmt.setDouble(3, Double.parseDouble(rentalAmount));
            }
            
            if (discount.equals("null")){
                pstmt.setString(4, null);
            } else{
                pstmt.setDouble(4, Double.parseDouble(discount));
            }
            
            pstmt.setString(5, status);
            pstmt.setInt(6, assetID);
            pstmt.setString(7, rentalDate);
            
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
    
    public int returnRental(){
        try{
            // 1. Connect to database
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678"); //TODO: Fill out
            System.out.println("Connection Successful");
            
            // TODO: Find more suitable WHERE statement to ensure accuracy of chosen rental info
            PreparedStatement pstmt = conn.prepareStatement("UPDATE asset_rentals SET status='N', inspection_details=?, assessed_value=?, accept_hoid=?, accept_position=?, accept_electiondate=?, return_date=NOW() WHERE asset_id=? AND resident_id=?");
            pstmt.setString(1, inspectionDetails);
            pstmt.setDouble(2, assessedValue);
            pstmt.setInt(3, acceptHoId);
            pstmt.setString(4, acceptPosition);
            pstmt.setString(5, acceptElectionDate);
            
            pstmt.setInt(6, assetID);
            pstmt.setInt(7, residentID);
            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            
            System.out.println("Successfully returned rented asset");
            return 1;
           
        } catch(Exception e){
            System.out.println("Failed to return rented asset");
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int deleteRentalInfo(){
        try{
            // 1. Connect to database
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678"); //TODO: Fill out
            System.out.println("Connection Successful");
            
            //TODO: Find more suitable WHERE statement to ensure accuracy of chosen rental info
            PreparedStatement pstmt = conn.prepareStatement("UPDATE asset_transactions SET isdeleted='1', approval_hoid=?, approval_position='President', approval_electiondate=? WHERE asset_id=? AND transaction_date=?");
            
            pstmt.setInt(1, approvalHOID);
            pstmt.setString(2, approvalElectionDate);
            pstmt.setInt(3, assetID);
            pstmt.setString(4, transactionDate);
            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            
            System.out.println("Successfully deleted rental info from asset list");
            return 1;
            
        } catch(Exception e){
            System.out.println("Failed to delete rental info from asset list");
            System.out.println(e.getMessage());
            return 0;
        }
    }
}