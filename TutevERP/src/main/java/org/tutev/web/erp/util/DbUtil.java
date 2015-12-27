package org.tutev.web.erp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.tutev.web.erp.entity.genel.Kisi;

public class DbUtil {

    public List<Kisi> getKisis()
    {
        List<Kisi> kisiList=new ArrayList<Kisi>();
        
        Connection connnection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try 
        {
            Class.forName("org.postgresql.Driver");
            connnection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/TERP","postgres","postgres");
            preparedStatement=connnection.prepareStatement("select * from gnl_kisi");
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) 
            {
                Kisi k=new Kisi();
                k.setId(resultSet.getLong("id"));
                k.setAd(resultSet.getString("name"));
                k.setSoyad(resultSet.getString("surname"));
                k.setDogumTarihi(resultSet.getDate("birth_date"));
                System.out.println(k.toString()); 
                kisiList.add(k);
            }
        } 
        catch(Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            try 
            {
                connnection.close();
                preparedStatement.close();
            } 
            catch (Exception e) 
            {
                System.err.println(e);
            }
        }
        return kisiList;
    }
    
}
