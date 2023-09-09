package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Framework.AppException;

public class SP_CP_COORDENADASDAC extends SP_CP_SQLiteDataHelper {

    public ResultSet getMaxIdSexo() throws AppException{
        String query =" SELECT  COUNT(*) maxIdSexo"
                     +" FROM    SEXO"
                     +" WHERE   Estado ='A' ";

        try {
            Connection conn = openConnection();         // jdbc:sqlite:data\\TinderPet.db     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            return stmt.executeQuery(query);            // resultado
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass(), "getMaxIdSexo()");
        }
    }

    public ResultSet getAllSexo() throws AppException{
        String query =" SELECT  IdSexo, Nombre, Estado "
                     +" FROM    SEXO"
                     +" WHERE   Estado ='A' ";

        try {
            Connection conn = openConnection();         // jdbc:sqlite:data\\TinderPet.db     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            return stmt.executeQuery(query);            // resultado
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass(), "getAllSexo()");
        }
    }

    public ResultSet getSexoById(int IdSexo) throws AppException  {
        String query =   " SELECT  IdSexo, Nombre, Estado "
                        +" FROM    SEXO"
                        +" WHERE   Estado ='A'"
                        +" AND     IdSexo = ? ";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setInt(1, IdSexo);
            return pstmt.executeQuery();
        } 
        catch (SQLException e) {
            //System.out.println(sql);
            throw new AppException(e, getClass(), "getSexoById()");
        }
    }

    public ResultSet getSexoByNombre(String nombre) throws AppException  {
        String query =   " SELECT  IdSexo, Nombre, Estado "
                        +" FROM    SEXO"
                        +" WHERE   Estado ='A'"
                        +" AND     Nombre = ? ";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, nombre);
            return pstmt.executeQuery();
        } 
        catch (SQLException e) {
            //System.out.println(sql);
            throw new AppException(e, getClass(), "getSexoById()");
        }
    }

    public boolean insertSexo(String nombre) throws AppException  {
        String query = " INSERT INTO SEXO (Nombre) VALUES (?)";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, nombre);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass(), "getSexoById()");
        }
    }

    public boolean updateSexo(int IdSexo, String nombre) throws AppException  {
        String query = " UPDATE SEXO SET Nombre = ? WHERE IdSexo = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, nombre);
            pstmt.setInt(2, IdSexo);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass(), "getSexoById()");
        }
    }
    public boolean deleteSexo(int IdSexo) throws AppException  {
        String query = " UPDATE SEXO SET Estado = ? WHERE IdSexo = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, IdSexo);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass(), "getSexoById()");
        }
    }
}