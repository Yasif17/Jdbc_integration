package org.com.jdbc_integration;

import org.com.jdbc_integration.config.DatabaseConnection;
import org.com.jdbc_integration.dao.ProductDao;

public class Main {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
//        productDao.createTable();


//        productDao.insertRecord("Samosa",10.5,10);
//          productDao.getAllRecords();

//        productDao.updateRecord(1,"Samosa",15.5,10);
//        productDao.deleteRecord(1);

        productDao.getRecordById(2);



    }

}